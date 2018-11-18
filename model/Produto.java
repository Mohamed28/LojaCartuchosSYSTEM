package com.grupo9.model;

import java.math.BigDecimal;

public abstract class Produto {

	private int id;
	private String categoria;
	private int quantidade;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getCategoria() {
		return categoria;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public abstract String getModelo();

	public abstract void setModelo(String modelo);

	public abstract String getMarca();

	public abstract void setMarca(String marca);

	public abstract String getDetalhes();

	public abstract void setDetalhes(String detalhes);

	public abstract String getDescricao();

	public abstract void setDescricao(String descricao);

	public abstract BigDecimal getPreco();

	public abstract void setPreco(BigDecimal preco);

	public abstract Produto copiar(Produto novoProduto);

	public String toString() {
		return String.format(" %d, %s, %s, %s, %s, %d, %.2f, %s ", 
				this.id, this.categoria, getMarca(), getModelo(), getDetalhes(), getQuantidade(), 
				getPreco(), getDescricao());

	}
	

}
