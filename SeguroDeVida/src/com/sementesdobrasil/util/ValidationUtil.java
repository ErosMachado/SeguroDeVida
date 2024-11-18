package com.sementesdobrasil.util;

public class ValidationUtil {
	public static boolean isCPFValid(String cpf) {
		// Implementar validação de CPF
		return true; // Placeholder
	}

	public static boolean isEmailValid(String email) {
		return email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
	}
	// Outros métodos de validação
}
