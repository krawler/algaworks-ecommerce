package com.algaworks.ecommerce.mapeamentoavancado;

import java.util.Arrays;

import com.algaworks.ecommerce.jpa.EntityManagerAbstract;
import com.algaworks.ecommerce.model.Atributo;
import com.algaworks.ecommerce.model.Produto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class ElementCollectionTest extends EntityManagerAbstract {

	@Test
	public void aplicarTags() {
		manager.getTransaction().begin();
		
		Produto produto = manager.find(Produto.class, 1);
		produto.setTags(Arrays.asList("ebook","livro-digital","livro-fisico"));
		
		manager.getTransaction().commit();
		manager.clear();
		
		Produto produtoVerify = manager.find(Produto.class, produto.getId());
		assertFalse(produtoVerify.getTags().isEmpty());
	}
	
	@Test
	public void aplicarAtributos() {
		manager.getTransaction().begin();
		
		Produto produto = manager.find(Produto.class, 1);
		produto.setAtributos(Arrays.asList(new Atributo("largura", "30cm"), new Atributo("altura", "18cm")));
		
		manager.getTransaction().commit();
		manager.clear();
		
		Produto produtoVerify = manager.find(Produto.class, produto.getId());
		assertFalse(produtoVerify.getAtributos().isEmpty());
	}
}
