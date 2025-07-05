package view;

import javax.swing.*;
import java.awt.*;

public class CadastroAlunoView extends JFrame {
    private JTextField campoNome;
    private JTextField campoCpf;
    private JTextField campoNascimento;
    private JButton btnSalvar;
    private JButton btnCancelar;

    public CadastroAlunoView() {
        setTitle("Cadastro de Aluno");
        setSize(400, 280);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel painel = new JPanel(new GridLayout(4, 2, 10, 10));
        painel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        campoNome = new JTextField();
        campoCpf = new JTextField();
        campoNascimento = new JTextField(); // formato: yyyy-MM-dd
        btnSalvar = new JButton("Salvar");
        btnCancelar = new JButton("Cancelar");

        painel.add(new JLabel("Nome:"));
        painel.add(campoNome);
        painel.add(new JLabel("CPF:"));
        painel.add(campoCpf);
        painel.add(new JLabel("Data de Nascimento (aaaa-MM-dd):"));
        painel.add(campoNascimento);
        painel.add(btnSalvar);
        painel.add(btnCancelar);

        add(painel);
    }

    public JTextField getCampoNome() { return campoNome; }
    public JTextField getCampoCpf() { return campoCpf; }
    public JTextField getCampoNascimento() { return campoNascimento; }
    public JButton getBtnSalvar() { return btnSalvar; }
    public JButton getBtnCancelar() { return btnCancelar; }

    public void mostrarMensagem(String mensagem, boolean sucesso) {
        JOptionPane.showMessageDialog(this, mensagem,
                sucesso ? "Sucesso" : "Erro",
                sucesso ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE);
    }
}