package com.algaworks.ecommerce.model;

import javax.persistence.*;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "pagamento_cartao")
public class PagamentoCartao {

	@EqualsAndHashCode.Include
	@Id
	private Integer id;

	@ManyToOne(optional = false, targetEntity = Pedido.class)
	@JoinColumn(name = "pedido_id",	foreignKey = @ForeignKey(name = "fk_pedido"))
	private Pedido pedido;
	
	private StatusPagamento status;
	
	private String numero;
}
