package com.grupo9.model;

public class ClientePF extends Cliente {

	private long cpf;

	
	public ClientePF() {
		
	}

	public ClientePF(long cpf, String nome, String endereco, int telefone, int celular, String email) {	
		this.cpf = cpf;
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.celular = celular;
		this.email = email;
	}

	public ClientePF(long cpf, String nome, int celular, String email) {	
		this.cpf = cpf;
		this.nome = nome;
		this.celular = celular;
		this.email = email;
	}



	public long getCpf() {
		return cpf;
	}

	public void setCpf(long cpf) {
		this.cpf = cpf;
	}
}
