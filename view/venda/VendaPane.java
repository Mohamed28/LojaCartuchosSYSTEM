package com.grupo9.view.venda;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.grupo9.model.Produto;

public class VendaPane extends JPanel {

	private static final long serialVersionUID = -1629555795531556034L;
	private static JTable tableLista = new JTable();
	private static JTextField textValor;

	public VendaPane() {
		setBounds(0, 0, 580, 206);
		setLayout(null);

		JLabel labelLista = new JLabel("Lista de Compras");
		labelLista.setBounds(0, 0, 400, 32);
		labelLista.setHorizontalAlignment(SwingConstants.CENTER);
		labelLista.setFont(new Font("Tahoma", Font.BOLD, 16));
		add(labelLista);

		JLabel labelAcoes = new JLabel("Ações");
		labelAcoes.setBounds(410, 0, 170, 32);
		labelAcoes.setFont(new Font("Tahoma", Font.BOLD, 16));
		labelAcoes.setHorizontalAlignment(SwingConstants.CENTER);
		add(labelAcoes);

		JScrollPane scrollLista = new JScrollPane();
		scrollLista.setSize(400, 160);
		scrollLista.setLocation(0, 32);
		tableLista.setFillsViewportHeight(true);
		tableLista.setFont(new Font("Tahoma", Font.PLAIN, 12));
		scrollLista.setViewportView(tableLista);
		add(scrollLista);

		JButton buttonAdicionarProduto = new JButton("Adicionar Produtos");
		buttonAdicionarProduto.setBounds(410, 32, 170, 32);
		buttonAdicionarProduto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		buttonAdicionarProduto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VendasFrame.setPane(0);
			}
		});
		add(buttonAdicionarProduto);

		JButton buttonRemoverProduto = new JButton("Remover Produtos");
		buttonRemoverProduto.setBounds(410, 74, 170, 32);
		buttonRemoverProduto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		buttonRemoverProduto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (tableLista.isRowSelected(tableLista.getSelectedRow())) {
					int produtoID = Integer.parseInt((String) tableLista.getModel().getValueAt(tableLista.getSelectedRow(), 0));
					if (VendasFrame.getVenda().remover(produtoID)); {
						VendaPane.setListaModel();
						VendasFrame.setPane(1);
					}
				}
			}
		});
		add(buttonRemoverProduto);

		JButton buttonLimparLista = new JButton("Limpar Lista");
		buttonLimparLista.setBounds(410, 116, 170, 32);
		buttonLimparLista.setFont(new Font("Tahoma", Font.PLAIN, 12));
		buttonLimparLista.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VendasFrame.getVenda().resetLista();
				setListaModel();
			}
		});
		add(buttonLimparLista);

		JLabel labelTotal = new JLabel("Total");
		labelTotal.setBounds(410, 160, 72, 32);
		labelTotal.setHorizontalAlignment(SwingConstants.CENTER);
		labelTotal.setFont(new Font("Tahoma", Font.BOLD, 16));
		add(labelTotal);

		textValor = new JTextField();
		textValor.setBounds(492, 160, 88, 32);
		textValor.setEditable(false);
		textValor.setFont(new Font("Tahoma", Font.BOLD, 12));
		textValor.setHorizontalAlignment(SwingConstants.CENTER);
		textValor.setColumns(10);
		textValor.setText("R$ 0.00");
		add(textValor);

		setVisible(true);
	}

	public static void setListaModel() {
		List<String[]> listaProdutos = new ArrayList<>();
		String[] colunasNome = new String[] { 
			"ID", "Categoria", "Marca", "Modelo", 
			"Detalhes", "Qtd.", "Vl. Un." 
		};
		
		for (Produto produto : VendasFrame.getVenda().getLista()) {
			listaProdutos.add(new String[] { 
				String.valueOf(produto.getId()), 
				produto.getCategoria(), 
				produto.getMarca(),
				produto.getModelo(), 
				produto.getDetalhes(), 
				String.valueOf(produto.getQuantidade()),
				String.valueOf("R$ " + produto.getPreco()), 
				produto.getDescricao() 
			});
		}
		Object[][] objetos = listaProdutos.toArray(new Object[listaProdutos.size()][]);
		tableLista.setModel(new DefaultTableModel(objetos, colunasNome));
		textValor.setText("R$ " + String.valueOf(VendasFrame.getVenda().getCustoTotal()));
	}
}
