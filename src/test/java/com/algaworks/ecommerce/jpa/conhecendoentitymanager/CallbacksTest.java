package com.algaworks.ecommerce.jpa.conhecendoentitymanager;

import org.junit.Assert;
import org.junit.Test;

import com.algaworks.ecommerce.jpa.EntityManagerAbstract;
import com.algaworks.ecommerce.model.Cliente;
import com.algaworks.ecommerce.model.Pedido;
import com.algaworks.ecommerce.model.StatusPedido;

public class CallbacksTest extends EntityManagerAbstract {
	
	@Test
	public void acionarCallbacks() {
		
		Cliente cliente = this.manager.find(Cliente.class, 1);
		
		Pedido pedido = new Pedido();
		pedido.setStatus(StatusPedido.AGUARDANDO);
		pedido.setCliente(cliente);
		
		this.manager.getTransaction().begin();
		this.manager.flush();
		
		pedido.setStatus(StatusPedido.PAGO);		
		this.manager.getTransaction().commit();
		
		this.manager.clear();
		
		Pedido pedidoVerify = this.manager.find(Pedido.class, pedido.getId());
		Assert.assertNotNull(pedidoVerify.getDataPedido());
		Assert.assertNotNull(pedidoVerify.getDataUltimaAtualizacao());
	}
}
