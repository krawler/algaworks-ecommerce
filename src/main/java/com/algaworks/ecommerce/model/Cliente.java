package com.algaworks.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "cliente")
public class Cliente {
	
	@EqualsAndHashCode.Include
	@Id
	private Integer id;
	
	private String nome;
	
	@Column(name = "sexo_cliente")
	private SexoCliente sexoCliente;

}
