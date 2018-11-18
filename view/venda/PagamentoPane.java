package com.grupo9.view.venda;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.ImageIcon;

public class PagamentoPane extends JPanel{
	
	private static final long serialVersionUID = 1545164735099407649L;
	private JTextField textValorPagar;
	private JTextField textPagar;
	private JTextField textSaldo;

	public PagamentoPane() {
		setLayout(null);
		setBounds(0, 0, 580, 206);
		
		JLabel labelFormaPagamento = new JLabel("Forma de Pagamento");
		labelFormaPagamento.setHorizontalAlignment(SwingConstants.CENTER);
		labelFormaPagamento.setFont(new Font("Tahoma", Font.BOLD, 16));
		labelFormaPagamento.setBounds(0, 0, 580, 32);
		add(labelFormaPagamento);
		
		JRadioButton radioDinheiro = new JRadioButton("Dinheiro");
		radioDinheiro.setSelected(true);
		radioDinheiro.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				System.out.println("Teste");
				
			}
		});
		radioDinheiro.setHorizontalAlignment(SwingConstants.LEFT);
		radioDinheiro.setFont(new Font("Tahoma", Font.BOLD, 12));
		radioDinheiro.setBounds(54, 66, 96, 16);
		add(radioDinheiro);
		
		JRadioButton radioCartao = new JRadioButton("Cartão de Crédito");
		radioCartao.setEnabled(false);
		radioCartao.setHorizontalAlignment(SwingConstants.LEFT);
		radioCartao.setFont(new Font("Tahoma", Font.BOLD, 12));
		radioCartao.setBounds(248, 66, 138, 16);
		add(radioCartao);
		
		JRadioButton radioCheque = new JRadioButton("Cheque");
		radioCheque.setEnabled(false);
		radioCheque.setHorizontalAlignment(SwingConstants.LEFT);
		radioCheque.setFont(new Font("Tahoma", Font.BOLD, 12));
		radioCheque.setBounds(484, 66, 96, 16);
		add(radioCheque);
		
		ButtonGroup group = new ButtonGroup();
		group.add(radioDinheiro);
		group.add(radioCartao);
		group.add(radioCheque);
		
		JPanel detalhesPagamentoPane = new JPanel();
		detalhesPagamentoPane.setBounds(0, 82, 580, 124);
		add(detalhesPagamentoPane);
		detalhesPagamentoPane.setLayout(null);
		
		JPanel panelCartao = new JPanel();
		panelCartao.setBounds(0, 0, 580, 124);
		detalhesPagamentoPane.add(panelCartao);
		
		JPanel panelDinheiro = new JPanel();
		panelDinheiro.setBounds(0, 0, 580, 124);
		detalhesPagamentoPane.add(panelDinheiro);
		panelDinheiro.setLayout(null);
		
		textValorPagar = new JTextField();
		textValorPagar.setEditable(false);
		textValorPagar.setFont(new Font("Tahoma", Font.BOLD, 12));
		textValorPagar.setBounds(210, 10, 160, 24);
		panelDinheiro.add(textValorPagar);
		textValorPagar.setColumns(10);
		
		JLabel labelValorPagar = new JLabel("Valor a Pagar");
		labelValorPagar.setHorizontalAlignment(SwingConstants.CENTER);
		labelValorPagar.setFont(new Font("Tahoma", Font.BOLD, 16));
		labelValorPagar.setBounds(0, 10, 200, 24);
		panelDinheiro.add(labelValorPagar);
		
		JCheckBox checkPagar = new JCheckBox("Pagar");
		checkPagar.setFont(new Font("Tahoma", Font.BOLD, 12));
		checkPagar.setBounds(376, 44, 97, 24);
		panelDinheiro.add(checkPagar);
		
		textPagar = new JTextField();
		textPagar.setFont(new Font("Tahoma", Font.BOLD, 12));
		textPagar.setColumns(10);
		textPagar.setBounds(210, 44, 160, 24);
		panelDinheiro.add(textPagar);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(130, 78, 320, 1);
		panelDinheiro.add(separator);
		
		textSaldo = new JTextField();
		textSaldo.setFont(new Font("Tahoma", Font.BOLD, 12));
		textSaldo.setEditable(false);
		textSaldo.setColumns(10);
		textSaldo.setBounds(210, 89, 160, 24);
		panelDinheiro.add(textSaldo);
		
		JLabel labelSaldo = new JLabel("Saldo");
		labelSaldo.setHorizontalAlignment(SwingConstants.RIGHT);
		labelSaldo.setFont(new Font("Tahoma", Font.BOLD, 16));
		labelSaldo.setBounds(140, 89, 64, 24);
		panelDinheiro.add(labelSaldo);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("E:/MEGA/_Projects_-_JAVA_SE/LojaCartuchoSYSTEM/src/com/grupo9/img/cash_48.png"));
		lblNewLabel.setBounds(0, 34, 48, 48);
		add(lblNewLabel);
		
		JLabel label = new JLabel("New label");
		label.setIcon(new ImageIcon("E:/MEGA/_Projects_-_JAVA_SE/LojaCartuchoSYSTEM/src/com/grupo9/img/card_48.png"));
		label.setBounds(194, 34, 48, 48);
		add(label);
		
		JLabel label_1 = new JLabel("New label");
		label_1.setBounds(434, 34, 48, 48);
		add(label_1);
		setVisible(true);
	}

}
