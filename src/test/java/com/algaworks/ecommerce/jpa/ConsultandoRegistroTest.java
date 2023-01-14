package com.algaworks.ecommerce.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.algaworks.ecommerce.model.Produto;

public class ConsultandoRegistroTest extends EntityManagerAbstract {
		
	@Test
	public void buscarPorId() {
		Produto produto  = manager.find(Produto.class, 1);
		
		assertNotNull("produto não encontrado", produto);
		assertEquals(1L, produto.getId().longValue());
	}

}
