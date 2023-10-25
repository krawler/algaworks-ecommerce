package com.algaworks.ecommerce.jpql;

import com.algaworks.ecommerce.jpa.EntityManagerAbstract;
import com.algaworks.ecommerce.model.Pedido;
import org.junit.jupiter.api.Test;

import javax.persistence.TypedQuery;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PathExpressionTest extends EntityManagerAbstract {

    @Test
    public void usarPathExpressions(){
        String jpql = "select p from Pedido p where p.cliente.nome = 'Maria da silva'";

        TypedQuery<Pedido> typedQuery = manager.createQuery(jpql, Pedido.class);

        Pedido pedido = typedQuery.getSingleResult();
        assertFalse(pedido.getItems().isEmpty());
    }
    @Test
    public void ExercicioBuscaProdutoInPathExpression(){
        String jpql = "select distinct p from Pedido p join fetch p.items i where i in(from ItemPedido where produto.id = 1)";

        TypedQuery<Pedido> typedQuery = manager.createQuery(jpql, Pedido.class);

        List<Pedido> pedidos = typedQuery.getResultList();
        assertTrue(pedidos.size() > 0);
    }

    @Test
    public void usarIsEmpty(){
        String jpql = "";

        TypedQuery<Object[]> typedQuery = manager.createQuery(jpql, Object[].class);

        List<Object[]> lista = typedQuery.getResultList();
        assertFalse(lista.isEmpty());
    }

    @Test
    public void testarDDL(){

    }
}
