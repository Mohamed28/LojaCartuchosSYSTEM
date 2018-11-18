package com.grupo9.model;

import java.util.List;

import com.grupo9.dao.EstoqueDao;

public class Estoque {

	private static EstoqueDao dao = new EstoqueDao();
	private static List<Produto> lista = dao.listar();

	public static boolean adicionar(Produto produto) {
		if (dao.adicionar(produto)) {
			return true;
		}
		return false;
	}

	public static boolean entrada(int produtoID, int quantidade) {
		Produto produto = dao.buscar(produtoID);
		if (produto != null) {
			produto.setQuantidade(produto.getQuantidade() + quantidade);
			if (dao.alterar(produto)) {
				return true;
			}
		}
		return false;
	}

	public static boolean retirada(int produtoID, int quantidade) {
		Produto produto = dao.buscar(produtoID);
		if (produto.getQuantidade() >= quantidade) {			
			produto.setQuantidade(produto.getQuantidade() - quantidade);
			if (dao.alterar(produto)) {
				return true;
			}
		}
		throw new RuntimeException("Quantidade solicitada superior a quantidade disponível");
	}

	public static List<Produto> getLista() {
		return lista;
	}
}
