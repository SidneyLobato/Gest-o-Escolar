package view;

import javax.swing.*;
import java.awt.*;

public class PerfilView extends JFrame {
    private JTextField campoLogin;
    private JPasswordField campoSenha;
    private JButton btnSalvar;
    private JButton btnVoltar;

    public PerfilView(String nomeUsuario) {
        setTitle("Perfil de " + nomeUsuario);
        setSize(400, 250);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); // Melhor que EXIT_ON_CLOSE para janelas internas
        setLocationRelativeTo(null);

        // Painel principal com bordas e layout elegante
        JPanel painelPrincipal = new JPanel(new BorderLayout(10, 10));
        painelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Título centralizado
        JLabel titulo = new JLabel("Perfil do Usuário", SwingConstants.CENTER);
        titulo.setFont(titulo.getFont().deriveFont(Font.BOLD, 16));
        painelPrincipal.add(titulo, BorderLayout.NORTH);

        // Painel central com campos
        JPanel painelCampos = new JPanel(new GridLayout(2, 2, 10, 10));
        painelCampos.add(new JLabel("Login:"));
        campoLogin = new JTextField();
        painelCampos.add(campoLogin);

        painelCampos.add(new JLabel("Nova Senha:"));
        campoSenha = new JPasswordField();
        painelCampos.add(campoSenha);
        painelPrincipal.add(painelCampos, BorderLayout.CENTER);

        // Painel de botões
        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 0));
        btnSalvar = new JButton("Salvar");
        btnVoltar = new JButton("Voltar");
        painelBotoes.add(btnSalvar);
        painelBotoes.add(btnVoltar);
        painelPrincipal.add(painelBotoes, BorderLayout.SOUTH);

        // Adiciona tudo à janela
        add(painelPrincipal);
    }

    // Getters
    public JTextField getCampoLogin() { return campoLogin; }
    public JPasswordField getCampoSenha() { return campoSenha; }
    public JButton getBtnSalvar() { return btnSalvar; }
    public JButton getBtnVoltar() { return btnVoltar; }
}