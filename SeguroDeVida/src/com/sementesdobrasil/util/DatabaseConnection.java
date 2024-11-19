package com.sementesdobrasil.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	public Connection conectar() {
		try {
			// Obt�m o URL, o usu�rio e a senha do BD a partir das vari�veis de ambiente
			String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
			// lembrar de, caso d� erro, h� duas possibilidades:
			// 1. confugura��o no eclipse: run as --> Run Configurations --> Environment
			// 2. adicionar no CMD (se for windows) com o comando "set"
			String usuario = System.getenv("DB_USUARIO");
			String senha = System.getenv("DB_SENHA");
			// Estabelece a conex�o usando as credenciais das vari�veis de ambiente
			return DriverManager.getConnection(url, usuario, senha);
		} catch (SQLException e) {
		}
		return null;
	}
}//
