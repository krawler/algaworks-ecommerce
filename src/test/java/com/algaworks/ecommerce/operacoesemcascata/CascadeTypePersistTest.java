package com.algaworks.ecommerce.operacoesemcascata;

import com.algaworks.ecommerce.jpa.EntityManagerAbstract;
import com.algaworks.ecommerce.model.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;

public class CascadeTypePersistTest extends EntityManagerAbstract {

    @Test
    public void persistirPedidoComItens(){
        Cliente cliente = manager.find(Cliente.class, 1);
        Produto produto = manager.find(Produto.class, 1);

        Pedido pedido = new Pedido();
        pedido.setDataPedido(LocalDateTime.now());
        pedido.setCliente(cliente);
        pedido.setTotal(produto.getPreco());
        pedido.setStatus(StatusPedido.AGUARDANDO);

        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setPedido(pedido);
        itemPedido.setProduto(produto);
        itemPedido.setQuantidade(1);
        itemPedido.setPrecoProduto(produto.getPreco());

        pedido.setItems(Arrays.asList(itemPedido));

        manager.getTransaction().begin();
        manager.persist(itemPedido);
        manager.getTransaction().commit();

    }
}
