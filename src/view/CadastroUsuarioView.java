package view;

import javax.swing.*;
import java.awt.*;

public class CadastroUsuarioView extends JFrame {
    private JTextField campoNome;
    private JTextField campoCpf;
    private JTextField campoEmail;
    private JTextField campoLogin;
    private JPasswordField campoSenha;
    private JComboBox<String> comboTipo;
    private JButton btnSalvar;
    private JButton btnVoltar;

    public CadastroUsuarioView() {
        setTitle("Cadastro de Usuário");
        setSize(400, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel painel = new JPanel(new GridLayout(7, 2, 10, 10));
        painel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        campoNome = new JTextField();
        campoCpf = new JTextField();
        campoEmail = new JTextField();
        campoLogin = new JTextField();
        campoSenha = new JPasswordField();

        comboTipo = new JComboBox<>(new String[]{"Professor", "Diretor", "Admin"});

        btnSalvar = new JButton("Salvar");
        btnVoltar = new JButton("Voltar");

        painel.add(new JLabel("Nome:"));
        painel.add(campoNome);

        painel.add(new JLabel("CPF:"));
        painel.add(campoCpf);

        painel.add(new JLabel("E-mail:"));
        painel.add(campoEmail);

        painel.add(new JLabel("Login:"));
        painel.add(campoLogin);

        painel.add(new JLabel("Senha:"));
        painel.add(campoSenha);

        painel.add(new JLabel("Tipo:"));
        painel.add(comboTipo);

        painel.add(btnVoltar);
        painel.add(btnSalvar);

        add(painel);
        setVisible(true);
    }

    public JTextField getCampoNome() { return campoNome; }
    public JTextField getCampoCpf() { return campoCpf; }
    public JTextField getCampoEmail() { return campoEmail; }
    public JTextField getCampoLogin() { return campoLogin; }
    public JPasswordField getCampoSenha() { return campoSenha; }
    public JComboBox<String> getComboTipo() { return comboTipo; }
    public JButton getBtnSalvar() { return btnSalvar; }
    public JButton getBtnVoltar() { return btnVoltar; }
}
