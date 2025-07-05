package view;

import javax.swing.*;
import java.awt.*;

public class AdminView extends JFrame {
    private JButton btnCadastrarUsuario;
    private JButton btnCadastrarProfessor;
    private JButton btnCadastrarTurma;
    private JButton btnMatricularAluno;
    private JButton btnMeuPerfil;
    private JButton btnSair;

    public AdminView() {
        setTitle("Painel do Administrador");
        setSize(400, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel titulo = new JLabel("Bem-vindo, Administrador!", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 16));

        btnCadastrarUsuario = new JButton("Cadastrar Usuário");
        btnCadastrarProfessor = new JButton("Cadastrar Professor");
        btnCadastrarTurma = new JButton("Cadastrar Turma");
        btnMatricularAluno = new JButton("Matricular Aluno");
        btnMeuPerfil = new JButton("Meu Perfil");
        btnSair = new JButton("Sair");

        panel.add(titulo);
        panel.add(btnCadastrarUsuario);
        panel.add(btnCadastrarProfessor);
        panel.add(btnCadastrarTurma);
        panel.add(btnMatricularAluno);
        panel.add(btnMeuPerfil);
        panel.add(btnSair);

        add(panel);
    }

    public JButton getBtnCadastrarUsuario() { return btnCadastrarUsuario; }
    public JButton getBtnCadastrarProfessor() { return btnCadastrarProfessor; }
    public JButton getBtnCadastrarTurma() { return btnCadastrarTurma; }
    public JButton getBtnMatricularAluno() { return btnMatricularAluno; }
    public JButton getBtnMeuPerfil() { return btnMeuPerfil; }
    public JButton getBtnSair() { return btnSair; }
}