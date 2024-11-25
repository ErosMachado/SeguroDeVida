package com.sementesdobrasil.dao;

import java.sql.Connection;

import com.sementesdobrasil.util.DatabaseConnection;

public class DependenteDAO {
	DatabaseConnection conexao = new DatabaseConnection();
	private Connection connection = conexao.conectar();
	
	
	
	
	
	public DatabaseConnection getConexao() {
		return conexao;
	}
	public void setConexao(DatabaseConnection conexao) {
		this.conexao = conexao;
	}
	public Connection getConnection() {
		return connection;
	}
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	

}
