package controller;

import model.Aluno;
import model.Turma;
import model.dao.AlunoDAO;
import view.PrimeiroP;
import view.NotaView;
import view.TurmaDetalheView;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TurmaDetalheController {
    private TurmaDetalheView view;
    private Turma turma;

    public TurmaDetalheController(Turma turma) {
        this.turma = turma;
        this.view = new TurmaDetalheView(turma.getNome());

        carregarListaDeAlunos();
        configurarAcoesDosBotoes();

        view.revalidate();
        view.repaint();
        view.setVisible(true);
    }

    private void carregarListaDeAlunos() {
        AlunoDAO dao = new AlunoDAO();
        List<Aluno> alunos = dao.listarPorTurma(turma.getId());

        String[] nomes = alunos.stream()
                .map(Aluno::getNome)
                .toArray(String[]::new);

        JList<String> lista = new JList<>(nomes);
        JScrollPane scroll = new JScrollPane(lista);
        view.getContentPane().add(scroll, BorderLayout.CENTER);
    }

    private void configurarAcoesDosBotoes() {
        for (Component comp : view.getContentPane().getComponents()) {
            if (comp instanceof JPanel panel) {
                for (Component b : panel.getComponents()) {
                    if (b instanceof JButton btn) {
                        switch (btn.getText()) {
                            case "Lançar Nota" -> btn.addActionListener(e -> lancarNota());
                            case "Lançar Frequência" -> btn.addActionListener(e -> lancarFrequencia());
                            case "Voltar" -> btn.addActionListener(e -> view.dispose());
                        }
                    }
                }
            }
        }
    }

    private void lancarNota() {
        view.dispose(); // Fecha a tela atual
        new NotaView(turma.getId()); // Abre a tela de notas para a turma
    }

    private void lancarFrequencia() {
        view.dispose(); // Fecha a tela atual
        new PrimeiroP(turma.getId()); // Abre a tela de frequência
    }
}