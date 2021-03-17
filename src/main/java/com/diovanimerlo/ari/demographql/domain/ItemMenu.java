package com.diovanimerlo.ari.demographql.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class ItemMenu {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	
	private String nome;
	private BigDecimal preco;
	
	@ManyToOne (fetch = FetchType.LAZY)
	@JsonIgnore
	private Restaurante restaurante;
	
	protected ItemMenu() {
		
	}
	
	
	public ItemMenu(String nome, BigDecimal preco) {
		super();
		this.nome = nome;
		this.preco = preco;
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


	public BigDecimal getPreco() {
		return preco;
	}


	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	
	

	public Restaurante getRestaurante() {
		return restaurante;
	}


	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}


	@Override
	public String toString() {
		return "ItemMenu [id=" + id + ", nome=" + nome + ", preco=" + preco + "]";
	}
	
	
	
}
