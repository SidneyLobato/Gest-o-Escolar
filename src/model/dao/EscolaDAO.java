package model.dao;

import model.Escola;
import java.sql.*;

public class EscolaDAO {
    public void salvar(Escola escola) {
        String sql = "INSERT INTO escolas (nome, endereco) VALUES (?, ?)";
        try (Connection conn = Conexao.getConexao(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, escola.getNome());
            stmt.setString(2, escola.getEndereco());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}