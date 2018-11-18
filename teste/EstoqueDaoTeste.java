package com.grupo9.teste;

import java.math.BigDecimal;

import com.grupo9.model.Cartucho;
import com.grupo9.model.Estoque;
import com.grupo9.model.Produto;

public class EstoqueDaoTeste {

	public static void main(String[] args) {
		Produto produto_1 = new Cartucho("Canon", "E481", "colorida", 30, new BigDecimal(73.90));
		Produto produto_2 = new Cartucho("Canon", "E481", "preta", 30, new BigDecimal(62.60));
		Produto produto_3 = new Cartucho("Samsung", "SL-M2070W", "preta", 30, new BigDecimal(69.90));
		Produto produto_4 = new Cartucho("HP", "P1102W", "preta", 30, new BigDecimal(29.90));
		Produto produto_5 = new Cartucho("HP", "Officejet Pro 8710", "preta", 30, new BigDecimal(179.00));
		Produto produto_6 = new Cartucho("Epson", "Ecotank L475", "preta", 30, new BigDecimal(59.90));

		Estoque.adicionar(produto_1);
		Estoque.adicionar(produto_2);
		Estoque.adicionar(produto_3);
		Estoque.adicionar(produto_4);
		Estoque.adicionar(produto_5);
		Estoque.adicionar(produto_6);

		Estoque.entrada(36, 45);
		
		Estoque.retirada(40, 15);
		
		for (Produto produto : Estoque.getLista()) {
			System.out.println(produto.toString());
		}
	}
}