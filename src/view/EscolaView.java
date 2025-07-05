package view;

import javax.swing.*;
import java.awt.*;

public class EscolaView extends JFrame {
    private JButton btnGerenciarTurmas;
    private JButton btnGerenciarProfessores;
    private JButton btnMeuPerfil;
    private JButton btnSair;

    public EscolaView(String nomeDiretor) {
        setTitle("Painel da Escola");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(5, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel label = new JLabel("Bem-vindo, " + nomeDiretor + "!", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(label);

        btnGerenciarTurmas = new JButton("Gerenciar Turmas");
        btnGerenciarProfessores = new JButton("Gerenciar Professores");
        btnMeuPerfil = new JButton("Meu Perfil");
        btnSair = new JButton("Sair");

        panel.add(btnGerenciarTurmas);
        panel.add(btnGerenciarProfessores);
        panel.add(btnMeuPerfil);
        panel.add(btnSair);

        add(panel);
    }

    public JButton getBtnGerenciarTurmas() {
        return btnGerenciarTurmas;
    }

    public JButton getBtnGerenciarProfessores() {
        return btnGerenciarProfessores;
    }

    public JButton getBtnMeuPerfil() {
        return btnMeuPerfil;
    }

    public JButton getBtnSair() {
        return btnSair;
    }
}