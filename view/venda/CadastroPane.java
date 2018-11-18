package com.grupo9.view.venda;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class CadastroPane extends JPanel {

	private static final long serialVersionUID = -9203923925653945942L;
	private JTextField textNomeCompleto;
	private JTextField textEndereco;
	private JTextField textBairro;
	private JTextField textCidade;
	private JTextField textUF;
	private JTextField textTelefone;
	private JTextField textCelular;
	private JTextField textCPFouCNPJ;
	private JTextField textInscricaoEstadual;
	private JTextField textEmail;

	public CadastroPane() {
		setLayout(null);
		setBounds(0, 0, 580, 206);

		JRadioButton radioCPF = new JRadioButton("CPF");
		radioCPF.setHorizontalAlignment(SwingConstants.LEFT);
		radioCPF.setFont(new Font("Tahoma", Font.BOLD, 16));
		radioCPF.setSelected(true);
		radioCPF.setBounds(0, 32, 72, 20);
		add(radioCPF);

		JRadioButton radioCNPJ = new JRadioButton("CNPJ");
		radioCNPJ.setHorizontalAlignment(SwingConstants.LEFT);
		radioCNPJ.setFont(new Font("Tahoma", Font.BOLD, 16));
		radioCNPJ.setBounds(72, 32, 72, 20);
		add(radioCNPJ);

		ButtonGroup group = new ButtonGroup();
		group.add(radioCNPJ);
		group.add(radioCPF);

		JFormattedTextField formattedTextCPFouCNPJ = new JFormattedTextField();
		formattedTextCPFouCNPJ.setFont(new Font("Tahoma", Font.BOLD, 12));
		formattedTextCPFouCNPJ.setColumns(14);
		formattedTextCPFouCNPJ.setBounds(154, 32, 192, 20);
		add(formattedTextCPFouCNPJ);

		JLabel labelCadastroDeCliente = new JLabel("Dados do Comprador");
		labelCadastroDeCliente.setHorizontalAlignment(SwingConstants.CENTER);
		labelCadastroDeCliente.setFont(new Font("Tahoma", Font.BOLD, 16));
		labelCadastroDeCliente.setBounds(0, 0, 580, 32);
		add(labelCadastroDeCliente);

		JLabel labelNomeCompleto = new JLabel("Nome Completo");
		labelNomeCompleto.setEnabled(false);
		labelNomeCompleto.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelNomeCompleto.setBounds(0, 64, 284, 16);
		add(labelNomeCompleto);

		textNomeCompleto = new JTextField();
		textNomeCompleto.setEnabled(false);
		labelNomeCompleto.setLabelFor(textNomeCompleto);
		textNomeCompleto.setBounds(0, 80, 256, 20);
		add(textNomeCompleto);
		textNomeCompleto.setColumns(10);

		JLabel labelCPFouCNPJ = new JLabel("CPF/CNPJ");
		labelCPFouCNPJ.setEnabled(false);
		labelCPFouCNPJ.setHorizontalAlignment(SwingConstants.CENTER);
		labelCPFouCNPJ.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelCPFouCNPJ.setBounds(266, 64, 152, 16);
		add(labelCPFouCNPJ);

		textCPFouCNPJ = new JTextField();
		textCPFouCNPJ.setEnabled(false);
		textCPFouCNPJ.setBounds(266, 80, 152, 20);
		add(textCPFouCNPJ);
		textCPFouCNPJ.setColumns(10);

		JLabel labelEndereco = new JLabel("Endereço, Número");
		labelEndereco.setEnabled(false);
		labelEndereco.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelEndereco.setBounds(0, 110, 256, 16);
		add(labelEndereco);

		textEndereco = new JTextField();
		textEndereco.setEnabled(false);
		textEndereco.setBounds(0, 126, 256, 20);
		add(textEndereco);
		textEndereco.setColumns(10);
		labelEndereco.setLabelFor(textEndereco);

		JLabel labelInscricao = new JLabel("Inscrição Estadual");
		labelInscricao.setHorizontalAlignment(SwingConstants.CENTER);
		labelInscricao.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelInscricao.setEnabled(false);
		labelInscricao.setBounds(428, 64, 152, 16);
		add(labelInscricao);

		textInscricaoEstadual = new JTextField();
		textInscricaoEstadual.setEnabled(false);
		textInscricaoEstadual.setBounds(428, 80, 152, 20);
		add(textInscricaoEstadual);
		textInscricaoEstadual.setColumns(10);

		JLabel labelBairro = new JLabel("Bairro");
		labelBairro.setEnabled(false);
		labelBairro.setHorizontalAlignment(SwingConstants.CENTER);
		labelBairro.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelBairro.setBounds(266, 110, 152, 16);
		add(labelBairro);

		textBairro = new JTextField();
		textBairro.setEnabled(false);
		textBairro.setBounds(266, 126, 152, 20);
		add(textBairro);
		textBairro.setColumns(10);

		JLabel labelCidade = new JLabel("Cidade");
		labelCidade.setEnabled(false);
		labelCidade.setHorizontalAlignment(SwingConstants.CENTER);
		labelCidade.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelCidade.setBounds(428, 110, 96, 16);
		add(labelCidade);

		textCidade = new JTextField();
		textCidade.setEnabled(false);
		textCidade.setBounds(428, 126, 96, 20);
		add(textCidade);
		textCidade.setColumns(10);

		JLabel labelUF = new JLabel("UF");
		labelUF.setEnabled(false);
		labelUF.setHorizontalAlignment(SwingConstants.CENTER);
		labelUF.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelUF.setBounds(534, 110, 46, 16);
		add(labelUF);

		textUF = new JTextField();
		textUF.setEnabled(false);
		textUF.setBounds(534, 126, 46, 20);
		add(textUF);
		textUF.setColumns(10);

		JLabel labelTelefone = new JLabel("Telefone");
		labelTelefone.setEnabled(false);
		labelTelefone.setHorizontalAlignment(SwingConstants.CENTER);
		labelTelefone.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelTelefone.setBounds(0, 156, 118, 16);
		add(labelTelefone);

		textTelefone = new JTextField();
		textTelefone.setEnabled(false);
		textTelefone.setBounds(0, 172, 118, 20);
		add(textTelefone);
		textTelefone.setColumns(10);

		JLabel labelCelular = new JLabel("Celular");
		labelCelular.setEnabled(false);
		labelCelular.setHorizontalAlignment(SwingConstants.CENTER);
		labelCelular.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelCelular.setBounds(128, 156, 128, 16);
		add(labelCelular);

		textCelular = new JTextField();
		textCelular.setEnabled(false);
		textCelular.setBounds(128, 172, 128, 20);
		add(textCelular);
		textCelular.setColumns(10);

		JLabel labelEmail = new JLabel("E-mail");
		labelEmail.setEnabled(false);
		labelEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelEmail.setBounds(266, 156, 314, 16);
		add(labelEmail);

		textEmail = new JTextField();
		textEmail.setEnabled(false);
		textEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textEmail.setBounds(266, 172, 314, 20);
		add(textEmail);
		textEmail.setColumns(10);
		setVisible(true);

	}

}
