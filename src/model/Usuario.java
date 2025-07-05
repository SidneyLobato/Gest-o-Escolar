package model;

import util.CriptografiaUtil;

public abstract class Usuario {
    protected int id;
    protected String nome;
    protected String cpf;
    protected String email;
    protected String login;
    protected String senha;
    protected String endereco;

    public abstract String getTipo();

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }

    public boolean verificarSenha(String senhaPura) {
        return this.senha.equals(CriptografiaUtil.hashSenha(senhaPura));
    }
}