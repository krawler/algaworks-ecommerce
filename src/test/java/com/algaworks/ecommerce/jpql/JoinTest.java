package com.algaworks.ecommerce.jpql;

import com.algaworks.ecommerce.jpa.EntityManagerAbstract;

import javax.persistence.TypedQuery;
import java.util.List;

import com.algaworks.ecommerce.model.Pedido;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JoinTest extends EntityManagerAbstract {

    @Test
    public void fazerJoin(){
        String jpql = "select p from Pedido p join p.items i where i.precoProduto > 10";

         TypedQuery<Object[]> typedQuery = manager.createQuery(jpql, Object[].class);

        List<Object[]> lista = typedQuery.getResultList();
        assertTrue(lista.size() == 1);
    }

    @Test
    public void fazerLeftJoin(){
        String jpql = "select p from Pedido p join p.pagamentoCartao pag on pag.status = 1";

        TypedQuery<Object[]> typedQuery = manager.createQuery(jpql, Object[].class);

        List<Object[]> lista = typedQuery.getResultList();
        assertTrue(lista.size() == 1);
    }

    @Test
    public void fazerJoinFetch(){
        String jpql = "select p from Pedido p join fetch p.cliente join fetch p.pagamentoCartao pag where p.id = 1";

        TypedQuery<Pedido> typedQuery = manager.createQuery(jpql, Pedido.class);

        Pedido pedido = typedQuery.getSingleResult();
        assertFalse(pedido.getItems().isEmpty());
    }

    @Test
    public void verificarSeElementoEstaEmItems(){
        String jpql = "select p from Pedido p where :item IS MEMBER p.items";

        TypedQuery<Pedido> typedQuery = manager.createQuery(jpql, Pedido.class);
        typedQuery.setParameter("item", 1);

        Pedido pedido = typedQuery.getSingleResult();
        assertFalse(pedido.getItems().isEmpty());
    }
}
