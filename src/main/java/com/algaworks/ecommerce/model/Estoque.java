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
public class Estoque {
	
	@EqualsAndHashCode.Include
	@Id
	private Integer id;

	@OneToMany(mappedBy = "estoque")
	//@JoinColumn(name = "produto_id")
	private List<Produto> produtos;
	
	private Integer quantidade;
}
