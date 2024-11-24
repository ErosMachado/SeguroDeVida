package com.sementesdobrasil.model;

import java.util.List;

public class Cotacao {
	private Segurado segurado;
	private Seguro seguro;
	private double valorFinal;
	private Corretor corretor;
	private List<Dependente> dependentes;

	// construtor
	public Cotacao(Segurado segurado, Seguro seguro, double valorFinal, Corretor corretor,
			List<Dependente> dependentes) {
		super();
		this.segurado = segurado;
		this.seguro = seguro;
		this.valorFinal = valorFinal;
		this.corretor = corretor;
		this.dependentes = dependentes;
	}

	// getters and setters

	public Cotacao() {
		// TODO Auto-generated constructor stub
	}

	public Segurado getSegurado() {
		return segurado;
	}

	public void setSegurado(Segurado segurado) {
		this.segurado = segurado;
	}

	public Seguro getSeguro() {
		return seguro;
	}

	public void setSeguro(Seguro seguro) {
		this.seguro = seguro;
	}

	public double getValorFinal() {
		return valorFinal;
	}

	public void setValorFinal(double valorFinal) {
		this.valorFinal = valorFinal;
	}

	public Corretor getCorretor() {
		return corretor;
	}

	public void setCorretor(Corretor corretor) {
		this.corretor = corretor;
	}

	public List<Dependente> getDependentes() {
		return dependentes;
	}

	public void setDependentes(List<Dependente> dependentes) {
		this.dependentes = dependentes;
	}

}
