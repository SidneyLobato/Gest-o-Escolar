package model.dao;

import model.Matricula;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MatriculaDAO {

    public void salvar(Matricula matricula) {
        String sql = "INSERT INTO matriculas (aluno_id, turma_id, data_matricula) VALUES (?, ?, ?)";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, matricula.getAluno().getId());
            stmt.setInt(2, matricula.getTurma().getId());
            stmt.setDate(3, Date.valueOf(matricula.getDataMatricula())); // converte LocalDate → java.sql.Date

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
