package com.algaworks.ecommerce.jpa.relacionamentos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Test;

import com.algaworks.ecommerce.jpa.EntityManagerAbstract;
import com.algaworks.ecommerce.model.EnderecoEntregaPedido;
import com.algaworks.ecommerce.model.Pedido;
import com.algaworks.ecommerce.model.StatusPedido;

public class AnaliseMapObjectEmbededTest extends EntityManagerAbstract {

	@Test
	public void test() {
		EnderecoEntregaPedido endereco = new EnderecoEntregaPedido();
		endereco.setCep("18940-860");
		endereco.setLogradouro("Rua das Taringueiras");
		endereco.setNumero("30267");
		endereco.setBairro("Centro");
		endereco.setCidade("Piracicaba");
		endereco.setEstado("SP");
		
		Pedido pedido = new Pedido();
		pedido.setEnderecoEntrega(endereco);
		pedido.setDataPedido(LocalDateTime.now());
		pedido.setStatus(StatusPedido.AGUARDANDO);
		pedido.setTotal(new BigDecimal(10000));
		pedido.setEnderecoEntrega(endereco);
		
		this.manager.getTransaction().begin();
		this.manager.persist(pedido);
		this.manager.getTransaction().commit();
		
		Pedido pedidoVerify = this.manager.find(Pedido.class, pedido.getId());
		Assert.assertNotNull(pedidoVerify.getEnderecoEntrega());
	}

}
