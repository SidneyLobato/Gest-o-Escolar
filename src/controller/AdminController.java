package controller;

import view.AdminView;

public class AdminController {
    private AdminView view;

    public AdminController(int adminId) {
        view = new AdminView();
        view.setVisible(true);

        view.getBtnCadastrarUsuario().addActionListener(e -> new CadastroUsuarioController());
        view.getBtnCadastrarProfessor().addActionListener(e -> new CadastroProfessorController());
        view.getBtnCadastrarTurma().addActionListener(e -> new CadastroTurmaController());
        view.getBtnMatricularAluno().addActionListener(e -> new MatriculaAlunoController());
        view.getBtnMeuPerfil().addActionListener(e -> new PerfilController("Admin", adminId));
        view.getBtnSair().addActionListener(e -> {
            view.dispose();
            new LoginController();
        });
    }
}