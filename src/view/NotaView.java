package view;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.*;

public class NotaView extends JFrame {
    private final Map<Integer, JTextField> campoNota = new HashMap<>();
    private final String DB_URL = "jdbc:mysql://localhost:3306/sistema_escolar";
    private final String DB_USER = "root";
    private final String DB_PASSWORD = "";

    public NotaView(int turmaId) {
        setTitle("Lançar Notas da Turma " + turmaId);
        setSize(500, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        JScrollPane scroll = new JScrollPane(panel);
        add(scroll, BorderLayout.CENTER);

        JButton salvarBtn = new JButton("Salvar Notas");
        salvarBtn.setPreferredSize(new Dimension(180, 40));
        salvarBtn.addActionListener(e -> salvarNotas(turmaId));

        JPanel footer = new JPanel();
        footer.add(salvarBtn);
        add(footer, BorderLayout.SOUTH);

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "SELECT id, nome FROM alunos WHERE turma_id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, turmaId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int alunoId = rs.getInt("id");
                String nome = rs.getString("nome");

                JLabel nomeLabel = new JLabel(nome);
                JTextField notaField = new JTextField(5);
                campoNota.put(alunoId, notaField);

                JPanel linha = new JPanel(new FlowLayout(FlowLayout.LEFT));
                linha.add(nomeLabel);
                linha.add(new JLabel(" Nota:"));
                linha.add(notaField);

                panel.add(linha);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar alunos: " + e.getMessage());
        }

        setVisible(true);
    }

    private void salvarNotas(int turmaId) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String insert = "INSERT INTO notas (aluno_id, turma_id, nota) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(insert);

            for (Map.Entry<Integer, JTextField> entry : campoNota.entrySet()) {
                Integer alunoId = entry.getKey();
                String valor = entry.getValue().getText().trim();

                if (!valor.isEmpty()) {
                    double nota = Double.parseDouble(valor.replace(",", "."));
                    stmt.setInt(1, alunoId);
                    stmt.setInt(2, turmaId);
                    stmt.setDouble(3, nota);
                    stmt.addBatch();
                }
            }

            stmt.executeBatch();
            JOptionPane.showMessageDialog(this, "✅ Notas salvas com sucesso!");
            dispose();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar notas: " + ex.getMessage());
        }
    }
}