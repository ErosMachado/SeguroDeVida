package com.sementesdobrasil.model;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.sementesdobrasil.util.DataUtils;

public class Segurado {
	private String nome;
	private LocalDate dataNascimento;
	private String genero;
	private String email;
	private String telefone;
	private String cpf;
	private String cep;
	private String senha;
	private String estadoCivil;

	// Construtores

	public Segurado(String nome, String dataNascimento, String genero, String email, String telefone, String cpf,
			String cep, String senha, String estadoCivil) {
		super();
		this.nome = nome;
        this.dataNascimento = DataUtils.converterDataNascimento(dataNascimento);
		this.genero = genero;
		this.email = email;
		this.telefone = telefone;
		this.cpf = cpf;
		this.cep = cep;
		this.senha = senha;
		this.estadoCivil = estadoCivil;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	// construtor criado para o controller
	public Segurado(String nome, String dataNascimento, String genero, String email, String telefone, String cpf,
			String cep) {
		this.nome = nome;
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		this.dataNascimento = LocalDate.parse(dataNascimento, formato);
		this.genero = genero;
		this.email = email.toLowerCase();
		this.telefone = telefone;
		this.cpf = cpf;
		this.cep = cep;
	}

	
	//criei para o getSeguradoByEmailSenha do SeguradoDAO
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
		this.email = email.toLowerCase();
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
