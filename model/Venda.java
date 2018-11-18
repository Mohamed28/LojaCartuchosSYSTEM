package com.grupo9.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Venda {

	private int codigoVenda;
	private Cliente cliente;
	private List<Produto> lista = new ArrayList<>();
	private BigDecimal custoTotal = new BigDecimal(0);
	private BigDecimal pagamento = new BigDecimal(0);

	public void setCodigoVenda(int codigoVenda) {
		this.codigoVenda = codigoVenda;
	}
		
	public int getCodigoVenda() {
		return codigoVenda;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCustoTotal() {
		BigDecimal custoTotal = new BigDecimal(0);
		for (Produto produto : lista) {
			for (int i = 0; i < produto.getQuantidade(); i++) {
				custoTotal = custoTotal.add(produto.getPreco());
			}
		}
		this.custoTotal = custoTotal;
	}

	public BigDecimal getCustoTotal() {
		return custoTotal;
	}

	public List<Produto> getLista() {
		return lista;
	}

	public void resetLista() {
		this.lista = new ArrayList<Produto>();
		this.setCustoTotal();
	}

	public void adicionarPagamento(int valor) {
		// TODO
	}

	public BigDecimal getPagamento() {
		return pagamento;
	}

	public boolean adicionar(int produtoID, int quantidade) {
		Produto produtoSelecionado = null;
		for (Produto produto : Estoque.getLista()) {
			if (produto.getId() == produtoID) {
				if (produto.getCategoria().equals("Cartucho")) {
					produtoSelecionado = produto.copiar(new Cartucho());
					produtoSelecionado.setQuantidade(quantidade);
					if (this.lista.add(produtoSelecionado)) {
						this.setCustoTotal();
						return true;
					}
				}
			}
		}
		return false;
	}

	public boolean alterar(int produtoID, int quantidade) {
		for (Produto produto : lista) {
			if (produto.getId() == produtoID) {
				produto.setQuantidade(produto.getQuantidade() + quantidade);
				this.setCustoTotal();
				return true;
			}
		}
		return false;
	}

	public boolean remover(int produtoID) {
		for (Produto produto : lista) {
			if (produto.getId() == produtoID) {
				if (this.lista.remove(produto)) {
					this.setCustoTotal();
					return true;
				}
			}
		}
		return false;
	}

	public boolean existeNaLista(int produtoID) {
		for (Produto produto : lista) {
			if (produto.getId() == produtoID && lista.contains(produto)) {
				return true;
			}
		}
		return false;
	}

	public String toString() {
		String string = "";
		for (Produto produto : lista) {
			string += produto.toString() + "\n";
		}
		return string;
	}

}
