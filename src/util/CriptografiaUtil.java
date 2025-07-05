package util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CriptografiaUtil {

    /**
     * Gera o hash SHA-256 de uma senha em texto.
     *
     * @param senha A senha original digitada pelo usuário.
     * @return O hash hexadecimal SHA-256 em letras minúsculas.
     */
    public static String hashSenha(String senha) {
        if (senha == null) {
            throw new IllegalArgumentException("Senha não pode ser nula");
        }

        try {
            // Remove espaços invisíveis
            senha = senha.trim();

            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(senha.getBytes(StandardCharsets.UTF_8));

            // Converte o hash para string hexadecimal
            StringBuilder sb = new StringBuilder();
            for (byte b : hash) {
                sb.append(String.format("%02x", b));
            }

            return sb.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Erro ao gerar hash da senha", e);
        }
    }

    // Método de teste
    public static void main(String[] args) {
        String senha = "123";
        String hash = hashSenha(senha);
        System.out.println("Senha original : " + senha);
        System.out.println("Hash SHA-256   : " + hash);
        System.out.println("Tamanho do hash: " + hash.length()); // deve ser 64
    }
}