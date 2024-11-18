package com.sementesdobrasil.model;

public class Assistencia {
	private String nome;
	private String descricao;

	// construtor
	public Assistencia(String nome, String descricao) {
		super();
		this.nome = nome;
		this.descricao = descricao;
	}

	// getters and setters

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
