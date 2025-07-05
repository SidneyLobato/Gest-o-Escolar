package view;

import javax.swing.*;
import java.awt.*;

public class LoginView extends JFrame {
    private JTextField campoLogin;
    private JPasswordField campoSenha;
    private JButton btnEntrar;

    public LoginView() {
        setTitle("Login");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        campoLogin = new JTextField(15);
        campoSenha = new JPasswordField(15);
        btnEntrar = new JButton("Entrar");

        JPanel painel = new JPanel(new GridLayout(3, 2, 10, 10));
        painel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        painel.add(new JLabel("Login:"));
        painel.add(campoLogin);

        painel.add(new JLabel("Senha:"));
        painel.add(campoSenha);

        painel.add(new JLabel());
        painel.add(btnEntrar);

        add(painel);
        setVisible(true);
    }

    // ✅ Getters necessários para o LoginController funcionar

    public JButton getBtnEntrar() {
        return btnEntrar;
    }

    public JTextField getCampoLogin() {
        return campoLogin;
    }

    public JPasswordField getCampoSenha() {
        return campoSenha;
    }
}
