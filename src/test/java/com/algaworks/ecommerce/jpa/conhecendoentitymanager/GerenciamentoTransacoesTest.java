package com.algaworks.ecommerce.jpa.conhecendoentitymanager;

import org.junit.jupiter.api.Test;

import com.algaworks.ecommerce.jpa.EntityManagerAbstract;
import com.algaworks.ecommerce.model.Pedido;
import com.algaworks.ecommerce.model.StatusPedido;

public class GerenciamentoTransacoesTest extends EntityManagerAbstract {

	
	@Test()
	public void openCloseTransaction() throws Exception {
		
		try {
			this.manager.getTransaction().begin();
			this.metodoDeNegocio();
			this.manager.getTransaction().commit();
		}catch(Exception e) {
			this.manager.getTransaction().rollback();
			throw e;
		}
	}
	
	private void metodoDeNegocio() {
		Pedido pedido = this.manager.find(Pedido.class, 1);
		pedido.setStatus(StatusPedido.PAGO);
		
		if(pedido.getDataPagamento() == null)
			throw new RuntimeException("Pedido ainda não foi pago");
	}
}
