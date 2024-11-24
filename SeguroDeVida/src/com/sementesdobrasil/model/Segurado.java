package com.sementesdobrasil.model;



public class Segurado {
    private int id, idade;
    private String nome;
    private String genero;
    private String email;
    private String telefone;
    private String cpf;
    private String cep;
    private String senha;
    private String estadoCivil;

    // Construtores
    public Segurado(String nome, int idade, String genero, String email, String telefone, String cpf,
                    String cep, String senha, String estadoCivil) {
        super();
        this.nome = nome;
        this.idade = idade;
        this.genero = genero;
        this.email = email;
        this.telefone = telefone;
        this.cpf = cpf;
        this.cep = cep;
        this.senha = senha;
        this.estadoCivil = estadoCivil;
        
    }

    // Construtor criado para o controller
    public Segurado(String nome, String genero, String email, String telefone, String cpf,
                    String cep) {
        this.nome = nome;
        this.genero = genero;
        this.email = email;
        this.telefone = telefone;
        this.cpf = cpf;
        this.cep = cep;
    }

    // Construtor padrão
    public Segurado() {
    }

    public Segurado(String nome, int idade, String genero) {
		// TODO Auto-generated constructor stub
	}

	



	public Segurado(int idSegurado) {
		this.id = idSegurado;
	}

	// Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}


    // Métodos adicionais (se houver)
}
