package model;

public class Nota {
    private Aluno aluno;
    private Turma turma;
    private int bimestre;
    private double valor;

    public Aluno getAluno() { return aluno; }
    public void setAluno(Aluno aluno) { this.aluno = aluno; }

    public Turma getTurma() { return turma; }
    public void setTurma(Turma turma) { this.turma = turma; }

    public int getBimestre() { return bimestre; }
    public void setBimestre(int bimestre) { this.bimestre = bimestre; }

    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }
}