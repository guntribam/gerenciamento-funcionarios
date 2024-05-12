package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.GerenciamentoFuncionarios;
import model.Gerente;
import model.Vendedor;

public class Interface {
	JFrame jFrame;
	GerenciamentoFuncionarios gerenciamentoFuncionarios;

	public Interface() {
		super();
		gerenciamentoFuncionarios = new GerenciamentoFuncionarios();
	}

	public void iniciar() {
		criarFrame("Gerenciamento de Funcionários", 400, 400);

		GridBagLayout layout = new GridBagLayout();
		JPanel panel = new JPanel(layout);

		JButton cadastrar = new JButton("Cadastrar");
		cadastrar.addActionListener(evento -> {
			jFrame.dispose();
			cadastrarFrame();
		});

		JButton listar = new JButton("Listar");
		listar.addActionListener(evento -> {
			jFrame.dispose();
			listarFrame();
		});

		panel.add(cadastrar, posicionar(0, 0));
		panel.add(listar, posicionar(1, 0));

		jFrame.add(panel);

	}

	private void listarFrame() {

		criarFrame("Listar Funcionários", 600, 600);

		var funcionarios = gerenciamentoFuncionarios.listarFuncionarios();

		JPanel panel = new JPanel(new GridBagLayout());

		var model = new DefaultTableModel(new Object[] { "Nome", "CPF", "Departamento", "Total de Vendas", "Comissão" },
				0);

		for (var funcionario : funcionarios) {
			String nome = funcionario.getNome();
			String cpf = funcionario.getCpf();
			String departamento = funcionario.getDepartamento();
			if (funcionario instanceof Vendedor) {
				Double totalVendas = ((Vendedor) funcionario).getTotalVendas();
				model.addRow(new Object[] { nome, cpf, departamento, totalVendas, "" });
			} else {
				Double comissao = ((Gerente) funcionario).getComissao();
				model.addRow(new Object[] { nome, cpf, departamento, "", comissao });
			}
		}
		JTable tabela = new JTable(model);

		JScrollPane scroll = new JScrollPane(tabela);

		panel.add(scroll, posicionar(0, 0));

		JButton voltarButton = new JButton("Voltar");
		voltarButton.addActionListener(event -> {
			jFrame.dispose();
			iniciar();
		});
		panel.add(voltarButton, posicionar(0, 1));

		jFrame.add(panel);

	}

	private void criarFrame(String nomeFrame, int width, int height) {
		jFrame = new JFrame(nomeFrame);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setVisible(true);
		jFrame.setSize(width, height);
	}

	private void cadastrarFrame() {
		criarFrame("Cadastrar Funcionários", 400, 400);

		JPanel panel = new JPanel(new GridBagLayout());

		panel.add(new JLabel("Nome: "), posicionar(0, 0));
		JTextField nomeField = new JTextField(20);
		panel.add(nomeField, posicionar(1, 0));

		panel.add(new JLabel("CPF: "), posicionar(0, 1));
		JTextField cpfField = new JTextField(20);
		panel.add(cpfField, posicionar(1, 1));

		panel.add(new JLabel("Departamento: "), posicionar(0, 2));
		JTextField departamentoField = new JTextField(20);
		panel.add(departamentoField, posicionar(1, 2));

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
			jFrame.dispose();
			iniciar();
		});

		voltarButton.addActionListener(event -> {
			jFrame.dispose();
			iniciar();
		});

		jFrame.add(panel);
	}

	private GridBagConstraints posicionar(int x, int y) {
		var gbc = new GridBagConstraints();
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.insets = new Insets(10, 10, 10, 10);

		return gbc;
	}

}
