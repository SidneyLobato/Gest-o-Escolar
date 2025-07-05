package view;

import javax.swing.*;
import java.awt.*;

public class ProfessorView extends JFrame {
    private JButton btnAbrirTurma;
    private JButton btnMeuPerfil;
    private JButton btnVoltar;
    private JList<String> listaTurmas;

    public ProfessorView() {
        setTitle("Painel do Professor");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel titulo = new JLabel("Suas Turmas", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        mainPanel.add(titulo, BorderLayout.NORTH);

        listaTurmas = new JList<>();
        JScrollPane scrollPane = new JScrollPane(listaTurmas);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 5));
        btnAbrirTurma = new JButton("Abrir Turma");
        btnMeuPerfil = new JButton("Meu Perfil");
        btnVoltar = new JButton("Voltar");

        painelBotoes.add(btnAbrirTurma);
        painelBotoes.add(btnMeuPerfil);
        painelBotoes.add(btnVoltar);

        mainPanel.add(painelBotoes, BorderLayout.SOUTH);

        add(mainPanel);
    }

    public JButton getBtnAbrirTurma() { return btnAbrirTurma; }
    public JButton getBtnMeuPerfil() { return btnMeuPerfil; }
    public JButton getBtnVoltar() { return btnVoltar; }
    public JList<String> getListaTurmas() { return listaTurmas; }
    public void setListaTurmasModel(ListModel<String> model) { listaTurmas.setModel(model); }
}