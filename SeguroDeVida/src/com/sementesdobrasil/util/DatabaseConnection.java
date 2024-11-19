package com.sementesdobrasil.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	public Connection conectar() {
		try {
			// Obtém o URL, o usuário e a senha do BD a partir das variáveis de ambiente
			String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
			// lembrar de, caso dê erro, há duas possibilidades:
			// 1. confuguração no eclipse: run as --> Run Configurations --> Environment
			// 2. adicionar no CMD (se for windows) com o comando "set"
			String usuario = System.getenv("DB_USUARIO");
			String senha = System.getenv("DB_SENHA");
			// Estabelece a conexão usando as credenciais das variáveis de ambiente
			return DriverManager.getConnection(url, usuario, senha);
		} catch (SQLException e) {
		}
		return null;
	}
}//
