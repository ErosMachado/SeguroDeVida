package com.sementesdobrasil.dao;

import com.sementesdobrasil.model.Segurado;
import com.sementesdobrasil.util.DatabaseConnection;
import java.sql.*;

public class SeguradoDAO {
	private DatabaseConnection conexao;
	private Connection connection;

	public SeguradoDAO() {
		this.conexao = new DatabaseConnection();
		this.connection = conexao.conectar();
	}

	public void save(Segurado segurado) throws SQLException {
		String sql = "INSERT INTO t_segurado (nome, data_nascimento, genero, email, telefone, cpf, cep, senha, estado_civil) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, segurado.getNome());
		stmt.setDate(2, Date.valueOf(segurado.getDataNascimento()));
		stmt.setString(3, segurado.getGenero());
		stmt.setString(4, segurado.getEmail());
		stmt.setString(5, segurado.getTelefone());
		stmt.setString(6, segurado.getCpf());
		stmt.setString(7, segurado.getCep());
		stmt.setString(8, segurado.getSenha());
		stmt.setString(9, segurado.getEstadoCivil());
		stmt.executeUpdate();
		stmt.close();
	}
	

}
