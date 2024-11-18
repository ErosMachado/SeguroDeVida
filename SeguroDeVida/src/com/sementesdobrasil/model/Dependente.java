package com.sementesdobrasil.model;

import java.time.LocalDate;

public class Dependente {
	private String nome;
	private LocalDate dataNascimento;
	private String relacionamento;

	// construtor
	public Dependente(String nome, LocalDate dataNascimento, String relacionamento) {
		super();
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.relacionamento = relacionamento;
	}

	// getters and setters

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getRelacionamento() {
		return relacionamento;
	}

	public void setRelacionamento(String relacionamento) {
		this.relacionamento = relacionamento;
	}

	// Métodos adicionais
}
