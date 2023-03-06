package com.algaworks.ecommerce.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

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
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;
	
	@Column(name = "data_pedido")
	private LocalDateTime dataPedido;
	
	@Column(name = "data_conclusao")
	private LocalDateTime dataConclusao;
	
	@Column(name = "data_pagamento")
	private LocalDateTime dataPagamento;
	
	@Column(name = "data_ultima_atualizacao")
	private LocalDateTime dataUltimaAtualizacao;
	
	@Column(name = "pagamento")
	private PagamentoCartao pagamento;
	
	@OneToOne(mappedBy = "pedido")
	private NotaFiscal notaFiscal;
	
	private BigDecimal total;
	
	private StatusPedido status;
	
	@OneToMany
	private List<ItemPedido> items;
	
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
