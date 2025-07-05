package controller;

import view.DiretorView;

public class DiretorController {
    private DiretorView view;
    private int usuarioId;
    private String tipoUsuario;

    public DiretorController(int usuarioId, String tipoUsuario) {
        this.usuarioId = usuarioId;
        this.tipoUsuario = tipoUsuario;
        this.view = new DiretorView(tipoUsuario);
        view.setVisible(true);

        // Ações
        if (tipoUsuario.equals("Admin")) {
            view.getBtnCadastrarUsuario().addActionListener(e -> new CadastroUsuarioController());
        }

        view.getBtnCadastrarProfessor().addActionListener(e -> new CadastroProfessorController());
        view.getBtnCadastrarTurma().addActionListener(e -> new CadastroTurmaController());
        view.getBtnMatricularAluno().addActionListener(e -> new MatriculaAlunoController());
        view.getBtnMeuPerfil().addActionListener(e -> new PerfilController(tipoUsuario, usuarioId));
        view.getBtnCadastrarAluno().addActionListener(e -> new CadastroAlunoController()); // Aqui está o novo botão!
        view.getBtnVoltar().addActionListener(e -> {
            view.dispose();
            new LoginController();
        });
    }
}