package model.dao;

import model.*;
import util.CriptografiaUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    public Usuario buscarPorLogin(String login) {
        String sql = "SELECT * FROM usuarios WHERE login = ?";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, login);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String tipo = rs.getString("tipo");
                Usuario usuario = switch (tipo) {
                    case "Admin" -> new Admin();
                    case "Professor" -> new Professor();
                    case "Diretor" -> new Diretor();
                    default -> null;
                };
                if (usuario == null) return null;

                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setCpf(rs.getString("cpf"));
                usuario.setEmail(rs.getString("email"));
                usuario.setLogin(rs.getString("login"));
                usuario.setSenha(rs.getString("senha"));
         //       usuario.setEndereco(rs.getString("endereco"));
                return usuario;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void salvar(Usuario usuario) {
        String sql = "INSERT INTO usuarios (login, senha, tipo, nome, email, cpf, endereco) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            String senhaHash = CriptografiaUtil.hashSenha(usuario.getSenha());

            stmt.setString(1, usuario.getLogin());
            stmt.setString(2, senhaHash);
            stmt.setString(3, usuario.getTipo());
            stmt.setString(4, usuario.getNome());
            stmt.setString(5, usuario.getEmail());
            stmt.setString(6, usuario.getCpf());
            stmt.setString(7, usuario.getEndereco());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizarLoginESenha(int id, String novoLogin, String senhaCriptografada) {
        String sql = "UPDATE usuarios SET login = ?, senha = ? WHERE id = ?";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, novoLogin);
            stmt.setString(2, senhaCriptografada);
            stmt.setInt(3, id);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Professor> listarProfessores() {
        List<Professor> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuarios WHERE tipo = 'Professor'";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Professor p = new Professor();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setCpf(rs.getString("cpf"));
                p.setEmail(rs.getString("email"));
                p.setLogin(rs.getString("login"));
                p.setSenha(rs.getString("senha"));
                p.setEndereco(rs.getString("endereco"));
                lista.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}