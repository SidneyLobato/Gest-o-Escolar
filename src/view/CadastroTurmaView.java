package view;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CadastroTurmaView extends JFrame {
    private JTextField campoNome;
    private JTextField campoSerie;
    private JComboBox<String> comboTurno;
    private JTextField campoAno;
    private JComboBox<String> comboProfessores;
    private JButton btnSalvar;
    private JButton btnVoltar;

    public CadastroTurmaView(List<String> nomesProfessores) {
        setTitle("Cadastro de Turma");
        setSize(400, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(7, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        campoNome = new JTextField();
        campoSerie = new JTextField();
        comboTurno = new JComboBox<>(new String[] { "Manhã", "Tarde", "Noite" });
        campoAno = new JTextField();
        comboProfessores = new JComboBox<>(nomesProfessores.toArray(new String[0]));

        btnSalvar = new JButton("Salvar");
        btnVoltar = new JButton("Voltar");

        panel.add(new JLabel("Nome da Turma:"));
        panel.add(campoNome);
        panel.add(new JLabel("Série:"));
        panel.add(campoSerie);
        panel.add(new JLabel("Turno:"));
        panel.add(comboTurno);
        panel.add(new JLabel("Ano:"));
        panel.add(campoAno);
        panel.add(new JLabel("Professor Responsável:"));
        panel.add(comboProfessores);
        panel.add(btnSalvar);
        panel.add(btnVoltar);

        add(panel);
    }

    public JTextField getCampoNome() {
        return campoNome;
    }

    public JTextField getCampoSerie() {
        return campoSerie;
    }

    public JComboBox<String> getComboTurno() {
        return comboTurno;
    }

    public JTextField getCampoAno() {
        return campoAno;
    }

    public JComboBox<String> getComboProfessores() {
        return comboProfessores;
    }

    public JButton getBtnSalvar() {
        return btnSalvar;
    }

    public JButton getBtnVoltar() {
        return btnVoltar;
    }
}
