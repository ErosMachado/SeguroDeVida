package com.sementesdobrasil.dao;

import com.sementesdobrasil.model.Cotacao;
import com.sementesdobrasil.util.DatabaseConnection;
import java.sql.*;

public class CotacaoDAO {
	private DatabaseConnection conexao;
	private Connection connection;

	public CotacaoDAO() throws SQLException {
		this.conexao = new DatabaseConnection();
		this.setConnection(conexao.conectar());
	}


	public void save(Cotacao cotacao) throws SQLException {
		String sql = "INSERT INTO cotacoes (segurado_id, seguro_tipo, valor_final, corretor_id) VALUES (?, ?, ?, ?)";
		PreparedStatement stmt = connection.prepareStatement(sql);
		// stmt.setInt(1, cotacao.getSegurado().getId());
		stmt.setString(2, cotacao.getSeguro().getTipo());
		stmt.setDouble(3, cotacao.getValorFinal());
		// stmt.setInt(4, cotacao.getCorretor().getId());
		stmt.executeUpdate();
		stmt.close();
	}
	
	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	// Metodos adicionais: buscar, atualizar, deletar cotacoes
}
