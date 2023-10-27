package com.algaworks.ecommerce.criteria;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.algaworks.ecommerce.jpa.EntityManagerAbstract;
import com.algaworks.ecommerce.model.NotaFiscal;
import com.algaworks.ecommerce.model.PagamentoCartao;
import com.algaworks.ecommerce.model.Pedido;

public class JoinCriteriaTest extends EntityManagerAbstract {
	
	private CriteriaBuilder builder;
	   
    @BeforeEach
    public void getBuildComponents(){
         builder = manager.getCriteriaBuilder();
    }     
    
    @Test
 	public void utilizarMetaModel() {
 		CriteriaQuery<NotaFiscal> query = builder.createQuery(NotaFiscal.class);
         Root<NotaFiscal> root = query.from(NotaFiscal.class);
         //Join<Pedido, PagamentoCartao> joinPagamento = root.join("pagamentoCartao");
         
         query.select(root);
         
         query.where(builder.or());
         
         TypedQuery<NotaFiscal> typedQuery = manager.createQuery(query);
         
         Calendar dataInicial = Calendar.getInstance();
         dataInicial.add(Calendar.DATE, -30); 
         typedQuery.setParameter("dataInicial", dataInicial.getTime());
         List<NotaFiscal> lista = typedQuery.getResultList();
         assertFalse(lista.isEmpty());        
 	}

    
    @Test
	public void passarParametroDate() {
		CriteriaQuery<NotaFiscal> query = builder.createQuery(NotaFiscal.class);
        Root<NotaFiscal> root = query.from(NotaFiscal.class);
        //Join<Pedido, PagamentoCartao> joinPagamento = root.join("pagamentoCartao");
        
        query.select(root);
        
        ParameterExpression<Date> parameterExpressionData = builder.parameter(Date.class, "dataInicial");
        
        query.where(builder.greaterThan(root.get("dataEmissao"), parameterExpressionData));
        
        TypedQuery<NotaFiscal> typedQuery = manager.createQuery(query);
        
        Calendar dataInicial = Calendar.getInstance();
        dataInicial.add(Calendar.DATE, -30); 
        typedQuery.setParameter("dataInicial", dataInicial.getTime());
        List<NotaFiscal> lista = typedQuery.getResultList();
        assertFalse(lista.isEmpty());        
	}

	
	@Test
	public void fazerJoin() {
		CriteriaQuery<Pedido> query = builder.createQuery(Pedido.class);
        Root<Pedido> root = query.from(Pedido.class);
        Join<Pedido, PagamentoCartao> joinPagamento = root.join("pagamentoCartao");
        //Join<Pedido, ItemPedido> joinItemPedido = root.join("items");
        //Join<ItemPedido, Produto> joinItemProduto = joinItemPedido.join("produto");
        
        //joinPagamento, joinItemPedido, joinItemProduto
        query.select(root);
        //query.where(builder.equal(joinPagamento.get("status"), StatusPagamento.PROCESSANDO));
        
        TypedQuery<Pedido> typedQuery = manager.createQuery(query);
        List<Pedido> lista = typedQuery.getResultList();
        assertFalse(lista.isEmpty());        
	}

}
