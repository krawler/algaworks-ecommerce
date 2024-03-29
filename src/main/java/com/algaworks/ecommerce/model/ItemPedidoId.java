package com.algaworks.ecommerce.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class ItemPedidoId implements Serializable {

		private static final long serialVersionUID = 1L;
		
		@EqualsAndHashCode.Include
		@Id
		@Column(name = "pedido_id")
		private Integer pedidoId;
		
		@EqualsAndHashCode.Include
		@Id
		@Column(name = "produto_id")
		private Integer produtoId;

}
