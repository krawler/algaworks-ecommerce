package com.algaworks.ecommerce.jpa.conhecendoentitymanager;

import org.junit.Test;

import com.algaworks.ecommerce.jpa.EntityManagerAbstract;
import com.algaworks.ecommerce.model.Produto;

public class CachePrimeiroNivelTest extends EntityManagerAbstract {

	
	@Test
	public void verificarCache() {
		Produto produto = manager.find(Produto.class, 1);
		System.out.println(produto.getNome());
		
		System.out.println("-----------");
		
		Produto produtoResgatado = manager.find(Produto.class, produto.getId());
		System.out.println(produtoResgatado.getNome());
	}
}
