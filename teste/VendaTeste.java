package com.grupo9.teste;

import com.grupo9.model.Venda;

public class VendaTeste {

	public static void main(String[] args) {
		Venda venda = new Venda();

		venda.adicionar(40, 5);

		System.out.println(venda.toString() + "\nCusto Total: " + venda.getCustoTotal());
	}
}
