package model.dao;

import model.Aluno;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {

    // Salva um novo aluno no banco
    public boolean salvar(Aluno aluno) {
        String sql = "INSERT INTO alunos (nome, cpf, data_nascimento) VALUES (?, ?, ?)";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getCpf());
            stmt.setDate(3, Date.valueOf(aluno.getDataNascimento()));
            stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            System.err.println("Erro ao salvar aluno: " + e.getMessage());
            return false;
        }
    }

    // Lista alunos de uma turma específica
    public List<Aluno> listarPorTurma(int turmaId) {
        List<Aluno> alunos = new ArrayList<>();
        String sql = """
                SELECT a.*
                FROM alunos a
                JOIN matriculas m ON a.id = m.aluno_id
                WHERE m.turma_id = ?
                """;

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, turmaId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Aluno aluno = new Aluno();
                aluno.setId(rs.getInt("id"));
                aluno.setNome(rs.getString("nome"));
                aluno.setCpf(rs.getString("cpf"));
                aluno.setDataNascimento(rs.getDate("data_nascimento").toLocalDate());
                alunos.add(aluno);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar alunos por turma: " + e.getMessage());
        }

        return alunos;
    }

    // Lista todos os alunos (para matrícula ou visualização)
    public List<Aluno> listarTodos() {
        List<Aluno> lista = new ArrayList<>();
        String sql = "SELECT * FROM alunos";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Aluno aluno = new Aluno();
                aluno.setId(rs.getInt("id"));
                aluno.setNome(rs.getString("nome"));
                aluno.setCpf(rs.getString("cpf"));
                aluno.setDataNascimento(rs.getDate("data_nascimento").toLocalDate());
                lista.add(aluno);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar todos os alunos: " + e.getMessage());
        }

        return lista;
    }
}