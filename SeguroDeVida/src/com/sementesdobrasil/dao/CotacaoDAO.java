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


	public void saveCotacao(Cotacao cotacao) throws SQLException {
		String sql = "INSERT INTO T_COTACAO (ID_SEGURADO, ID_SEGURO, ID_CORRETOR, VALOR_FINAL, DATA_COTACAO) VALUES (?, ?, ?, ?, CURRENT_TIMESTAMP)";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setInt(1, cotacao.getSegurado().getId());  // ID do segurado
		stmt.setInt(2, cotacao.getSeguro().getId());    // ID do seguro
		stmt.setInt(3, cotacao.getCorretor().getId());  // ID do corretor
		stmt.setDouble(4, cotacao.getValorFinal());  // Valor final calculado
		stmt.executeUpdate();
	}
	
	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	// Metodos adicionais: buscar, atualizar, deletar cotacoes
}
