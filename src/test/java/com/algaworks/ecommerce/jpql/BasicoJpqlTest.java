package com.algaworks.ecommerce.jpql;

import com.algaworks.ecommerce.dto.ProdutoDTO;
import com.algaworks.ecommerce.jpa.EntityManagerAbstract;
import com.algaworks.ecommerce.model.Cliente;
import com.algaworks.ecommerce.model.Pedido;
import org.junit.jupiter.api.Test;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BasicoJpqlTest extends EntityManagerAbstract {

	@Test
	public void projetarNoDTO() {
		String jpql = "select new com.algaworks.ecommerce.dto.ProdutoDTO(id, nome) from Produto";
		TypedQuery<ProdutoDTO> typedQuery = manager.createQuery(jpql, ProdutoDTO.class);
		List<ProdutoDTO> lista = typedQuery.getResultList();

		lista.forEach(p -> System.out.println(p.getId() + " - " + p.getNome()));
	}

	@Test
	public void selecionarUmAtributoParaRetorno() {
		String jpql = "select p.nome from Produto p";

		TypedQuery<String> typedQuery = manager.createQuery(jpql, String.class);
		List<String> lista = typedQuery.getResultList();
		assertTrue(String.class.equals(lista.get(0).getClass()));

		String jpqlCliente = "select p.cliente from Pedido p";
		TypedQuery<Cliente> typedQueryCliente = manager.createQuery(jpqlCliente, Cliente.class);
		List<Cliente> listClientes = typedQueryCliente.getResultList();
		assertTrue(listClientes.get(0).getClass().equals(Cliente.class));
	}

	@Test
	public void buscarPorIdentificador() {
		TypedQuery<Pedido> typedQuery = manager.createQuery("select p from Pedido p where p.id = 1", Pedido.class);
		Pedido pedido = typedQuery.getSingleResult();
		assertNotNull(pedido);
	}

	@Test
	public void mostrarDiferencaQuery() {
		String jsql = "select p from Pedido p where p.id = 1";

		TypedQuery<Pedido> typedQuery = manager.createQuery(jsql, Pedido.class);
		Pedido pedido = typedQuery.getSingleResult();
		assertNotNull(pedido);

		Query query = manager.createQuery(jsql);
		Pedido pedido2 = (Pedido) query.getSingleResult();
		assertNotNull(pedido);
	}

}
