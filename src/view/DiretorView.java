package view;

import javax.swing.*;
import java.awt.*;

public class DiretorView extends JFrame {
    private JButton btnCadastrarUsuario;
    private JButton btnCadastrarProfessor;
    private JButton btnCadastrarTurma;
    private JButton btnCadastrarAluno;      // <-- Novo botão
    private JButton btnMatricularAluno;
    private JButton btnMeuPerfil;
    private JButton btnVoltar;

    public DiretorView(String tipoUsuario) {
        setTitle("Painel do " + tipoUsuario);
        setSize(400, 400); // aumentei um pouco o tamanho
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 1, 10, 10)); // agora são 8 botões no total
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel titulo = new JLabel("Bem-vindo, " + tipoUsuario + "!", SwingConstants.CENTER);

        btnCadastrarUsuario = new JButton("Cadastrar Usuário");
        btnCadastrarProfessor = new JButton("Cadastrar Professor");
        btnCadastrarTurma = new JButton("Cadastrar Turma");
        btnCadastrarAluno = new JButton("Cadastrar Aluno"); // criado aqui
        btnMatricularAluno = new JButton("Matricular Aluno");
        btnMeuPerfil = new JButton("Meu Perfil");
        btnVoltar = new JButton("Voltar");

        panel.add(titulo);
        if (tipoUsuario.equals("Admin")) {
            panel.add(btnCadastrarUsuario);
        }
        panel.add(btnCadastrarProfessor);
        panel.add(btnCadastrarTurma);
        panel.add(btnCadastrarAluno);       // adicionado ao painel
        panel.add(btnMatricularAluno);
        panel.add(btnMeuPerfil);
        panel.add(btnVoltar);

        add(panel);
    }

    // Getters
    public JButton getBtnCadastrarUsuario() { return btnCadastrarUsuario; }
    public JButton getBtnCadastrarProfessor() { return btnCadastrarProfessor; }
    public JButton getBtnCadastrarTurma() { return btnCadastrarTurma; }
    public JButton getBtnCadastrarAluno() { return btnCadastrarAluno; } // getter novo
    public JButton getBtnMatricularAluno() { return btnMatricularAluno; }
    public JButton getBtnMeuPerfil() { return btnMeuPerfil; }
    public JButton getBtnVoltar() { return btnVoltar; }
}