package com.algaworks.ecommerce.jpa.conhecendoentitymanager;

import com.algaworks.ecommerce.jpa.EntityManagerAbstract;
import com.algaworks.ecommerce.model.Cliente;
import com.algaworks.ecommerce.model.Pedido;
import com.algaworks.ecommerce.model.StatusPedido;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

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

		assertNotNull(pedidoVerify.getDataPedido());
		assertNotNull(pedidoVerify.getDataUltimaAtualizacao());
	}
}
