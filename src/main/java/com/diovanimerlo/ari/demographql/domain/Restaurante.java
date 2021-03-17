package com.diovanimerlo.ari.demographql.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Restaurante {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private long id;
	
	private String nome;
	private String cnpj;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_endereco")
	private Endereco endereco;
	
	@OneToMany(mappedBy = "restaurante", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	//@JoinColumn(name="id_restaurante")
	@JsonIgnore
	private List<ItemMenu> itensMenu = new ArrayList<ItemMenu>();
	
	protected Restaurante() {
		
	}

	public Restaurante(String nome, String cnpj) {
		super();
		this.nome = nome;
		this.cnpj = cnpj;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<ItemMenu> getItensMenu() {
		return itensMenu;
	}

	public void setItensMenu(List<ItemMenu> itensMenu) {
		this.itensMenu = itensMenu;
	}

	@Override
	public String toString() {
		return "Restaurante [id=" + id + ", nome=" + nome + ", cnpj=" + cnpj + ", endereco=" + endereco + "]";
	}
	
	
	
	
}
