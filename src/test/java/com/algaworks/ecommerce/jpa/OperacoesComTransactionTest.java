package com.algaworks.ecommerce.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;

import org.junit.Test;

import com.algaworks.ecommerce.model.Produto;

public class OperacoesComTransactionTest extends EntityManagerAbstract {
	
	public void openAndCloseTheTransaction() {
		
		manager.getTransaction().begin();
		
		manager.persist(manager);
		manager.merge(null);
		manager.remove(manager);
		
		manager.getTransaction().commit();
		
	}
	
	@Test
	public void insertFirstObjectTest() {
		Produto produto = new Produto();
		//produto.setId(2);
		produto.setNome("extensão de cabo de rede 2kM sem ponta");
		produto.setDescricao("extensão para cabo de rede para grandes instalações");
		produto.setPreco(new BigDecimal(5.25));
		
		manager.getTransaction().begin();		
		manager.persist(produto);
		manager.getTransaction().commit();
		
		manager.clear();
		
		Produto productVerify = manager.find(Produto.class, produto.getId());
		assertNotNull(productVerify);
	}

	@Test
	public void impedirOperacaoComBancoDeDados() {
		Produto produto = manager.find(Produto.class, 1);
		manager.detach(produto);

		manager.getTransaction().begin();		
		produto.setNome("cabo de aço padrão alterado");
		manager.merge(produto);
		manager.getTransaction().commit();
		
		manager.clear();
		
		Produto productVerify = manager.find(Produto.class, produto.getId());
		assertEquals("cabo de aço padrão alterado", productVerify.getNome());
	}

}
