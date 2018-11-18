package com.grupo9.view;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.grupo9.view.almoxarifado.AlmoxarifadoFrame;
import com.grupo9.view.venda.VendasFrame;

public class StartView extends JFrame implements Runnable {

	private static final long serialVersionUID = -3645680133960317751L;

	public void run() {
		try {
			StartView window = new StartView();
			window.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public StartView() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("E:/MEGA/_Projects_-_JAVA_SE/LojaCartuchoSYSTEM/src/com/grupo9/img/toner_48.png"));
		setResizable(false);
		initialize();
	}

	private void initialize() {
		setType(Type.POPUP);

		setTitle("Loja de Cartuchos");
		setBounds(100, 100, 384, 430);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		JLabel main_Logo = new JLabel("");
		main_Logo.setBounds(125, 10, 128, 128);
		main_Logo.setIcon(
				new ImageIcon("E:/MEGA/_Projects_-_JAVA_SE/LojaCartuchoSYSTEM/src/com/grupo9/img/toner_128.png"));
		getContentPane().add(main_Logo);

		JLabel main_LogoLabel = new JLabel("Loja de Cartuchos SYSTEM");
		main_LogoLabel.setBounds(61, 138, 256, 32);
		main_LogoLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		getContentPane().add(main_LogoLabel);

		JButton main_VendasButton = new JButton("Vendas");
		main_VendasButton.setBounds(125, 180, 128, 32);
		main_VendasButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new VendasFrame();
				dispose();
			}
		});
		getContentPane().add(main_VendasButton);

		JButton main_ComprasButton = new JButton("Compras");
		main_ComprasButton.setBounds(125, 222, 128, 32);
		main_ComprasButton.setEnabled(false);
		getContentPane().add(main_ComprasButton);

		JButton main_AlmoxarifadoButton = new JButton("Almoxarifado");
		main_AlmoxarifadoButton.setBounds(125, 264, 128, 32);
		main_AlmoxarifadoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AlmoxarifadoFrame();
				dispose();
			}
		});
		getContentPane().add(main_AlmoxarifadoButton);

		JButton main_SobreButton = new JButton("Sobre");
		main_SobreButton.setBounds(125, 348, 128, 32);
		main_SobreButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new SobreView();
			}
		});
		getContentPane().add(main_SobreButton);
	}
}
