package model.dao;

import model.Professor;
import java.sql.*;

public class ProfessorDAO {

    public Professor buscarPorId(int id) {
        String sql = "SELECT * FROM professores WHERE id = ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Professor professor = new Professor();
                professor.setId(rs.getInt("id"));
                professor.setNome(rs.getString("nome"));
                professor.setCpf(rs.getString("cpf"));
                return professor;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}