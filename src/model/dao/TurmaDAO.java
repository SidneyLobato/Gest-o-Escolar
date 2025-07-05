package model.dao;

import model.Professor;
import model.Turma;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TurmaDAO {

    // Salva nova turma no banco
    public void salvar(Turma turma) {
        String sql = "INSERT INTO turmas (nome, serie, turno, ano, professor_id) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, turma.getNome());
            stmt.setString(2, turma.getSerie());
            stmt.setString(3, turma.getTurno());
            stmt.setInt(4, turma.getAno());
            stmt.setInt(5, turma.getProfessor().getId());

            stmt.executeUpdate();
            System.out.println("✅ Turma salva com sucesso: " + turma.getNome());

        } catch (SQLException e) {
            System.err.println("❌ Erro ao salvar turma: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Lista todas as turmas (para matrícula ou visão administrativa)
    public List<Turma> listarTodas() {
        List<Turma> lista = new ArrayList<>();
        String sql = "SELECT * FROM turmas";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Turma turma = construirTurma(rs);
                lista.add(turma);
            }

            System.out.println("📋 Total de turmas encontradas: " + lista.size());

        } catch (SQLException e) {
            System.err.println("❌ Erro ao listar todas as turmas: " + e.getMessage());
        }

        return lista;
    }

    // Lista turmas vinculadas a um professor específico
    public List<Turma> listarPorProfessor(int professorId) {
        List<Turma> lista = new ArrayList<>();
        String sql = "SELECT * FROM turmas WHERE professor_id = ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, professorId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Turma turma = construirTurma(rs);
                lista.add(turma);
            }

            System.out.println("📚 Turmas encontradas para professor ID " + professorId + ": " + lista.size());

        } catch (SQLException e) {
            System.err.println("❌ Erro ao listar turmas do professor: " + e.getMessage());
        }

        return lista;
    }

    // Método utilitário para montar uma turma a partir de um ResultSet
    private Turma construirTurma(ResultSet rs) throws SQLException {
        Turma turma = new Turma();
        turma.setId(rs.getInt("id"));
        turma.setNome(rs.getString("nome"));
        turma.setSerie(rs.getString("serie"));
        turma.setTurno(rs.getString("turno"));
        turma.setAno(rs.getInt("ano"));

        Professor professor = new Professor();
        professor.setId(rs.getInt("professor_id"));
        turma.setProfessor(professor);

        return turma;
    }
}