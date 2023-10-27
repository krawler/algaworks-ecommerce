package com.algaworks.ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
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
