package view;

import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.GerenciamentoFuncionarios;

public class GerenciamentoFuncionariosFrame extends JFrameMelhorado {
	private static final long serialVersionUID = 1L;
	private static final String NOME_FRAME = "Gerenciamento de Funcionários";
	private static final int LARGURA = 600;
	private static final int ALTURA = 600;
	private GerenciamentoFuncionarios gerenciamentoFuncionarios;

	public GerenciamentoFuncionariosFrame() {
		super(NOME_FRAME, LARGURA, ALTURA);

		gerenciamentoFuncionarios = new GerenciamentoFuncionarios();

		JPanel panel = new JPanel(new GridBagLayout());

		JButton cadastrar = new JButton("Cadastrar");
		cadastrar.addActionListener(evento -> {
			this.setVisible(false);
			new CadastrarFrame(gerenciamentoFuncionarios, this);
		});

		JButton listar = new JButton("Listar");
		listar.addActionListener(evento -> {
			this.setVisible(false);
			new ListarFrame(gerenciamentoFuncionarios, this);
		});
		

		panel.add(cadastrar, posicionar(0, 0));
		panel.add(listar, posicionar(1, 0));

		this.add(panel);
	}

}
