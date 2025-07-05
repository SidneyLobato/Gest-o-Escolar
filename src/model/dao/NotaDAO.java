package model.dao;

import model.Nota;
import java.sql.*;

public class NotaDAO {
    public void salvar(Nota nota) {
        String sql = "INSERT INTO notas (aluno_id, turma_id, bimestre, valor) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexao.getConexao(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, nota.getAluno().getId());
            stmt.setInt(2, nota.getTurma().getId());
            stmt.setInt(3, nota.getBimestre());
            stmt.setDouble(4, nota.getValor());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}