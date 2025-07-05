package view;

import javax.swing.*;
import java.awt.*;

public class CadastroProfessorView extends JFrame {
    private JTextField campoNome;
    private JTextField campoCpf;
    private JTextField campoEmail;
    private JTextField campoLogin;
    private JPasswordField campoSenha;
    private JButton btnSalvar;
    private JButton btnVoltar;

    public CadastroProfessorView() {
        setTitle("Cadastro de Professor");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        campoNome = new JTextField();
        campoCpf = new JTextField();
        campoEmail = new JTextField();
        campoLogin = new JTextField();
        campoSenha = new JPasswordField();

        btnSalvar = new JButton("Salvar");
        btnVoltar = new JButton("Voltar");

        panel.add(new JLabel("Nome:"));
        panel.add(campoNome);

        panel.add(new JLabel("CPF:"));
        panel.add(campoCpf);

        panel.add(new JLabel("E-mail:"));
        panel.add(campoEmail);

        panel.add(new JLabel("Login:"));
        panel.add(campoLogin);

        panel.add(new JLabel("Senha:"));
        panel.add(campoSenha);

        panel.add(btnSalvar);
        panel.add(btnVoltar);

        add(panel);
    }

    // Getters para o controlador
    public JTextField getCampoNome() { return campoNome; }
    public JTextField getCampoCpf() { return campoCpf; }
    public JTextField getCampoEmail() { return campoEmail; }
    public JTextField getCampoLogin() { return campoLogin; }
    public JPasswordField getCampoSenha() { return campoSenha; }
    public JButton getBtnSalvar() { return btnSalvar; }
    public JButton getBtnVoltar() { return btnVoltar; }
}
