package controller;

import model.Professor;
import model.Turma;
import model.dao.TurmaDAO;
import model.dao.UsuarioDAO;
import view.CadastroTurmaView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.stream.Collectors;

public class CadastroTurmaController {
    private CadastroTurmaView view;
    private List<Professor> professores;

    public CadastroTurmaController() {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        professores = usuarioDAO.listarProfessores(); // agora retorna List<Professor>

        List<String> nomes = professores.stream()
                .map(Professor::getNome)
                .collect(Collectors.toList());

        view = new CadastroTurmaView(nomes);
        view.setVisible(true);

        view.getBtnSalvar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvarTurma();
            }
        });

        view.getBtnVoltar().addActionListener(e -> view.dispose());
    }

    private void salvarTurma() {
        String nome = view.getCampoNome().getText().trim();
        String serie = view.getCampoSerie().getText().trim();
        String turno = (String) view.getComboTurno().getSelectedItem();
        String anoStr = view.getCampoAno().getText().trim();
        int indexProfessor = view.getComboProfessores().getSelectedIndex();

        if (nome.isEmpty() || serie.isEmpty() || turno == null || anoStr.isEmpty() || indexProfessor < 0) {
            JOptionPane.showMessageDialog(view, "Preencha todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int ano = Integer.parseInt(anoStr);
            Professor professor = professores.get(indexProfessor);

            Turma turma = new Turma();
            turma.setNome(nome);
            turma.setSerie(serie);
            turma.setTurno(turno);
            turma.setAno(ano);
            turma.setProfessor(professor);

            TurmaDAO dao = new TurmaDAO();
            dao.salvar(turma);

            JOptionPane.showMessageDialog(view, "Turma cadastrada com sucesso!");
            view.dispose();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(view, "Ano inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
