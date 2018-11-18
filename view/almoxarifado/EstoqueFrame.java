package com.grupo9.view.almoxarifado;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.grupo9.model.Estoque;
import com.grupo9.model.Produto;

public class EstoqueFrame extends JFrame {

	private static final long serialVersionUID = -4637813570646591022L;
	private JPanel contentPane;

	public EstoqueFrame() {
		setTitle("Estoque");
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"E:/MEGA/_Projects_-_JAVA_SE/LojaCartuchoSYSTEM/src/com/grupo9/img/stocks_48.png")
				);
		setBounds(100, 100, 580, 325);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setType(Type.POPUP);
		setResizable(false);

		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 74, 554, 169);
		contentPane.add(scrollPane);

		JTable tableEstoque = new JTable();
		tableEstoque.setFillsViewportHeight(true);
		tableEstoque.setFont(new Font("Tahoma", Font.PLAIN, 12));
		List<String[]> listaEstoque = new ArrayList<>();
		String[] colunasNome = new String[] { 
			"ID", "Categoria", "Marca", "Modelo", 
			"Detalhes", "Qtd.", "Vl. Un.","Descrição" 
		};
		
		for (Produto produto : Estoque.getLista()) {
			listaEstoque.add(new String[] { 
				String.valueOf(produto.getId()), 
				produto.getCategoria(),
				produto.getMarca(), 
				produto.getModelo(), 
				produto.getDetalhes(),
				String.valueOf(produto.getQuantidade()), 
				String.valueOf("R$ " + produto.getPreco()),
				produto.getDescricao() });
		}

		Object[][] objetos = listaEstoque.toArray(new Object[listaEstoque.size()][]);
		tableEstoque.setModel(new DefaultTableModel(objetos, colunasNome));
		scrollPane.setViewportView(tableEstoque);

		JLabel labelEstoque = new JLabel("Estoque");
		labelEstoque.setBounds(10, 10, 128, 32);
		labelEstoque.setFont(new Font("Tahoma", Font.BOLD, 24));
		contentPane.add(labelEstoque);

		JRadioButton radioID = new JRadioButton("ID");
		radioID.setBounds(10, 42, 48, 20);
		radioID.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(radioID);
		radioID.setEnabled(false);

		JRadioButton radioModelo = new JRadioButton("Modelo");
		radioModelo.setBounds(154, 42, 72, 20);
		radioModelo.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(radioModelo);
		radioModelo.setEnabled(false);

		JRadioButton radioCategoria = new JRadioButton("Categoria");
		radioCategoria.setBounds(60, 42, 96, 20);
		radioCategoria.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(radioCategoria);
		radioCategoria.setEnabled(false);

		JRadioButton radioPreco = new JRadioButton("Preço");
		radioPreco.setBounds(232, 42, 64, 20);
		radioPreco.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(radioPreco);
		radioPreco.setEnabled(false);

		ButtonGroup groupRadio = new ButtonGroup();
		groupRadio.add(radioID);
		groupRadio.add(radioCategoria);
		groupRadio.add(radioModelo);
		groupRadio.add(radioPreco);

		JButton buttonSelecionar = new JButton("Selecionar");
		buttonSelecionar.setBounds(468, 254, 96, 32);
		buttonSelecionar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		buttonSelecionar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
		contentPane.add(buttonSelecionar);

		JButton buttonCancelar = new JButton("Cancelar");
		buttonCancelar.setBounds(362, 254, 96, 32);
		buttonCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		buttonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		contentPane.add(buttonCancelar);
		
		JTextField textPesquisa = new JTextField();
		textPesquisa.setBounds(297, 42, 161, 20);
		textPesquisa.setColumns(10);
		contentPane.add(textPesquisa);
		textPesquisa.setEnabled(false);
		
		JButton button = new JButton("Pesquisar");
		button.setBounds(468, 42, 96, 20);
		button.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(button);

		setVisible(true);
	}
}
