package com.sementesdobrasil.service;

import com.sementesdobrasil.model.Cotacao;
import com.sementesdobrasil.model.Segurado;
import com.sementesdobrasil.model.Seguro;

import java.sql.SQLException;
import com.sementesdobrasil.dao.CotacaoDAO;

public class CotacaoService {
	private CotacaoDAO cotacaoDAO;

	public CotacaoService() throws SQLException {
		this.cotacaoDAO = new CotacaoDAO();
	}

	public Cotacao calcularCotacao(Segurado segurado, Seguro seguro) throws Exception {
		// Implementar l gica de cálculo baseada nas regras definidas
		double valorBase = 100.0; // Valor base figurado
		// Multiplicadores
		double multiplicadorIdade = calcularMultiplicadorIdade(segurado.getIdade());
		double multiplicadorGenero = calcularMultiplicadorGenero(segurado.getGenero());
		double multiplicadorProfissao = calcularMultiplicadorProfissao(seguro.getProfissao());
		double multiplicadorSalario = calcularMultiplicadorSalario(seguro.getSalario());
		double multiplicadorSaude = calcularMultiplicadorSaude(seguro.getCondicaoSaude());

		// Calculo final
		double valorFinal = valorBase * multiplicadorIdade * multiplicadorGenero * multiplicadorProfissao
				* multiplicadorSalario * multiplicadorSaude;
		seguro.setValorFinal(valorFinal);
		Cotacao cotacao = new Cotacao(segurado, seguro, valorFinal, null, null);
		// Corretor e Dependentes serão adicionados posteriormente
		cotacaoDAO.saveCotacao(cotacao);
		return cotacao;
	}

	private double calcularMultiplicadorIdade(int idade) {
		if (idade >= 18 && idade <= 30)
			return 1.0;
		if (idade >= 31 && idade <= 50)
			return 1.2;
		if (idade >= 51 && idade <= 65)
			return 1.5;
		if (idade >= 66 && idade <= 80)
			return 2.0;
		return 1.0;
	}

	private double calcularMultiplicadorGenero(String genero) {
		if (genero.equalsIgnoreCase("Feminino"))
			return 0.9;
		return 1.0;
	}

	private double calcularMultiplicadorProfissao(String profissao) {
		switch (profissao.toLowerCase()) {
		case "administrativo":
			return 1.0;
		case "entrega":
			return 1.2;
		case "constru  o civil":
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

	public String definirTipoSeguro(String genero, int idade, String profissao, String faixaSalarial) {
		if (genero.equalsIgnoreCase("Feminino") && idade <= 30) {
			return "Seguro Mulher Básico";
		} else if (genero.equalsIgnoreCase("Masculino") && idade <= 30) {
			return "Seguro Homem Básico";
		} else if (genero.equalsIgnoreCase("Feminino") && idade > 30) {
			return "Seguro Mulher Premium";
		} else {
			return "Seguro Homem Premium";
		}
	}

	public double calcularValorFinal(String genero, int idade, String profissao, String faixaSalarial) {
		double valorBase = 100.0;

		// Multiplicadores
		double multiplicadorGenero = genero.equalsIgnoreCase("Feminino") ? 0.9 : 1.0;
		double multiplicadorIdade = (idade <= 30) ? 1.0 : (idade <= 50) ? 1.2 : 1.5;
		double multiplicadorProfissao = (profissao.contains("Risco") || profissao.contains("Perigoso")) ? 1.5 : 1.0;
		double multiplicadorSalario = (faixaSalarial.contains("Acima de 5050")) ? 1.3 : 1.0;

		return valorBase * multiplicadorGenero * multiplicadorIdade * multiplicadorProfissao * multiplicadorSalario;
	}

	public String obterCapitaisSegurados(String tipoSeguro) {
		switch (tipoSeguro) {
		case "Seguro Mulher Básico":
			return """
					BÁSICA (MORTE): R$ 50.000,00
					MORTE ACIDENTAL: R$ 40.000,00
					FUNERAL: R$ 10.000,00
					""";
		case "Seguro Mulher Premium":
			return """
					BÁSICA (MORTE): R$ 100.000,00
					MORTE ACIDENTAL: R$ 80.000,00
					DOENÇAS GRAVES: R$ 20.000,00
					FUNERAL: R$ 20.000,00
					""";
		case "Seguro Homem Básico":
			return """
					BÁSICA (MORTE): R$ 50.000,00
					MORTE ACIDENTAL: R$ 30.000,00
					FUNERAL: R$ 10.000,00
					""";
		case "Seguro Homem Premium":
			return """
					BÁSICA (MORTE): R$ 150.000,00
					MORTE ACIDENTAL: R$ 100.000,00
					DOENÇAS GRAVES: R$ 30.000,00
					FUNERAL: R$ 20.000,00
					""";
		default:
			return "Capitais Segurados Indisponíveis";
		}
	}

}