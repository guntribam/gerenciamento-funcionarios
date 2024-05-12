package view;

import java.awt.GridBagConstraints;
import java.awt.HeadlessException;
import java.awt.Insets;

import javax.swing.JFrame;

public class JFrameMelhorado extends JFrame {
	
	
	public JFrameMelhorado(String title, int width, int height) throws HeadlessException {
		super(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setSize(width, height);
	}

	protected static GridBagConstraints posicionar(int x, int y) {
		var gbc = new GridBagConstraints();
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.insets = new Insets(10, 10, 10, 10);
		return gbc;
	}

}
