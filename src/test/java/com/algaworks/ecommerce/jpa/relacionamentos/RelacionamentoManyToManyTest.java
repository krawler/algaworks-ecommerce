package com.algaworks.ecommerce.jpa.relacionamentos;

import java.util.Arrays;

import com.algaworks.ecommerce.jpa.EntityManagerAbstract;
import com.algaworks.ecommerce.model.Categoria;
import com.algaworks.ecommerce.model.Cliente;
import com.algaworks.ecommerce.model.Produto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class RelacionamentoManyToManyTest extends EntityManagerAbstract {
	
	@Test
	public void verifyRelation() {
		
		Categoria categoria = this.manager.find(Categoria.class, 1);
		Produto produto = this.manager.find(Produto.class, 1);
		
		this.manager.getTransaction().begin();
		categoria.setProdutos(Arrays.asList(produto));
	    this.manager.persist(categoria);
	    produto.setCategorias(Arrays.asList(categoria));
	    this.manager.persist(produto);
	    this.manager.getTransaction().commit();
	    
	    this.manager.clear();
	    
	    Categoria categoriaVerify = this.manager.find(Categoria.class, categoria.getId());
	    assertFalse(categoriaVerify.getProdutos().isEmpty());
	    
	    Produto produtoVerify = this.manager.find(Produto.class, produto.getId());
	    assertFalse(produtoVerify.getCategorias().isEmpty());
	    
	}

}
