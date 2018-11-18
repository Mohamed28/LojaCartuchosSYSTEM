package com.grupo9.view.venda;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import com.grupo9.model.Venda;
import com.grupo9.view.StartView;

public class VendasFrame extends JFrame {

	private static final long serialVersionUID = 6250552707623911144L;
	private static JPanel[] panes = { new EstoquePane(), new VendaPane(), new CadastroPane(), new PagamentoPane() };
	private static int paneIndex = 1;
	private static JPanel childrenPane = new JPanel();
	private static JLabel icone = new JLabel("");
	private static Venda venda = new Venda();
	private JButton buttonAvançar = new JButton();
	private JButton buttonVoltar = new JButton();
	private JButton buttonCancelar = new JButton();

	public VendasFrame() {
		setTitle("Vendas");
		setIconImage(Toolkit.getDefaultToolkit().getImage(
			"E:/MEGA/_Projects_-_JAVA_SE/LojaCartuchoSYSTEM/src/com/grupo9/img/toner_48.png")
		);
		setBounds(0, 0, 606, 384);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		childrenPane.setBounds(10, 96, 580, 206);
		childrenPane.setLayout(null);
		getContentPane().add(childrenPane);
		setPane(1);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 600, 22);
		menuBar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		getContentPane().add(menuBar);

		JMenu menuArquivo = new JMenu("Arquivo");
		menuArquivo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		menuBar.add(menuArquivo);

		JMenuItem itemNovaVenda = new JMenuItem("Nova Venda");
		itemNovaVenda.setFont(new Font("Tahoma", Font.PLAIN, 12));
		itemNovaVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVenda(new Venda());
				dispose();
				new VendasFrame();
				VendaPane.setListaModel();
			}
		});
		menuArquivo.add(itemNovaVenda);

		JMenuItem itemConsultarVendas = new JMenuItem("Consultar Vendas");
		itemConsultarVendas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		menuArquivo.add(itemConsultarVendas);
		itemConsultarVendas.setEnabled(false);

		JSeparator separator = new JSeparator();
		menuArquivo.add(separator);

		JMenuItem itemSair = new JMenuItem("Sair");
		itemSair.setFont(new Font("Tahoma", Font.PLAIN, 12));
		itemSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int decisao = JOptionPane.showConfirmDialog(null, "Deseja encerrar a aplicação?", "Encerrando...",
						JOptionPane.YES_NO_OPTION);
				if (decisao == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		menuArquivo.add(itemSair);

		buttonCancelar.setText("Cancelar");
		buttonCancelar.setBounds(10, 312, 96, 32);
		buttonCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		buttonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int decisao = JOptionPane.showConfirmDialog(null, "Deseja cancelar a operação?", "Cancelando...",
						JOptionPane.YES_NO_OPTION);
				if (decisao == JOptionPane.YES_OPTION) {
					dispose();
					new StartView().run();
				}
			}
		});
		getContentPane().add(buttonCancelar);

		buttonAvançar.setText("Avançar");
		buttonAvançar.setBounds(494, 312, 96, 32);
		buttonAvançar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		buttonAvançar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (paneIndex < panes.length) {
					paneIndex++;
					setPane(paneIndex);
				}
			}
		});
		getContentPane().add(buttonAvançar);

		buttonVoltar.setText("Voltar");
		buttonVoltar.setBounds(388, 312, 96, 32);
		buttonVoltar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		buttonVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (paneIndex > 1) {
					paneIndex--;
					setPane(paneIndex);
				}else if(paneIndex == 0) {
					paneIndex = 1;
					setPane(1);
				}
			}
		});
		getContentPane().add(buttonVoltar);

		JLabel labelVendas = new JLabel("Vendas");
		labelVendas.setFont(new Font("Tahoma", Font.BOLD, 24));
		labelVendas.setBounds(84, 32, 506, 64);
		getContentPane().add(labelVendas);
		
		icone.setBounds(10, 32, 64, 64);
		getContentPane().add(icone);
		
		setVisible(true);
	}

	public static void setPane(int paneRequested) {
		paneIndex = paneRequested;
		for (int index = 0; index < panes.length; index++) {
			panes[index].setVisible(false);
			if (paneRequested == index) {
				setIcone(paneRequested);
				panes[index].setVisible(true);
				childrenPane.add(panes[index]);
			}
		}
	}

	public static Venda getVenda() {
		return venda;
	}

	public static void setVenda(Venda venda) {
		VendasFrame.venda = venda;
	}

	public static void setIcone(int pane) {
		String url;
		switch (pane) {
		case 0:
			url = "E:/MEGA/_Projects_-_JAVA_SE/LojaCartuchoSYSTEM/src/com/grupo9/img/stocks_64.png";
			break;
		case 1:
			url = "E:/MEGA/_Projects_-_JAVA_SE/LojaCartuchoSYSTEM/src/com/grupo9/img/cart_64.png";
			break;
		case 2:
			url = "E:/MEGA/_Projects_-_JAVA_SE/LojaCartuchoSYSTEM/src/com/grupo9/img/profile_64.png";
			break;
		case 3:
			url = "E:/MEGA/_Projects_-_JAVA_SE/LojaCartuchoSYSTEM/src/com/grupo9/img/pay_64.png";
			break;
		case 4:
			url = "E:/MEGA/_Projects_-_JAVA_SE/LojaCartuchoSYSTEM/src/com/grupo9/img/confirm_64.png";
			break;
		case 5:
			url = "E:/MEGA/_Projects_-_JAVA_SE/LojaCartuchoSYSTEM/src/com/grupo9/img/receipt_64.png";
			break;
		default:
			url = "E:/MEGA/_Projects_-_JAVA_SE/LojaCartuchoSYSTEM/src/com/grupo9/img/cart_64.png";
		}
		
		icone.setIcon(new ImageIcon(url));
	}
}
