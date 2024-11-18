package com.sementesdobrasil.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Segurado {
	private String nome;
	private LocalDate dataNascimento;
	private String genero;
	private String email;
	private String telefone;
	private String cpf;
	private String cep;
	private String senha;

	// Construtores

	public Segurado(String nome, String dataNascimento, String genero, String email, String telefone, String cpf,
			String cep, String senha) {
		super();
		this.nome = nome;
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		this.dataNascimento = LocalDate.parse(dataNascimento, formato);
		this.genero = genero;
		this.email = email;
		this.telefone = telefone;
		this.cpf = cpf;
		this.cep = cep;
		this.senha = senha;
	}
	//construtor criado para o controller
	public Segurado(String nome, String dataNascimento, String genero, String email, String telefone, String cpf,
			String cep) {
		this.nome = nome;
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		this.dataNascimento = LocalDate.parse(dataNascimento, formato);
		this.genero = genero;
		this.email = email;
		this.telefone = telefone;
		this.cpf = cpf;
		this.cep = cep;
		}
	
	//construtor vazio (caso necessário)
	public Segurado() {
		
	}

	// Getters e Setters
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

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	// Métodos adicionais
}
