package com.sementesdobrasil.model;


public class Dependente {
    private int id_dependente;
    private String nome;
    private String relacionamento;
    private int idade;
    private String genero;
    private String email;
    private String cpf;
    private String telefone;
    private String estadoCivil;
    private boolean dependenciaFinanceira;
    private String observacoes;



	public Dependente(int id_dependente, String nome, String relacionamento, int idade, String genero, String email,
			String cpf, String telefone, String estadoCivil, boolean dependenciaFinanceira, String observacoes) {
		super();
		this.id_dependente = id_dependente;
		this.nome = nome;
		this.relacionamento = relacionamento;
		this.idade = idade;
		this.genero = genero;
		this.email = email;
		this.cpf = cpf;
		this.telefone = telefone;
		this.estadoCivil = estadoCivil;
		this.dependenciaFinanceira = dependenciaFinanceira;
		this.observacoes = observacoes;
	}

	// construtor vazio
	
	public Dependente() {}
	
	

	// getters and setters

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getRelacionamento() {
		return relacionamento;
	}

	public void setRelacionamento(String relacionamento) {
		this.relacionamento = relacionamento;
	}

	public int getId_dependente() {
		return id_dependente;
	}

	public void setId_dependente(int id_dependente) {
		this.id_dependente = id_dependente;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public boolean isDependenciaFinanceira() {
		return dependenciaFinanceira;
	}

	public void setDependenciaFinanceira(boolean dependenciaFinanceira) {
		this.dependenciaFinanceira = dependenciaFinanceira;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	
	
	// Métodos adicionais
}
