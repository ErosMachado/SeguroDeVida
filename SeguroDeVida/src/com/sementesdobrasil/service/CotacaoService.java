package com.sementesdobrasil.service;

import com.sementesdobrasil.model.Cotacao;
import com.sementesdobrasil.model.Segurado;
import com.sementesdobrasil.model.Seguro;
import java.time.LocalDate;
import com.sementesdobrasil.dao.CotacaoDAO;
import com.sementesdobrasil.util.ValidationUtil;

public class CotacaoService {
	private CotacaoDAO cotacaoDAO;

	public CotacaoService() {
		this.cotacaoDAO = new CotacaoDAO();
	}

	public Cotacao calcularCotacao(Segurado segurado, Seguro seguro) throws Exception {
		// Implementar lógica de cálculo baseada nas regras definidas
		double valorBase = 100.0; // Valor base fictício
		// Multiplicadores
		double multiplicadorIdade = calcularMultiplicadorIdade(segurado.getDataNascimento());
		double multiplicadorGenero = calcularMultiplicadorGenero(segurado.getGenero());
		double multiplicadorProfissao = calcularMultiplicadorProfissao(seguro.getProfissao());
		double multiplicadorSalario = calcularMultiplicadorSalario(seguro.getSalario());
		double multiplicadorSaude = calcularMultiplicadorSaude(seguro.getCondicaoSaude());

		// Cálculo final
		double valorFinal = valorBase * multiplicadorIdade * multiplicadorGenero * multiplicadorProfissao
				* multiplicadorSalario * multiplicadorSaude;
		seguro.setValorFinal(valorFinal);
		// Criação da cotação
		Cotacao cotacao = new Cotacao(segurado, seguro, valorFinal, null, null);
		// Corretor e Dependentes serão adicionados posteriormente
		// Salvar cotação
		cotacaoDAO.save(cotacao);
		return cotacao;
	}

	private double calcularMultiplicadorIdade(LocalDate dataNascimento) {
		int idade = Period.between(dataNascimento, LocalDate.now()).getYears();
		if (idade >= 18 && idade <= 30)
			return 1.0;
		if (idade >= 31 && idade <= 50)
			return 1.2;
		if (idade >= 51 && idade <= 65)
			return 1.5;
		if (idade >= 66 && idade <= 80)
			return 2.0;
		return 1.0; // Default
	}

	private double calcularMultiplicadorGenero(String genero) {
		if (genero.equalsIgnoreCase("Feminino"))
			return 0.9;
		return 1.0; // Masculino ou Outro
	}

	private double calcularMultiplicadorProfissao(String profissao) {
		switch (profissao.toLowerCase()) {
		case "administrativo":
			return 1.0;
		case "entrega":
			return 1.2;
		case "construção civil":
			return 1.5;
		default:
			return 1.0;
		}
	}

	private double calcularMultiplicadorSalario(double salario) {
		if (salario <= 3000)
			return 1.0;
		if (salario > 3000 && salario <= 10000)
			return 1.1;
		if (salario > 10000)
			return 1.3;
		return 1.0;
	}

	private double calcularMultiplicadorSaude(String condicaoSaude) {
		switch (condicaoSaude.toLowerCase()) {
		case "boa":
			return 1.0;
		case "leve":
			return 1.2;
		case "grave":
			return 1.5;
		default:

			return 1.0;
		}
	}
	// Outros métodos relacionados à cotação
}