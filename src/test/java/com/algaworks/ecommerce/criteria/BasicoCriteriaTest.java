package com.algaworks.ecommerce.criteria;

import com.algaworks.ecommerce.jpa.EntityManagerAbstract;
import com.algaworks.ecommerce.model.Pedido;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BasicoCriteriaTest extends EntityManagerAbstract {

    private CriteriaBuilder builder;
   
    @BeforeEach
    public void getBuildComponents(){
         builder = manager.getCriteriaBuilder();
    }
    
    @Test
    public void projetarOResultado(){
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
        Root<Pedido> root = query.from(Pedido.class);

        query.multiselect(root);
        
        TypedQuery<Object[]> typedQuery = manager.createQuery(query);
        List<Object[]> lista = typedQuery.getResultList();
        assertFalse(lista.isEmpty());
        
        lista.forEach(arr -> System.out.println("ID: " + arr[0] + ", Nome: " + arr[1]));
    }
    
    @Test
    public void selecionarUmAtributoParaRetorno(){
        CriteriaQuery<BigDecimal> query = builder.createQuery(BigDecimal.class);
        Root<Pedido> root = query.from(Pedido.class);

        query.select(root.get("total"));
        query.where(builder.equal(root.get("id"), 1));
        TypedQuery<BigDecimal> typedQuery = manager.createQuery(query);
        BigDecimal total = typedQuery.getSingleResult();
        assertEquals(new BigDecimal("500.00"), total);
    }
    @Test
    public void buscarPorIdentificador(){
        CriteriaQuery<Pedido> query = builder.createQuery(Pedido.class);
        Root<Pedido> root = query.from(Pedido.class);

        TypedQuery<Pedido> typedQuery = manager.createQuery(query);

        List<Pedido> pedido = typedQuery.getResultList();
        assertNotNull(pedido);
    }
}
