package com.algaworks.ecommerce.jpa.relacionamentos;

import org.junit.Test;

import com.algaworks.ecommerce.jpa.EntityManagerAbstract;
import com.algaworks.ecommerce.model.Cliente;
import com.algaworks.ecommerce.model.ItemPedido;
import com.algaworks.ecommerce.model.Pedido;
import com.algaworks.ecommerce.model.Produto;

public class RelacionamentoOneToManyTest extends EntityManagerAbstract {
	
	@Test
	public void verifyRelationPedido() {
		Cliente cliente = this.manager.find(Cliente.class, 1);
		Produto produto = this.manager.find(Produto.class, 1);
		
		Pedido pedido = new Pedido();
		
		ItemPedido itemPedido = new ItemPedido();
	}

}
