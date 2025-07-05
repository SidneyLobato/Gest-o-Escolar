package controller;

import model.Diretor;
import view.EscolaView;

public class EscolaController {
    private EscolaView view;
    private Diretor diretor;

    public EscolaController(Diretor diretor) {
        this.diretor = diretor;
        view = new EscolaView(diretor.getNome());
        view.setVisible(true);

        view.getBtnGerenciarTurmas().addActionListener(e -> new CadastroTurmaController());
        view.getBtnGerenciarProfessores().addActionListener(e -> new CadastroProfessorController());
        view.getBtnMeuPerfil().addActionListener(e ->
            new PerfilController(diretor.getNome(), diretor.getId())
        );

        view.getBtnSair().addActionListener(e -> {
            view.dispose();
            new LoginController();
        });
    }
}