package com.grupo9.view;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class SobreView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6693556397208787120L;
	private JPanel contentPane;

	public SobreView() {
		setResizable(false);
		setType(Type.UTILITY);
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:/MEGA/_Projects_-_JAVA_SE/LojaCartuchoSYSTEM/src/com/grupo9/img/Logo_64.png"));
		setTitle("Sobre");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 320, 352);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	
		JLabel sobre_LogoLabel = new JLabel("Loja de Cartuchos System");
		sobre_LogoLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		sobre_LogoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		sobre_LogoLabel.setBounds(21, 10, 272, 32);
		contentPane.add(sobre_LogoLabel);

		JLabel sobre_DesenvolvedoresLabel = new JLabel("Desenvolvedores");
		sobre_DesenvolvedoresLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		sobre_DesenvolvedoresLabel.setHorizontalAlignment(SwingConstants.CENTER);
		sobre_DesenvolvedoresLabel.setBounds(29, 42, 256, 32);
		contentPane.add(sobre_DesenvolvedoresLabel);

		JLabel sobre_DevNameLabel_1 = new JLabel("Lucas Barretto e Silva        RA 2481400");
		sobre_DevNameLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		sobre_DevNameLabel_1.setBounds(29, 74, 256, 16);
		contentPane.add(sobre_DevNameLabel_1);

		JLabel sobre_DevNameLabel_2 = new JLabel("Nome do Desenvolvedor aqui        RA 0000000");
		sobre_DevNameLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		sobre_DevNameLabel_2.setBounds(29, 98, 256, 16);
		contentPane.add(sobre_DevNameLabel_2);

		JLabel sobre_DevNameLabel_3 = new JLabel("Nome do Desenvolvedor aqui        RA 0000000");
		sobre_DevNameLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		sobre_DevNameLabel_3.setBounds(29, 122, 256, 16);
		contentPane.add(sobre_DevNameLabel_3);

		JLabel sobre_DevNameLabel_4 = new JLabel("Nome do Desenvolvedor aqui        RA 0000000");
		sobre_DevNameLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		sobre_DevNameLabel_4.setBounds(29, 146, 256, 16);
		contentPane.add(sobre_DevNameLabel_4);

		JLabel sobre_DevNameLabel_5 = new JLabel("Nome do Desenvolvedor aqui        RA 0000000");
		sobre_DevNameLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		sobre_DevNameLabel_5.setBounds(29, 170, 256, 16);
		contentPane.add(sobre_DevNameLabel_5);

		JLabel sobre_DevNameLabel_6 = new JLabel("Nome do Desenvolvedor aqui        RA 0000000");
		sobre_DevNameLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		sobre_DevNameLabel_6.setBounds(29, 194, 256, 16);
		contentPane.add(sobre_DevNameLabel_6);

		JLabel sobre_DevNameLabel_7 = new JLabel("Nome do Desenvolvedor aqui        RA 0000000");
		sobre_DevNameLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		sobre_DevNameLabel_7.setBounds(29, 218, 256, 16);
		contentPane.add(sobre_DevNameLabel_7);

		JLabel sobre_VersaoLabel = new JLabel("Vers\u00E3o 0.1a");
		sobre_VersaoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		sobre_VersaoLabel.setBounds(109, 250, 96, 32);
		contentPane.add(sobre_VersaoLabel);

		JLabel sobre_copyrightsLabel = new JLabel(" \u00A9 2018 Grupo9");
		sobre_copyrightsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		sobre_copyrightsLabel.setBounds(29, 286, 256, 16);
		contentPane.add(sobre_copyrightsLabel);

		setVisible(true);
	}
}
