package com.grupo9.view.almoxarifado;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
	
public class AlmoxarifadoFrame extends JFrame {

	private static final long serialVersionUID = -3052850268684739017L;
	private JPanel contentPane;

	public AlmoxarifadoFrame() {
		setTitle("Almoxarifado");
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:/MEGA/_Projects_-_JAVA_SE/LojaCartuchoSYSTEM/src/com/grupo9/img/stocks_64.png"));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 606, 384);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 600, 22);
		contentPane.add(menuBar);
		
		JMenu menuArquivo = new JMenu("Arquivo");
		menuBar.add(menuArquivo);
		
		JMenu menuRegistro = new JMenu("Registros");
		menuArquivo.add(menuRegistro);
		
		JMenuItem itemRegistroSaida = new JMenuItem("Registro de Saída");
		menuRegistro.add(itemRegistroSaida);
		
		JMenuItem itemRegistroEntrada = new JMenuItem("Registro de Entrada");
		menuRegistro.add(itemRegistroEntrada);
		
		JSeparator separator = new JSeparator();
		menuArquivo.add(separator);
		
		JMenuItem itemSair = new JMenuItem("Sair");
		menuArquivo.add(itemSair);
		
		JMenu menuItens = new JMenu("Itens");
		menuBar.add(menuItens);
		
		JMenuItem ItemConsultarEstoque = new JMenuItem("Consultar Estoque");
		ItemConsultarEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EstoqueFrame();
			}
		});
		menuItens.add(ItemConsultarEstoque);
		
		JSeparator separator_1 = new JSeparator();
		menuItens.add(separator_1);
		
		JMenuItem itemCadastrarItem = new JMenuItem("Cadastrar Item");
		menuItens.add(itemCadastrarItem);
		
		JMenuItem itemAlterarItem = new JMenuItem("Alterar Item");
		menuItens.add(itemAlterarItem);
		
		JMenuItem itemRemoverItem = new JMenuItem("Remover Item");
		menuItens.add(itemRemoverItem);
		
		JMenu menuRequisicoes = new JMenu("Requisições");
		menuBar.add(menuRequisicoes);
		
		JMenuItem mntmPedidoDeCompra = new JMenuItem("Pedidos de Compra");
		menuRequisicoes.add(mntmPedidoDeCompra);
		
		JMenuItem mntmPedidoDeSada = new JMenuItem("Pedidos de Saída");
		menuRequisicoes.add(mntmPedidoDeSada);
		
		JPanel childrenPane = new JPanel();
		childrenPane.setBounds(10, 96, 580, 248);
		contentPane.add(childrenPane);
		childrenPane.setLayout(new BorderLayout(0, 0));
		childrenPane.add(new CadastrarItemPane(), BorderLayout.CENTER);
		
		JLabel labelAlmoxarifado = new JLabel("Almoxarifado");
		labelAlmoxarifado.setFont(new Font("Tahoma", Font.BOLD, 24));
		labelAlmoxarifado.setBounds(84, 32, 506, 64);
		contentPane.add(labelAlmoxarifado);
		
		JLabel icon = new JLabel("");
		icon.setIcon(new ImageIcon("E:/MEGA/_Projects_-_JAVA_SE/LojaCartuchoSYSTEM/src/com/grupo9/img/stocks_64.png"));
		icon.setBounds(10, 32, 64, 64);
		contentPane.add(icon);
		setVisible(true);
	}
}
