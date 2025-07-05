package view;

import javax.swing.*;
import java.awt.*;

public class TurmaDetalheView extends JFrame {
    private JPanel panelAlunos;
    private JButton btnLancarNota;
    private JButton btnLancarFrequencia;
    private JButton btnVoltar;

    public TurmaDetalheView(String nomeTurma) {
        setTitle("Turma: " + nomeTurma);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        setLayout(new BorderLayout());

        JLabel titulo = new JLabel("Detalhes da Turma - " + nomeTurma, SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        add(titulo, BorderLayout.NORTH);

        panelAlunos = new JPanel();
        panelAlunos.setLayout(new BoxLayout(panelAlunos, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(panelAlunos);
        add(scrollPane, BorderLayout.CENTER);

        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnLancarNota = new JButton("Lançar Nota");
        btnLancarFrequencia = new JButton("Lançar Frequência");
        btnVoltar = new JButton("Voltar");

        painelBotoes.add(btnLancarNota);
        painelBotoes.add(btnLancarFrequencia);
        painelBotoes.add(btnVoltar);
        add(painelBotoes, BorderLayout.SOUTH);
    }

    public JPanel getPanelAlunos() {
        return panelAlunos;
    }

    public JButton getBtnLancarNota() {
        return btnLancarNota;
    }

    public JButton getBtnLancarFrequencia() {
        return btnLancarFrequencia;
    }

    public JButton getBtnVoltar() {
        return btnVoltar;
    }
}