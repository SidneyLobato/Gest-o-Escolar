package model.dao;

import model.Frequencia;
import java.sql.*;

public class FrequenciaDAO {
    public void salvar(Frequencia freq) {
        String sql = "INSERT INTO frequencias (aluno_id, turma_id, data, presente) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexao.getConexao(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, freq.getAluno().getId());
            stmt.setInt(2, freq.getTurma().getId());
            stmt.setDate(3, Date.valueOf(freq.getData()));
            stmt.setBoolean(4, freq.isPresente());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}