package com.sementesdobrasil.service;

import com.sementesdobrasil.model.Segurado;
import com.sementesdobrasil.dao.SeguradoDAO;
import com.sementesdobrasil.util.DatabaseConnection;
import java.sql.Connection;
import java.sql.SQLException;

public class SeguradoService {

    private SeguradoDAO seguradoDAO;
    private DatabaseConnection databaseConnection;

    public SeguradoService(SeguradoDAO seguradoDAO, DatabaseConnection databaseConnection) {
        this.seguradoDAO = seguradoDAO;
        this.databaseConnection = databaseConnection;
    }

    public SeguradoService() {
        this.databaseConnection = new DatabaseConnection(); // Cria��o da inst�ncia da classe DatabaseConnection
    }

    public SeguradoService(SeguradoDAO seguradoDAO2) {
		// TODO Auto-generated constructor stub
	}

	public void salvarSegurado(Segurado segurado) {
        Connection connection = null;
        try {
            connection = databaseConnection.conectar(); // Estabelece a conex�o
            seguradoDAO.save(segurado, connection); // Passa a conex�o para o DAO
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar segurado", e);
        } finally {
            databaseConnection.fecharConexao(connection); // Garante que a conex�o ser� fechada
        }
    }

    public SeguradoDAO getSeguradoDAO() {
        return seguradoDAO;
    }

    public void setSeguradoDAO(SeguradoDAO seguradoDAO) {
        this.seguradoDAO = seguradoDAO;
    }
}
