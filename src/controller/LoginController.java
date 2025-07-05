package controller;

import model.Usuario;
import model.dao.UsuarioDAO;
import util.CriptografiaUtil;
import view.LoginView;

import javax.swing.*;

public class LoginController {
    private LoginView view;

    public LoginController() {
        view = new LoginView();
        view.setVisible(true);

        view.getBtnEntrar().addActionListener(e -> autenticar());
    }

    private void autenticar() {
        String login = view.getCampoLogin().getText().trim();
        String senhaDigitada = new String(view.getCampoSenha().getPassword());

        if (login.isEmpty() || senhaDigitada.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Preencha login e senha.", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }

        UsuarioDAO dao = new UsuarioDAO();
        Usuario usuario = dao.buscarPorLogin(login);
        System.out.println("Login: " + login);
System.out.println("Senha digitada: " + senhaDigitada);
System.out.println("Hash gerado: " + CriptografiaUtil.hashSenha(senhaDigitada));
System.out.println("Hash do banco: " + (usuario != null ? usuario.getSenha() : "Usuário não encontrado"));
        if (usuario != null && usuario.verificarSenha(senhaDigitada)) {
            JOptionPane.showMessageDialog(view, "Login realizado com sucesso!");
            view.dispose();

            switch (usuario.getTipo()) {
                case "Admin", "Diretor" -> new DiretorController(usuario.getId(), usuario.getTipo());
                case "Professor" -> new ProfessorController((model.Professor) usuario);
                default -> JOptionPane.showMessageDialog(null, "Tipo de usuário não reconhecido.");
            }

        } else {
            JOptionPane.showMessageDialog(view, "Login ou senha inválidos.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}