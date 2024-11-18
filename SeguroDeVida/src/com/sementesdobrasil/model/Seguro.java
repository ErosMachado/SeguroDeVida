package com.sementesdobrasil.model;

import java.util.List;

public class Seguro {
	private String tipo;
	private double valorBase;
	private double valorFinal;
	private String profissao;
	private double salario;
	private String condicaoSaude;
	private List<CapitalSeguro> capitaisSegurados;
	private List<Assistencia> assistencias;

	// construtor 1

	public Seguro(String tipo, double valorBase, double valorFinal, String profissao, double salario,
			String condicaoSaude, List<CapitalSeguro> capitaisSegurados, List<Assistencia> assistencias) {
		super();
		this.tipo = tipo;
		this.valorBase = valorBase;
		this.valorFinal = valorFinal;
		this.profissao = profissao;
		this.salario = salario;
		this.condicaoSaude = condicaoSaude;
		this.capitaisSegurados = capitaisSegurados;
		this.assistencias = assistencias;
	}

	// construtor 2
	public Seguro(String tipo, double valorBase, List<CapitalSeguro> capitaisSegurados,
			List<Assistencia> assistencias) {
		super();
		this.tipo = tipo;
		this.valorBase = valorBase;
		this.capitaisSegurados = capitaisSegurados;
		this.assistencias = assistencias;
	}

// getters and setters

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getValorBase() {
		return valorBase;
	}

	public void setValorBase(double valorBase) {
		this.valorBase = valorBase;
	}

	public List<CapitalSeguro> getCapitaisSegurados() {
		return capitaisSegurados;
	}

	public void setCapitaisSegurados(List<CapitalSeguro> capitaisSegurados) {
		this.capitaisSegurados = capitaisSegurados;
	}

	public List<Assistencia> getAssistencias() {
		return assistencias;
	}

	public void setAssistencias(List<Assistencia> assistencias) {
		this.assistencias = assistencias;
	}

	public double getValorFinal() {
		return valorFinal;
	}

	public void setValorFinal(double valorFinal) {
		this.valorFinal = valorFinal;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getCondicaoSaude() {
		return condicaoSaude;
	}

	public void setCondicaoSaude(String condicaoSaude) {
		this.condicaoSaude = condicaoSaude;
	}

	// Métodos adicionais
}
