package com.grupo9.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Cartucho extends Produto {

	private String marca;
	private String modelo;
	private String detalhes;
	private String descricao;
	private BigDecimal preco = new BigDecimal(0);

	public Cartucho() {
		super.setCategoria(this.getClass().getSimpleName());
	}

	public Cartucho(String marca, String modelo, String detalhes, int quantidade, BigDecimal preco) {
		super.setCategoria(this.getClass().getSimpleName());
		this.marca = marca;
		this.modelo = modelo;
		this.detalhes = detalhes;
		super.setQuantidade(quantidade);
		this.preco = preco.setScale(2, RoundingMode.DOWN);
		this.descricao = "Sem Descrição";
		
	}

	@Override
	public String getMarca() {
		return marca;
	}

	@Override
	public void setMarca(String marca) {
		this.marca = marca;
	}

	@Override
	public String getModelo() {
		return modelo;
	}

	@Override
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	@Override
	public String getDetalhes() {
		return detalhes;
	}

	@Override
	public void setDetalhes(String detalhes) {
		this.detalhes = detalhes;
	}

	@Override
	public String getDescricao() {
		return descricao;
	}

	@Override
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public BigDecimal getPreco() {
		return preco;
	}

	@Override
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	@Override
	public Produto copiar(Produto novoProduto) {
		novoProduto.setId(this.getId());
		novoProduto.setCategoria(this.getCategoria());
		novoProduto.setMarca(this.getMarca());
		novoProduto.setModelo(this.getModelo());
		novoProduto.setDetalhes(this.getDetalhes());
		novoProduto.setQuantidade(this.getQuantidade());
		novoProduto.setPreco(this.getPreco());
		novoProduto.setDescricao(this.getDescricao());
		return novoProduto;
	}

}