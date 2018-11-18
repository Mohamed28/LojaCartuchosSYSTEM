package com.grupo9.view.compras;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ComprasView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6460594420122299060L;
	private JPanel contentPane;

	public ComprasView() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:/MEGA/_Projects_-_JAVA_SE/LojaCartuchosSystem/src/img/logo_min.png"));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 480);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);
	}

}
