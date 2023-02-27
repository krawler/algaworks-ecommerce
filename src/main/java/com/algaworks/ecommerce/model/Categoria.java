package com.algaworks.ecommerce.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "categoria")
public class Categoria implements Serializable {
	
	private static final long serialVersionUID = -3469625905502986906L;

	@EqualsAndHashCode.Include
	@Id
	private Integer id;
	
	private String nome;
	
	@Column(name = "categoria_pai_id")
	private Integer categoriaPaiId;
	
	@ManyToMany(mappedBy = "categorias")
	private List<Produto> produtos;
}
