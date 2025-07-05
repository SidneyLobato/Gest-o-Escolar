package controller;

import model.Professor;
import model.Turma;
import model.dao.TurmaDAO;
import view.ProfessorView;
import view.TurmaDetalheView;

import javax.swing.*;
import java.util.List;

public class ProfessorController {
    private ProfessorView view;
    private Professor professor;
    private List<Turma> turmasDoProfessor;

    public ProfessorController(Professor professor) {
        this.professor = professor;
        this.view = new ProfessorView();

        if (professor.getId() <= 0) {
            JOptionPane.showMessageDialog(null,
                    "ID do professor inválido. Impossível carregar turmas.",
                    "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        carregarTurmasDoProfessor();

        view.getBtnAbrirTurma().addActionListener(e -> abrirTurmaSelecionada());
        view.getBtnMeuPerfil().addActionListener(e ->
                new PerfilController(professor.getNome(), professor.getId()));
        view.getBtnVoltar().addActionListener(e -> {
            view.dispose();
            new LoginController();
        });

        view.setVisible(true);
    }

    private void carregarTurmasDoProfessor() {
        System.out.println("🔍 Buscando turmas do professor ID: " + professor.getId());

        TurmaDAO dao = new TurmaDAO();
        turmasDoProfessor = dao.listarPorProfessor(professor.getId());

        DefaultListModel<String> model = new DefaultListModel<>();
        for (Turma t : turmasDoProfessor) {
            System.out.println("✅ Turma carregada: " + t.getNome());
            model.addElement(t.getNome());
        }

        if (model.isEmpty()) {
            System.out.println("⚠️ Nenhuma turma encontrada.");
            model.addElement("Nenhuma turma cadastrada.");
            view.getBtnAbrirTurma().setEnabled(false);
        } else {
            view.getBtnAbrirTurma().setEnabled(true);
        }

        view.setListaTurmasModel(model);
    }

    private void abrirTurmaSelecionada() {
        int index = view.getListaTurmas().getSelectedIndex();

        if (index == -1 || turmasDoProfessor.isEmpty()) {
            JOptionPane.showMessageDialog(view,
                    "Selecione uma turma válida para abrir.",
                    "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Turma turmaSelecionada = turmasDoProfessor.get(index);
        new TurmaDetalheController(turmaSelecionada);
    }
}