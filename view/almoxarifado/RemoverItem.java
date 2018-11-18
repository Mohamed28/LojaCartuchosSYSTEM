package com.grupo9.view.almoxarifado;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

public class RemoverItem extends JPanel {
	private static final long serialVersionUID = -8194041734982825572L;
	private JTable table;


	public RemoverItem() {
		setLayout(null);
		setSize(580, 248);
		
		JLabel lblRemoverItem = new JLabel("Remover Item");
		lblRemoverItem.setHorizontalAlignment(SwingConstants.CENTER);
		lblRemoverItem.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblRemoverItem.setBounds(0, 0, 580, 32);
		add(lblRemoverItem);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 32, 580, 162);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setBounds(484, 205, 96, 32);
		add(btnRemover);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(378, 205, 96, 32);
		add(btnCancelar);
	}

}
