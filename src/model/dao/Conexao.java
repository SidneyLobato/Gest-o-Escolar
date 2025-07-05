package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static final String URL = "jdbc:mysql://localhost:3306/sistema_escolar";
    private static final String USUARIO = "root";
    private static final String SENHA = ""; // defina se necessário

    public static Connection getConexao() throws SQLException {
        Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
        System.out.println(" Conexão com o banco de dados estabelecida com sucesso!");
        return conexao;
    }

    public static void main(String[] args) {
        try {
            getConexao();
        } catch (SQLException e) {
            System.out.println(" Erro ao conectar: " + e.getMessage());
        }
    }
}
