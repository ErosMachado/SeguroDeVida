package com.sementesdobrasil.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";

    public Connection conectar() throws SQLException {
        String usuario = System.getenv("DB_USUARIO");
        String senha = System.getenv("DB_SENHA");

        if (usuario == null || senha == null) {
            throw new IllegalStateException("Variáveis de ambiente DB_USUARIO e DB_SENHA não configuradas.");
        }

        try {
            return DriverManager.getConnection(URL, usuario, senha);
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
            throw e; 
        }
    }

    public void fecharConexao(Connection connection) {
        if (connection != null) {
            try {
                connection.close(); 
            } catch (SQLException e) {
                System.err.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
    }
}
