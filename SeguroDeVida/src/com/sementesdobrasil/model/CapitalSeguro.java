package com.sementesdobrasil.model;

public class CapitalSeguro {
	 private String descricao;
	 private double valor;
	 
	 //construtor
	public CapitalSeguro(String descricao, double valor) {
		super();
		this.descricao = descricao;
		this.valor = valor;
	}
	
	//getters and setters

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	 
	
	}
