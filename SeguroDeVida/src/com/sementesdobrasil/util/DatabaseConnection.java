package com.sementesdobrasil.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	public Connection conectar() {
		try {
			// Obtem o URL, o usuario e a senha do BD a partir das variaveis de ambiente
			String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
			// lembrar de, caso de erro, ha duas possibilidades:
			// 1. confuguracao no eclipse: run as --> Run Configurations --> Environment
			// 2. adicionar no CMD (se for windows) com o comando "set"
			String usuario = System.getenv("DB_USUARIO");
			String senha = System.getenv("DB_SENHA");
			// Estabelece a conexao usando as credenciais das variaveis de ambiente
			return DriverManager.getConnection(url, usuario, senha);
		} catch (SQLException e) {
		}
		return null;
	}
}//
