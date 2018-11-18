package com.grupo9.teste;

import com.grupo9.dao.ClientesPFDao;
import com.grupo9.model.ClientePF;

public class ClientePFDaoTeste {

	public static void main(String[] args) {
		
		ClientesPFDao dao = new ClientesPFDao();
		
		if(dao.remover(35427756817L)) {
			System.out.println("Linha Removida, dude!");
		} else {
			System.out.println("Oops..");
		}
		
		ClientePF cliente_1 = new ClientePF(35427756817L, "Lucas Barretto e Silva", "Av.alda, 1175, Centro, Diadema-SP, 09910170",40551770, 985979534, "mohamed28.lucas@gmail.com");
		System.out.println(cliente_1);
		
		if(dao.adicionar(cliente_1)) {
			System.out.println("Dados Adicionados, man!");
		} else {
			System.out.println("Something went wrong bro!");
		}
		
		cliente_1.setEmail("pepeca@sacana.com");
			
		if(dao.alterar(cliente_1)) {
			System.out.println("Dados Alterados, though!");
		} else {
			System.out.println("Something went wrong bro!");
		}
		
		
		if(dao.remover(cliente_1)) {
			System.out.println("Linha Removida, joe!");
		} else {
			System.out.println("no, no, no..");
		}
		
		
	}
	
}
