package controller;

import model.Professor;
import model.dao.UsuarioDAO;
import util.CriptografiaUtil;
import view.CadastroProfessorView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroProfessorController {
    private CadastroProfessorView view;

    public CadastroProfessorController() {
        view = new CadastroProfessorView();
        view.setVisible(true);

        // Ação para salvar o professor
        view.getBtnSalvar().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                salvarProfessor();
            }
        });

        // Ação para voltar
        view.getBtnVoltar().addActionListener(e -> view.dispose());
    }

    private void salvarProfessor() {
        // Captura os dados inseridos no formulário
        String nome = view.getCampoNome().getText().trim();
        String cpf = view.getCampoCpf().getText().trim();
        String email = view.getCampoEmail().getText().trim();
        String login = view.getCampoLogin().getText().trim();
        String senha = new String(view.getCampoSenha().getPassword()).trim();

        // Validação dos campos
        if (nome.isEmpty() || cpf.isEmpty() || email.isEmpty() || login.isEmpty() || senha.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Preencha todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Criptografando a senha
        String senhaCriptografada = CriptografiaUtil.hashSenha(senha);

        // Criando o objeto Professor e configurando os dados
        Professor professor = new Professor();
        professor.setNome(nome);
        professor.setCpf(cpf);
        professor.setEmail(email);
        professor.setLogin(login);
        professor.setSenha(senhaCriptografada); // Senha criptografada

        // Salvando no banco de dados
        UsuarioDAO dao = new UsuarioDAO();
        dao.salvar(professor);

        // Mensagem de sucesso
        JOptionPane.showMessageDialog(view, "Professor cadastrado com sucesso!");
        view.dispose();
    }
}
