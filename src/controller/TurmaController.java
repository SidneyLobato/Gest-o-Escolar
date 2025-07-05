package controller;

import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TurmaController {

    // Lista que mantém as turmas
    private static List<Turma> turmas = new ArrayList<>();

    // Método para criar uma turma e adicioná-la à lista
    public void criarTurma(String nome, Professor professor) {
        Turma turma = new Turma(nome, professor);
        turmas.add(turma);
    }

    // Método que retorna as turmas de um professor específico
    public List<Turma> getTurmasDoProfessor(Professor professor) {
        return turmas.stream()
                .filter(t -> t.getProfessor().equals(professor))
                .collect(Collectors.toList());
    }

    // Método que retorna uma turma pelo nome
    public Turma getTurmaPorNome(String nome) {
        for (Turma t : turmas) {
            if (t.getNome().equalsIgnoreCase(nome)) {
                return t;
            }
        }
        return null;
    }

    // Método para adicionar um aluno à turma
    public void adicionarAlunoNaTurma(String nomeTurma, Aluno aluno) {
        Turma turma = getTurmaPorNome(nomeTurma);
        if (turma != null) {
            turma.adicionarAluno(aluno);
        }
    }

    // Método para registrar a nota de um aluno em uma turma
    public void registrarNota(String nomeTurma, Aluno aluno, double valor) {
        Turma turma = getTurmaPorNome(nomeTurma);
        if (turma != null) {
            turma.registrarNota(aluno, valor);
        }
    }

    // Método para registrar a frequência de um aluno em uma turma
    public void registrarFrequencia(String nomeTurma, Aluno aluno, boolean presente) {
        Turma turma = getTurmaPorNome(nomeTurma);
        if (turma != null) {
            turma.registrarFrequencia(aluno, presente);
        }
    }

    // Método que retorna as notas de uma turma
    public List<Nota> getNotasPorTurma(String nomeTurma) {
        Turma turma = getTurmaPorNome(nomeTurma);
        return turma != null ? turma.getNotas() : new ArrayList<>();
    }

    // Método que retorna as frequências de uma turma
    public List<Frequencia> getFrequenciasPorTurma(String nomeTurma) {
        Turma turma = getTurmaPorNome(nomeTurma);
        return turma != null ? turma.getFrequencias() : new ArrayList<>();
    }

    // Método que retorna os alunos de uma turma
    public List<Aluno> getAlunosPorTurma(String nomeTurma) {
        Turma turma = getTurmaPorNome(nomeTurma);
        return turma != null ? turma.getAlunos() : new ArrayList<>();
    }

    // Método que retorna todas as turmas
    public List<Turma> getTodasAsTurmas() {
        return turmas;
    }
}
