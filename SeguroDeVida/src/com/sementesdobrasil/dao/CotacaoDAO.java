package com.sementesdobrasil.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sementesdobrasil.model.Cotacao;
import com.sementesdobrasil.util.DatabaseConnection;

public class CotacaoDAO {
	private DatabaseConnection conexao;
	private Connection connection;

	public CotacaoDAO() throws SQLException {
		this.conexao = new DatabaseConnection();
		this.setConnection(conexao.conectar());
	}


	public void saveCotacao(Cotacao cotacao) throws SQLException {
	    // Verificar se o Segurado existe
	    String sqlSegurado = "SELECT COUNT(*) FROM T_SEGURADO WHERE ID_SEGURADO = ?";
	    try (PreparedStatement stmtSegurado = connection.prepareStatement(sqlSegurado)) {
	        stmtSegurado.setInt(1, cotacao.getSegurado().getId());
	        ResultSet rsSegurado = stmtSegurado.executeQuery();
	        if (!rsSegurado.next() || rsSegurado.getInt(1) == 0) {
	        	System.out.println("ID_SEGURADO: " + cotacao.getSegurado().getId());
	            throw new SQLException("Segurado não encontrado.");
	        }
	    }
	    
	    

	    // Verificar se o Seguro existe
	    String sqlSeguro = "SELECT COUNT(*) FROM T_SEGURO WHERE ID_SEGURO = ?";
	    try (PreparedStatement stmtSeguro = connection.prepareStatement(sqlSeguro)) {
	        stmtSeguro.setInt(1, cotacao.getSeguro().getId());
	        ResultSet rsSeguro = stmtSeguro.executeQuery();
	        if (!rsSeguro.next() || rsSeguro.getInt(1) == 0) {
	            throw new SQLException("Seguro não encontrado.");
	        }
	    }

	    // Verificar se o Corretor existe (se não for null, ou seja, se houver um corretor)
	    if (cotacao.getCorretor() != null) {
	        String sqlCorretor = "SELECT COUNT(*) FROM T_CORRETOR WHERE ID_CORRETOR = ?";
	        try (PreparedStatement stmtCorretor = connection.prepareStatement(sqlCorretor)) {
	            stmtCorretor.setInt(1, cotacao.getCorretor().getId());
	            ResultSet rsCorretor = stmtCorretor.executeQuery();
	            if (!rsCorretor.next() || rsCorretor.getInt(1) == 0) {
	                throw new SQLException("Corretor não encontrado.");
	            }
	        }
	    }

	    // Inserir cotação, considerando que se não houver corretor, ID_CORRETOR é NULL
	    String sqlCotacao = "INSERT INTO T_COTACAO (ID_SEGURADO, ID_SEGURO, ID_CORRETOR, VALOR_FINAL) VALUES (?, ?, ?, ?)";
	    try (PreparedStatement stmtCotacao = connection.prepareStatement(sqlCotacao)) {
	        stmtCotacao.setInt(1, cotacao.getSegurado().getId());
	        stmtCotacao.setInt(2, cotacao.getSeguro().getId());
	        
	        // Se não houver corretor, passa NULL
	        if (cotacao.getCorretor() != null) {
	            stmtCotacao.setInt(3, cotacao.getCorretor().getId());
	        } else {
	            stmtCotacao.setNull(3, java.sql.Types.INTEGER);
	        }

	        stmtCotacao.setDouble(4, cotacao.getValorFinal());
	        stmtCotacao.executeUpdate();
	    }
	}
	public int getIdSeguroPorTipo(String tipoSeguro) throws SQLException {
	    String sql = "SELECT ID_SEGURO FROM T_SEGURO WHERE tipo = ?";
	    try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	        stmt.setString(1, tipoSeguro);
	        try (ResultSet rs = stmt.executeQuery()) {
	            if (rs.next()) {
	                return rs.getInt("ID_SEGURO");  
	            } else {
	                throw new SQLException("Tipo de seguro não encontrado: " + tipoSeguro);
	            }
	        }
	    }
	}


	
	/*private Seguro mapResultSetToSeguro(ResultSet rs) throws SQLException {
	    return new Seguro(
	        rs.getInt("id"),
	        rs.getString("profissao"),
	        rs.getDouble("salario"),
	        rs.getString("condicaoSaude"),
	        rs.getDouble("valorFinal") // ou outros atributos que o Seguro tiver
	    );
	}
*/

	
	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	// Metodos adicionais: buscar, atualizar, deletar cotacoes
}
