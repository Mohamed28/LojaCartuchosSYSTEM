package com.grupo9.view.venda;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.grupo9.model.Estoque;
import com.grupo9.model.Produto;

public class EstoquePane extends JPanel {

	private static final long serialVersionUID = -5473847708521277130L;

	public EstoquePane() {
		setBounds(0, 0, 580, 206);
		setLayout(null);

		JLabel labelProdutos = new JLabel("Produtos");
		labelProdutos.setBounds(0, 0, 580, 32);
		labelProdutos.setFont(new Font("Tahoma", Font.BOLD, 18));
		labelProdutos.setHorizontalAlignment(SwingConstants.CENTER);
		add(labelProdutos);

		JRadioButton radioID = new JRadioButton("ID");
		radioID.setBounds(0, 32, 48, 20);
		radioID.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(radioID);
		radioID.setEnabled(false);

		JRadioButton radioModelo = new JRadioButton("Modelo");
		radioModelo.setBounds(144, 32, 72, 20);
		radioModelo.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(radioModelo);
		radioModelo.setEnabled(false);

		JRadioButton radioCategoria = new JRadioButton("Categoria");
		radioCategoria.setHorizontalAlignment(SwingConstants.LEFT);
		radioCategoria.setFont(new Font("Tahoma", Font.BOLD, 12));
		radioCategoria.setBounds(50, 32, 96, 20);
		add(radioCategoria);
		radioCategoria.setEnabled(false);

		JRadioButton radioPreco = new JRadioButton("Preço");
		radioPreco.setBounds(222, 32, 64, 20);
		radioPreco.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(radioPreco);
		radioPreco.setEnabled(false);

		ButtonGroup groupRadio = new ButtonGroup();
		groupRadio.add(radioID);
		groupRadio.add(radioCategoria);
		groupRadio.add(radioModelo);
		groupRadio.add(radioPreco);

		JTextField textPesquisa = new JTextField();
		textPesquisa.setBounds(287, 32, 187, 20);
		textPesquisa.setColumns(10);
		add(textPesquisa);
		textPesquisa.setEnabled(false);

		JButton button = new JButton("Pesquisar");
		button.setBounds(484, 31, 96, 21);
		button.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add(button);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 62, 580, 92);
		add(scrollPane);

		JTable tableEstoque = new JTable();
		tableEstoque.setFillsViewportHeight(true);
		tableEstoque.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		List<String[]> listaEstoque = new ArrayList<>();
		String[] colunasNome = new String[] { 
			"ID", "Categoria", "Marca", "Modelo", 
			"Deatlhes", "Qtd.", "Vl. Un.","Descrição" 
		};

		for (Produto produto : Estoque.getLista()) {
			listaEstoque.add(new String[] { 
				String.valueOf(produto.getId()), 
				produto.getCategoria(), produto.getMarca(),
				produto.getModelo(), produto.getDetalhes(), 
				String.valueOf(produto.getQuantidade()),
				String.valueOf("R$ " + produto.getPreco()), 
				produto.getDescricao() 
			});
		}
		Object[][] objetos = listaEstoque.toArray(new Object[listaEstoque.size()][]);
		tableEstoque.setModel(new DefaultTableModel(objetos, colunasNome));
		scrollPane.setViewportView(tableEstoque);

		JLabel labelQuantidade = new JLabel("Quantidade Desejada");
		labelQuantidade.setBounds(0, 162, 192, 32);
		labelQuantidade.setFont(new Font("Tahoma", Font.BOLD, 16));
		labelQuantidade.setHorizontalAlignment(SwingConstants.RIGHT);
		add(labelQuantidade);

		JSpinner spinnerQuantidade = new JSpinner();
		spinnerQuantidade.setBounds(202, 164, 64, 32);
		spinnerQuantidade.setFont(new Font("Tahoma", Font.BOLD, 12));
		spinnerQuantidade.setModel(
			new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1))
		);
		add(spinnerQuantidade);

		JButton buttonAdicionar = new JButton("Adicionar");
		buttonAdicionar.setBounds(276, 164, 96, 32);
		buttonAdicionar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		buttonAdicionar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if ((int) spinnerQuantidade.getValue() > 0) {
					int produtoID = Integer.parseInt(
						(String) tableEstoque.getModel().getValueAt(tableEstoque.getSelectedRow(), 0)
					);
					if (VendasFrame.getVenda().existeNaLista(produtoID)) {
						VendasFrame.getVenda().alterar(produtoID, (int) spinnerQuantidade.getValue());
					} else {
						VendasFrame.getVenda().adicionar(produtoID, (int) spinnerQuantidade.getValue());
					}
					VendaPane.setListaModel();
					VendasFrame.setPane(1);
					
				} else {
					JOptionPane.showMessageDialog(null, "Valor Inválido!");
				}
			}
		});
		add(buttonAdicionar);

		setVisible(true);
	}
}
