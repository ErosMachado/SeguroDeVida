package com.sementesdobrasil.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	public Connection conectar() {
		try {
			// pega o URL, o usuario e a senha do BD a partir das variaveis de ambiente
			String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
			// lembrar de, caso d� erro, h� duas possibilidades:
			// 1. configura��o no eclipse: run as --> Run Configurations --> Environment
			// 2. adicionar no CMD (se for windows) com o comando "set"
			String usuario = System.getenv("DB_USUARIO");
			String senha = System.getenv("DB_SENHA");
			if (usuario == null || senha == null) {
				throw new IllegalStateException("Vari�veis de ambiente DB_USUARIO e DB_SENHA n�o configuradas.");
			}
			// Estabelece a conex�o usando as credenciais das variaveis de ambiente
			return DriverManager.getConnection(url, usuario, senha);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
