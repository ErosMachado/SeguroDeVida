package com.sementesdobrasil.dao;

import com.sementesdobrasil.model.Segurado;
import com.sementesdobrasil.util.DatabaseConnection;
import java.sql.*;

public class SeguradoDAO {
	DatabaseConnection conexao = new DatabaseConnection();
	private Connection connection = conexao.conectar();


	public void save(Segurado segurado) throws SQLException {
		String sql = "INSERT INTO t_segurado (nome, idade, genero, email, telefone, cpf, cep, senha, estado_civil) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, segurado.getNome());
			stmt.setInt(2, segurado.getIdade());
			stmt.setString(3, segurado.getGenero());
			stmt.setString(4, segurado.getEmail());
			stmt.setString(5, segurado.getTelefone());
			stmt.setString(6, segurado.getCpf());
			stmt.setString(7, segurado.getCep());
			stmt.setString(8, segurado.getSenha());
			stmt.setString(9, segurado.getEstadoCivil());
			stmt.executeUpdate();
		}
	}
	
	
	public int getIdSeguradoLogado(String email) throws SQLException {
	    String sql = "SELECT id_segurado FROM t_segurado WHERE email = ?";
	    try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	        stmt.setString(1, email);
	        try (ResultSet rs = stmt.executeQuery()) {
	            if (rs.next()) {
	                return rs.getInt("id_segurado");
	            } else {
	                throw new SQLException("Segurado não encontrado para o usuário logado: " + email);
	            }
	        }
	    }
	}

	
	
	public boolean validarCredenciais(String email, String senha) {
	    String sql = "SELECT COUNT(*) FROM t_segurado WHERE email = ? AND senha = ?";
	    try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	        stmt.setString(1, email);
	        stmt.setString(2, senha);
	        try (ResultSet rs = stmt.executeQuery()) {
	            if (rs.next()) {
	                return rs.getInt(1) == 1; // Deve existir apenas 1 registro para o login ser válido
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return false;
	}
	
	public Segurado getSeguradoByEmailSenha(String email, String senha) throws SQLException {
	    String sql = "SELECT * FROM t_segurado WHERE email = ? AND senha = ?";
	    try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	        stmt.setString(1, email);
	        stmt.setString(2, senha);
	        
	        try (ResultSet rs = stmt.executeQuery()) {
	            if (rs.next()) {
	                // Recuperando os dados e criando o objeto Segurado
	            	//int id = rs.getInt("id_segurado");
	                String nome = rs.getString("nome");
	                int idade = rs.getInt("idade");
	                String genero = rs.getString("genero");
	                String telefone = rs.getString("telefone");
	                String cpf = rs.getString("cpf");
	                String cep = rs.getString("cep");
	                String estadoCivil = rs.getString("estado_civil");
	                String senhaDB = rs.getString("senha");
	                
	                return new Segurado(nome, idade, genero, email, telefone, cpf, cep, senhaDB, estadoCivil);

	            }
	        }
	    }
	    return null;  // Retorna null caso não encontre o segurado
	}


	

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	


}
