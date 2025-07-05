package model;

import java.util.ArrayList;
import java.util.List;

public class Turma {
    private int id;
    private String nome;
    private String serie;
    private String turno;
    private int ano;
    private Professor professor;
    private List<Aluno> alunos = new ArrayList<>();
    private List<Nota> notas = new ArrayList<>();
    private List<Frequencia> frequencias = new ArrayList<>();

    public Turma() {}

    public Turma(String nome, Professor professor) {
        this.nome = nome;
        this.professor = professor;
    }

    // Getters e Setters...
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getSerie() { return serie; }
    public void setSerie(String serie) { this.serie = serie; }

    public String getTurno() { return turno; }
    public void setTurno(String turno) { this.turno = turno; }

    public int getAno() { return ano; }
    public void setAno(int ano) { this.ano = ano; }

    public Professor getProfessor() { return professor; }
    public void setProfessor(Professor professor) { this.professor = professor; }

    public List<Aluno> getAlunos() { return alunos; }
    public void setAlunos(List<Aluno> alunos) { this.alunos = alunos; }

    public List<Frequencia> getFrequencias() { return frequencias; }
    public List<Nota> getNotas() { return notas; }

    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public void registrarFrequencia(Aluno aluno, boolean presente) {
        Frequencia f = new Frequencia();
        f.setAluno(aluno);
        f.setTurma(this);
        f.setData(java.time.LocalDate.now());
        f.setPresente(presente);
        frequencias.add(f);
    }

    public void registrarNota(Aluno aluno, double valor) {
        Nota n = new Nota();
        n.setAluno(aluno);
        n.setTurma(this);
        n.setBimestre(1); // Default por enquanto
        n.setValor(valor);
        notas.add(n);
    }
}