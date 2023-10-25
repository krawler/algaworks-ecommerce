package com.algaworks.ecommerce.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

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

	@Lob
	private byte[] foto;
	
	@Column(name = "data_criacao", updatable = false)
	private LocalDateTime dataCriacao;
	
	@Column(name = "data_ultima_atualizacao", insertable = false)
	private LocalDateTime dataUltimaAtualizacao;
	
	@ManyToMany
	@JoinTable(name = "produto_categoria", 
			   joinColumns = @JoinColumn(name="produto_id", nullable = false,
			   							 foreignKey = @ForeignKey(name = "fk_produto_categoria_produto")),
			   inverseJoinColumns = @JoinColumn(name = "categoria_id", nullable = false,
			   									foreignKey = @ForeignKey(name = "fk_produto_categoria_categoria")))
	private List<Categoria> categorias;


	@ManyToOne(targetEntity = Estoque.class)
	private Estoque estoque;
	
	@ElementCollection
	@CollectionTable(name = "produto_tag",
			     	 joinColumns = @JoinColumn(name = "produto_id", nullable = false,
					 						   foreignKey = @ForeignKey(name = "fk_produto_tag_produto")))
	@Column(name = "tag")
	private List<String> tags;
	
	@ElementCollection
	@CollectionTable(name = "produto_atributo",
					 joinColumns = @JoinColumn(name = "produto_id", nullable = false,
											   foreignKey = @ForeignKey(name = "fk_produto_atributo_produto")))
	private List<Atributo> atributos;

}
