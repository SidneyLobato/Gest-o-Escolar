package controller;

import model.Aluno;
import model.Turma;
import model.dao.AlunoDAO;
import model.dao.TurmaDAO;
import model.dao.MatriculaDAO;
import model.Matricula;
import view.MatriculaAlunoView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class MatriculaAlunoController {
    private MatriculaAlunoView view;
    private List<Aluno> alunos;
    private List<Turma> turmas;

    public MatriculaAlunoController() {
        AlunoDAO alunoDAO = new AlunoDAO();
        TurmaDAO turmaDAO = new TurmaDAO();

        alunos = alunoDAO.listarTodos();
        turmas = turmaDAO.listarTodas();

        List<String> nomesAlunos = alunos.stream().map(Aluno::getNome).collect(Collectors.toList());
        List<String> nomesTurmas = turmas.stream().map(Turma::getNome).collect(Collectors.toList());

        view = new MatriculaAlunoView(nomesAlunos, nomesTurmas);
        view.setVisible(true);

        view.getBtnMatricular().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                matricularAluno();
            }
        });

        view.getBtnVoltar().addActionListener(e -> view.dispose());
    }

    private void matricularAluno() {
        int alunoIndex = view.getListaAlunos().getSelectedIndex();
        int turmaIndex = view.getListaTurmas().getSelectedIndex();

        if (alunoIndex == -1 || turmaIndex == -1) {
            JOptionPane.showMessageDialog(view, "Selecione um aluno e uma turma.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Aluno aluno = alunos.get(alunoIndex);
        Turma turma = turmas.get(turmaIndex);

        Matricula matricula = new Matricula();
        matricula.setAluno(aluno);
        matricula.setTurma(turma);
        matricula.setDataMatricula(LocalDate.now());

        MatriculaDAO dao = new MatriculaDAO();
        dao.salvar(matricula);

        JOptionPane.showMessageDialog(view, "Aluno matriculado com sucesso!");
        view.dispose();
    }
}
