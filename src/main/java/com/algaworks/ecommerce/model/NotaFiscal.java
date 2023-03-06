package com.algaworks.ecommerce.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "nota_fiscal")
public class NotaFiscal {

	@EqualsAndHashCode.Include
	@Id
	private Integer id;
	
	@OneToOne(optional = false, targetEntity = Pedido.class)
	@JoinColumn(name = "id_pedido")
	private Pedido pedido;

	private String xml;
	
	@Column(name = "data_emissao")
	private Date dataEmissao;
}
