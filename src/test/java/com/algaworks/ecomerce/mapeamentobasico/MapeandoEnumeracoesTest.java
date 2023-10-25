package com.algaworks.ecomerce.mapeamentobasico;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.platform.commons.annotation.Testable;

import com.algaworks.ecommerce.jpa.EntityManagerAbstract;
import com.algaworks.ecommerce.model.Cliente;
import com.algaworks.ecommerce.model.SexoCliente;

public class MapeandoEnumeracoesTest extends EntityManagerAbstract {
	
	@Testable
	public void testEnum() {
		
		Cliente cliente = new Cliente();
		cliente.setNome("Rafael");
		cliente.setSexoCliente(SexoCliente.MASCULINMO);
		
		this.manager.getTransaction().begin();
		this.manager.persist(cliente);
		this.manager.getTransaction().commit();
		
		this.manager.clear();
		
		Cliente clienteVerify = this.manager.find(Cliente.class, 1);
		assertNotNull(clienteVerify);
	}

}
