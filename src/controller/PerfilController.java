package controller;

import model.dao.UsuarioDAO;
import util.CriptografiaUtil;
import view.PerfilView;

import javax.swing.*;

public class PerfilController {
    private PerfilView view;
    private int usuarioId;

    public PerfilController(String nomeUsuario, int usuarioId) {
        this.usuarioId = usuarioId;
        this.view = new PerfilView(nomeUsuario);

        // ➕ Associando ações diretamente via getters
        view.getBtnSalvar().addActionListener(e -> salvarPerfil());
        view.getBtnVoltar().addActionListener(e -> view.dispose());

        view.setVisible(true);
    }

    private void salvarPerfil() {
        try {
            String novoLogin = view.getCampoLogin().getText().trim();
            String novaSenha = new String(view.getCampoSenha().getPassword()).trim();

            if (novoLogin.isBlank() || novaSenha.isBlank()) {
                JOptionPane.showMessageDialog(view,
                        "⚠️ Preencha todos os campos.",
                        "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // 🔐 Criptografando a senha
            String senhaCriptografada = CriptografiaUtil.hashSenha(novaSenha);

            // 💾 Atualizando no banco
            UsuarioDAO dao = new UsuarioDAO();
            dao.atualizarLoginESenha(usuarioId, novoLogin, senhaCriptografada);

            JOptionPane.showMessageDialog(view,
                    "✅ Dados atualizados com sucesso!",
                    "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            view.dispose();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(view,
                    "❌ Erro ao atualizar os dados.",
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}