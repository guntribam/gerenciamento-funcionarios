package view;

import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.GerenciamentoFuncionarios;

public class CadastrarFrame extends JFrameMelhorado {

	private static final long serialVersionUID = 1L;
	private static final String NOME_FRAME = "Cadastro de Funcionários";
	private static final int LARGURA = 600;
	private static final int ALTURA = 600;

	public CadastrarFrame(GerenciamentoFuncionarios gerenciamentoFuncionarios,
			GerenciamentoFuncionariosFrame mainframe) {
		super(NOME_FRAME, LARGURA, ALTURA);

		JPanel panel = new JPanel(new GridBagLayout());

		var nomeField = criarCampo(panel, "Nome: ", 0, 0, 1, 0);
		JTextField cpfField = criarCampo(panel, "CPF: ", 0, 1, 1, 1);
		JTextField departamentoField = criarCampo(panel, "Departamento: ", 0, 2, 1, 2);

		JComboBox<String> funcionarioCombo = new JComboBox<>(new String[] { "", "Vendedor", "Gerente" });
		panel.add(funcionarioCombo, posicionar(0, 3));

		JLabel labelTotalVendas = new JLabel("Total de Vendas: ");
		panel.add(labelTotalVendas, posicionar(0, 4));
		JTextField totalVendasField = new JTextField(20);
		panel.add(totalVendasField, posicionar(1, 4));
		labelTotalVendas.setVisible(false);
		totalVendasField.setVisible(false);

		funcionarioCombo.addActionListener(event -> {
			String itemSelecionado = (String) funcionarioCombo.getSelectedItem();

			if (!itemSelecionado.equals("Vendedor")) {
				labelTotalVendas.setVisible(false);
				totalVendasField.setVisible(false);
			} else {
				labelTotalVendas.setVisible(true);
				totalVendasField.setVisible(true);
			}
		});

		JButton salvarButton = new JButton("Salvar");
		panel.add(salvarButton, posicionar(0, 5));
		JButton voltarButton = new JButton("Voltar");
		panel.add(voltarButton, posicionar(1, 5));

		salvarButton.addActionListener(event -> {

			String nome = nomeField.getText();
			String cpf = cpfField.getText();
			String departamento = departamentoField.getText();
			if (funcionarioCombo.getSelectedItem().equals("Vendedor")) {
				Double totalVendas = Double.parseDouble(totalVendasField.getText());
				gerenciamentoFuncionarios.salvarFuncionario(nome, cpf, departamento, totalVendas);
			} else {
				gerenciamentoFuncionarios.salvarFuncionario(nome, cpf, departamento);
			}
			close(mainframe);
		});

		voltarButton.addActionListener(event -> close(mainframe));

		this.add(panel);
	}

	private JTextField criarCampo(JPanel panel, String nomeCampo, int labelX, int labelY, int fieldX, int fieldY) {
		panel.add(new JLabel(nomeCampo), posicionar(labelX, labelY));
		JTextField field = new JTextField(20);
		panel.add(field, posicionar(fieldX, fieldY));
		return field;
	}

	private void close(GerenciamentoFuncionariosFrame mainframe) {
		this.dispose();
		mainframe.setVisible(true);
	}

}
