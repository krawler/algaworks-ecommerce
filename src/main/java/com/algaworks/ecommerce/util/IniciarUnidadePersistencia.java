package com.algaworks.ecommerce.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.algaworks.ecommerce.model.Produto;

public class IniciarUnidadePersistencia {

	 public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ecommerce-pu");
		EntityManager manager =  factory.createEntityManager();
		
		Produto produto = manager.find(Produto.class, 1);
		System.out.println(produto.getNome());
		
		manager.close();
		factory.close();
	}

}
