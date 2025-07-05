package view;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MatriculaAlunoView extends JFrame {
    private JList<String> listaAlunos;
    private JList<String> listaTurmas;
    private JButton btnMatricular;
    private JButton btnVoltar;

    public MatriculaAlunoView(List<String> nomesAlunos, List<String> nomesTurmas) {
        setTitle("Matrícula de Aluno");
        setSize(450, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        listaAlunos = new JList<>(nomesAlunos.toArray(new String[0]));
        listaTurmas = new JList<>(nomesTurmas.toArray(new String[0]));
        listaAlunos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaTurmas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        btnMatricular = new JButton("Matricular");
        btnVoltar = new JButton("Voltar");

        JPanel centerPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        centerPanel.add(new JLabel("Alunos:"));
        centerPanel.add(new JScrollPane(listaAlunos));
        centerPanel.add(new JLabel("Turmas:"));
        centerPanel.add(new JScrollPane(listaTurmas));

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnMatricular);
        buttonPanel.add(btnVoltar);

        panel.add(centerPanel, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        add(panel);
    }

    public JList<String> getListaAlunos() { return listaAlunos; }
    public JList<String> getListaTurmas() { return listaTurmas; }
    public JButton getBtnMatricular() { return btnMatricular; }
    public JButton getBtnVoltar() { return btnVoltar; }
}