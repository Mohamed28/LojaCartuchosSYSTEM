package com.grupo9.view.almoxarifado;

import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

public class CadastrarItemPane extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textMarca;
	private JTextField textModelo;
	private JTextField textDetalhes;
	private JTextField textPreco;

	public CadastrarItemPane() {
		setLayout(null);
		setSize(580, 248);
		
		JLabel labelMarca = new JLabel("Marca do Produto");
		labelMarca.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelMarca.setBounds(0, 43, 160, 16);
		add(labelMarca);
		
		textMarca = new JTextField();
		textMarca.setBounds(0, 59, 160, 20);
		add(textMarca);
		textMarca.setColumns(10);
		
		JLabel labelModelo = new JLabel("Modelo do Produto");
		labelModelo.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelModelo.setBounds(0, 90, 160, 16);
		add(labelModelo);
		
		textModelo = new JTextField();
		textModelo.setColumns(10);
		textModelo.setBounds(0, 106, 160, 20);
		add(textModelo);
		
		JComboBox<String> comboCategoria = new JComboBox<String>();
		comboCategoria.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboCategoria.setModel(new DefaultComboBoxModel<String>(new String[] {"Cartucho", "Acesssório", "Impressora"}));
		comboCategoria.setBounds(170, 59, 96, 20);
		add(comboCategoria);
		
		JLabel labelCategoria = new JLabel("Categoria");
		labelCategoria.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelCategoria.setBounds(170, 43, 96, 16);
		add(labelCategoria);
		
		JLabel labelDetalhes = new JLabel("Detalhes do Produto");
		labelDetalhes.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelDetalhes.setBounds(0, 137, 144, 16);
		add(labelDetalhes);
		
		textDetalhes = new JTextField();
		textDetalhes.setColumns(10);
		textDetalhes.setBounds(0, 153, 160, 20);
		add(textDetalhes);
		
		JLabel labelQuantidade = new JLabel("Quantidade");
		labelQuantidade.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelQuantidade.setBounds(170, 90, 72, 14);
		add(labelQuantidade);
		
		JSpinner spinnerQuantidade = new JSpinner();
		spinnerQuantidade.setBounds(171, 105, 96, 20);
		add(spinnerQuantidade);
		
		JLabel labelPreco = new JLabel("Pre\u00E7o");
		labelPreco.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelPreco.setBounds(170, 137, 96, 16);
		add(labelPreco);
		
		textPreco = new JTextField();
		textPreco.setColumns(10);
		textPreco.setBounds(170, 153, 96, 20);
		add(textPreco);
		
		JLabel labelDescricao = new JLabel("Descri\u00E7\u00E3o");
		labelDescricao.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelDescricao.setBounds(276, 44, 304, 14);
		add(labelDescricao);
		
		JTextPane textPaneDescricao = new JTextPane();
		textPaneDescricao.setBounds(276, 59, 304, 113);
		add(textPaneDescricao);
		
		JButton buttonCadastrar = new JButton("Cadastrar");
		buttonCadastrar.setFont(new Font("Tahoma", Font.BOLD, 12));
		buttonCadastrar.setBounds(484, 205, 96, 32);
		add(buttonCadastrar);
		
		JButton buttonLimpar = new JButton("Limpar");
		buttonLimpar.setFont(new Font("Tahoma", Font.BOLD, 12));
		buttonLimpar.setBounds(378, 205, 96, 32);
		add(buttonLimpar);
		
		JLabel labelCadastrarNovoItem = new JLabel("Cadastrar Novo Item");
		labelCadastrarNovoItem.setHorizontalAlignment(SwingConstants.CENTER);
		labelCadastrarNovoItem.setFont(new Font("Tahoma", Font.BOLD, 16));
		labelCadastrarNovoItem.setBounds(0, 0, 580, 32);
		add(labelCadastrarNovoItem);

	}
}
