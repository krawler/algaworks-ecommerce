package com.algaworks.ecommerce.jpa.relacionamentos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Test;

import com.algaworks.ecommerce.jpa.EntityManagerAbstract;
import com.algaworks.ecommerce.model.Cliente;
import com.algaworks.ecommerce.model.ItemPedido;
import com.algaworks.ecommerce.model.Pedido;
import com.algaworks.ecommerce.model.Produto;
import com.algaworks.ecommerce.model.StatusPedido;

public class RelacionamentoOneToManyTest extends EntityManagerAbstract {
	
	@Test
	public void verifyRelationPedido() {
		Cliente cliente = this.manager.find(Cliente.class, 1);
		Produto produto = this.manager.find(Produto.class, 1);
		
		Pedido pedido = new Pedido();
		pedido.setStatus(StatusPedido.AGUARDANDO);
		pedido.setDataPedido(LocalDateTime.now());
		pedido.setTotal(BigDecimal.TEN);
		pedido.setCliente(cliente);
		
		ItemPedido itemPedido = new ItemPedido();
		itemPedido.setPrecoProduto(produto.getPreco());
		itemPedido.setQuantidade(1);
		itemPedido.setPedido(pedido);
		itemPedido.setProduto(produto);
		
	    this.manager.getTransaction().begin();
	    this.manager.persist(pedido);
	    this.manager.persist(itemPedido);
	    this.manager.getTransaction().commit();
	    
	    this.manager.clear();
	    
	    Pedido pedidoVerify = this.manager.find(Pedido.class, pedido.getId());
	    Assert.assertFalse(pedidoVerify.getItems().isEmpty());
	}

}
