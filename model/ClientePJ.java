package com.grupo9.model;

public class ClientePJ extends Cliente {

	private long cnpj;
	private long inscricaoEstadual;

	public ClientePJ() {

	}

	public ClientePJ(long cnpj, String nome,  long inscricaoEstadual, long telefone, String email) {
		this.cnpj = cnpj;
		this.nome = nome;
		this.inscricaoEstadual = inscricaoEstadual;
		this.telefone = telefone;
		this.email = email; 
	}



	public long getCnpj() {
		return cnpj;
	}

	public void setCnpj(long cnpj) {
		this.cnpj = cnpj;
	}

	public long getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(long inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

}
