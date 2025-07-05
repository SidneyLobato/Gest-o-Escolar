package controller;

import model.Usuario;
import model.dao.UsuarioDAO;
import util.CriptografiaUtil;
import view.CadastroUsuarioView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroUsuarioController {
    private CadastroUsuarioView view;

    public CadastroUsuarioController() {
        view = new CadastroUsuarioView();
        adicionarAcoes();
    }

    private void adicionarAcoes() {
        view.getBtnSalvar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvarUsuario();
            }
        });

        view.getBtnVoltar().addActionListener(e -> view.dispose());
    }

    private void salvarUsuario() {
        String nome = view.getCampoNome().getText().trim();
        String cpf = view.getCampoCpf().getText().trim();
        String email = view.getCampoEmail().getText().trim();
        String login = view.getCampoLogin().getText().trim();
        String senha = new String(view.getCampoSenha().getPassword());
        String tipo = (String) view.getComboTipo().getSelectedItem();

        if (nome.isEmpty() || cpf.isEmpty() || email.isEmpty() || login.isEmpty() || senha.isEmpty() || tipo == null) {
            JOptionPane.showMessageDialog(view, "Preencha todos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Usuario usuario = new Usuario() {
            @Override
            public String getTipo() {
                return tipo;
            }
        };

        usuario.setNome(nome);
        usuario.setCpf(cpf);
        usuario.setEmail(email);
        usuario.setLogin(login);
        usuario.setSenha(senha); // será criptografada no DAO

        UsuarioDAO dao = new UsuarioDAO();
        dao.salvar(usuario);

        JOptionPane.showMessageDialog(view, tipo + " cadastrado com sucesso!");
        view.dispose();
    }
}
