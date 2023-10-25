package com.algaworks.ecommerce.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name="pedido")
public class Pedido {
	
	@EqualsAndHashCode.Include
	@Id
	private Integer id;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "id_cliente", nullable = false,
			    foreignKey = @ForeignKey(name = "fk_pedido_cliente"))
	private Cliente cliente;

	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
	private List<ItemPedido> items;
	
	@Column(name = "data_pedido")
	private LocalDateTime dataPedido;
	
	@Column(name = "data_conclusao")
	private LocalDateTime dataConclusao;
	
	@Column(name = "data_pagamento")
	private LocalDateTime dataPagamento;
	
	@Column(name = "data_ultima_atualizacao")
	private LocalDateTime dataUltimaAtualizacao;

	@Column(name = "pagamento_cartao")
	@OneToMany(mappedBy = "pedido")
	private List<PagamentoCartao> pagamentoCartao;
	
	@Column(name = "nota-fiscal")
	@OneToMany(mappedBy = "pedido")
	private List<NotaFiscal> notasFiscais;
	
	private BigDecimal total;
	
	private StatusPedido status;
	
	@Embedded
	private EnderecoEntregaPedido enderecoEntrega;
	
	@PrePersist
	public void atPersist() {
		dataPedido = LocalDateTime.now();
	}
	
	@PreUpdate
	public void atUpdate() {
		dataUltimaAtualizacao = LocalDateTime.now();
	}

}
