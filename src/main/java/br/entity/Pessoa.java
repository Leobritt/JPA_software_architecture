package br.entity;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity // Spring anotation que indica que a classe é uma entidade
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // Auto increment

	private UUID id;
	private String nome;
	@OneToOne
	private Usuario usuario;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
/*
 * relation one to many
 * não precisa declarar nas duas entidades iria declarar em N
 * 1 Pessoa tem N telefones
 * 
 * @OneToMany
 * private List<Telefone> telefones;
 * 
 * relation many to many
 * 
 * @ManyToMany
 * private List<Pessoa> pessoas;
 * tabela associativa gerada automaticamente pela ORM
 * 
 * poderia ser feito com @JoinTable
 * ambas com as relações @OneToMany e @ManyToMany
 * 
 * anotação @JoinTable está dizendo:
 * Crie uma tabela de junção chamada grupo_pessoa com duas colunas: grupo_id
 * que contém as
 * chaves estrangeiras para a entidade Grupo, e pessoa_id que contém as chaves
 * estrangeiras
 * para a entidade Pessoa
 * 
 * @ManyToMany
 * 
 * @JoinTable(
 * name = "grupo_pessoa",
 * joinColumns = @JoinColumn(name = "grupo_id"),
 * inverseJoinColumns = @JoinColumn(name = "pessoa_id")
 * )
 * private List<Pessoa> pessoas;
 */