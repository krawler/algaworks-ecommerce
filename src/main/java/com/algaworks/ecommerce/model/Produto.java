package com.algaworks.ecommerce.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "produto")
public class Produto implements Serializable {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String nome;
	
	@Column
	private String descricao;
	
	@Column
	private BigDecimal preco;
	
	@Column(name = "data_criacao", updatable = false)
	private LocalDateTime dataCriacao;
	
	@Column(name = "data_ultima_atualizacao", insertable = false)
	private LocalDateTime dataUltimaAtualizacao;
	
	@ManyToMany
	@JoinTable(name = "produto_categoria", 
			   joinColumns = @JoinColumn(name="produto_id"), 
			   inverseJoinColumns = @JoinColumn(name = "categoria_id"))
	private List<Categoria> categorias;
	
	@ElementCollection
	@CollectionTable(name = "produto_tag", joinColumns = @JoinColumn(name = "produto_id"))
	@Column(name = "tag")
	private List<String> tags;
	
	@ElementCollection
	@CollectionTable(name = "produto_atributo", joinColumns = @JoinColumn(name = "produto_id"))
	private List<Atributo> atributos;

}
