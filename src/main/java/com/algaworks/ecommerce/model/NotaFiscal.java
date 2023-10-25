package com.algaworks.ecommerce.model;

import java.util.Date;

import javax.persistence.*;

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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(optional = false, targetEntity = Pedido.class)
	@JoinColumn(name = "id_pedido", nullable = false,
								foreignKey = @ForeignKey(name = "fk_nota_fiscal_pedido_nota_fiscal"))
	private Pedido pedido;

	@Column(name = "xml", nullable = false)
	private String xml;
	
	@Column(name = "data_emissao", nullable = false)
	private Date dataEmissao;
}
