package controller;

import model.Aluno;
import model.dao.AlunoDAO;
import view.CadastroAlunoView;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class CadastroAlunoController {
    private CadastroAlunoView view;

    public CadastroAlunoController() {
        view = new CadastroAlunoView();
        view.setVisible(true);

        view.getBtnSalvar().addActionListener(e -> salvarAluno());
        view.getBtnCancelar().addActionListener(e -> view.dispose());
    }

    private void salvarAluno() {
        String nome = view.getCampoNome().getText();
        String cpf = view.getCampoCpf().getText();
        String nascimentoStr = view.getCampoNascimento().getText();

        if (nome.isEmpty() || cpf.isEmpty() || nascimentoStr.isEmpty()) {
            view.mostrarMensagem("⚠️ Preencha todos os campos!", false);
            return;
        }

        try {
            LocalDate dataNascimento = LocalDate.parse(nascimentoStr);

            Aluno aluno = new Aluno();
            aluno.setNome(nome);
            aluno.setCpf(cpf);
            aluno.setDataNascimento(dataNascimento);

            boolean sucesso = new AlunoDAO().salvar(aluno);

            if (sucesso) {
                view.mostrarMensagem("✅ Aluno cadastrado com sucesso!", true);
                view.dispose();
            } else {
                view.mostrarMensagem("❌ Erro ao cadastrar. Verifique o console.", false);
            }

        } catch (DateTimeParseException ex) {
            view.mostrarMensagem("❌ Data inválida! Use o formato aaaa-MM-dd.", false);
        }
    }
}