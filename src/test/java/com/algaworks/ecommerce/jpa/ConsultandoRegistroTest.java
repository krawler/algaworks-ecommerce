package com.algaworks.ecommerce.jpa;

import com.algaworks.ecommerce.model.Pedido;
import com.algaworks.ecommerce.model.Produto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ConsultandoRegistroTest extends EntityManagerAbstract {
		
	@Test
	public void buscarPorId() {
		Produto produto  = manager.find(Produto.class, 1);
		
		Pedido pedido = manager.find(Pedido.class, 1);
		
		assertEquals("produto não encontrado", produto);
		assertEquals(1L, produto.getId().longValue());
	}

}
