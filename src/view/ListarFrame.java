package view;

import java.awt.GridBagLayout;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.GerenciamentoFuncionarios;
import model.Gerente;
import model.Vendedor;

public class ListarFrame extends JFrameMelhorado {
	
	private static final long serialVersionUID = 1L;
	private static final String NOME_FRAME = "Listagem de Funcionários";
	private static final int LARGURA = 600;
	private static final int ALTURA = 600;
	
	public ListarFrame(GerenciamentoFuncionarios gerenciamentoFuncionarios, GerenciamentoFuncionariosFrame mainframe) {
		super(NOME_FRAME, LARGURA, ALTURA);
		
		var funcionarios = gerenciamentoFuncionarios.listarFuncionarios();

		JPanel panel = new JPanel(new GridBagLayout());
		
		var tabela = new TabelaFacil("Nome", "CPF", "Departamento", "Total de Vendas", "Comissão");

		for (var funcionario : funcionarios) {
			String nome = funcionario.getNome();
			String cpf = funcionario.getCpf();
			String departamento = funcionario.getDepartamento();
			if (funcionario instanceof Vendedor vendedor) {
				tabela.adicionarLinha(nome, cpf, departamento, vendedor.getTotalVendas(), "");
			} else if (funcionario instanceof Gerente gerente) {
				tabela.adicionarLinha(nome, cpf, departamento, "", gerente.getComissao());
			}
		}

		panel.add(tabela.gerar(), posicionar(0, 0));

		JButton voltarButton = new JButton("Voltar");
		voltarButton.addActionListener(event -> {
			this.dispose();
			mainframe.setVisible(true);
		});
		panel.add(voltarButton, posicionar(0, 1));

		this.add(panel);
	}
}
