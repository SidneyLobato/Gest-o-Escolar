package controller;

import model.Usuario;
import util.CriptografiaUtil;

import java.util.ArrayList;
import java.util.List;

public class UsuarioController {
    private List<Usuario> usuarios;

    public UsuarioController() {
        usuarios = new ArrayList<>();
        carregarUsuariosFake(); // Substituir por banco de dados no futuro
    }

    // Método de login
    public Usuario login(String nomeUsuario, String senha) {
        for (Usuario u : usuarios) {
            if (u.getNome().equalsIgnoreCase(nomeUsuario) && u.verificarSenha(senha)) {
                return u;
            }
        }
        return null;
    }

    // Carregar dados fake
    private void carregarUsuariosFake() {
        Usuario admin = new Usuario() {
            @Override
            public String getTipo() {
                return "Admin";
            }
        };
        admin.setNome("admin");
        admin.setLogin("admin");
        admin.setSenha(CriptografiaUtil.hashSenha("123"));
        admin.setEmail("admin@email.com");
        admin.setCpf("00000000000");
        admin.setEndereco("Endereço admin");

        usuarios.add(admin);
    }

    // Adicionar usuário
    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    // Buscar usuários por tipo
    public List<Usuario> getUsuariosPorTipo(String tipo) {
        List<Usuario> resultado = new ArrayList<>();
        for (Usuario u : usuarios) {
            if (u.getTipo().equalsIgnoreCase(tipo)) {
                resultado.add(u);
            }
        }
        return resultado;
    }
}