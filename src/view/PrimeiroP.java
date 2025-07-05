package view;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.*;

public class PrimeiroP extends JFrame {
    private JPanel panel;
    private JButton salvarBtn;
    private final Map<Integer, JTextField> camposPresenca = new HashMap<>();

    private final String DB_URL = "jdbc:mysql://localhost:3306/sistema_escolar";
    private final String DB_USER = "root";       // substitua pelo seu usuário
    private final String DB_PASSWORD = "";       // substitua pela sua senha

    public PrimeiroP(int turmaId) {
        setTitle("Frequência da Turma " + turmaId);
        setSize(500, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        JScrollPane scroll = new JScrollPane(panel);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        add(scroll, BorderLayout.CENTER);

        salvarBtn = new JButton("Salvar Frequência");
        salvarBtn.setPreferredSize(new Dimension(200, 40));
        salvarBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        salvarBtn.addActionListener(e -> salvarFrequencia(turmaId));

        JPanel footer = new JPanel(new FlowLayout());
        footer.add(salvarBtn);
        add(footer, BorderLayout.SOUTH);

        carregarAlunos(turmaId);
        setVisible(true);
    }

    private void carregarAlunos(int turmaId) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "SELECT id, nome FROM alunos WHERE turma_id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, turmaId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int alunoId = rs.getInt("id");
                String nome = rs.getString("nome");

                JLabel nomeLabel = new JLabel(nome);
                nomeLabel.setPreferredSize(new Dimension(200, 20));

                JTextField campoPresenca = new JTextField(10);
                camposPresenca.put(alunoId, campoPresenca);

                JPanel linha = new JPanel(new FlowLayout(FlowLayout.LEFT));
                linha.add(nomeLabel);
                linha.add(new JLabel("Presença:"));
                linha.add(campoPresenca);

                panel.add(linha);
            }

            panel.revalidate();
            panel.repaint();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao carregar alunos: " + e.getMessage(),
                    "Erro de Banco de Dados", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void salvarFrequencia(int turmaId) {
        java.sql.Date dataHoje = new java.sql.Date(System.currentTimeMillis());

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String insert = "INSERT INTO frequencias (aluno_id, turma_id, data, presente) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(insert);

            boolean temFrequencia = false;

            for (Map.Entry<Integer, JTextField> entry : camposPresenca.entrySet()) {
                Integer alunoId = entry.getKey();
                String valor = entry.getValue().getText().trim();

                if (!valor.isEmpty()) {
                    stmt.setInt(1, alunoId);
                    stmt.setInt(2, turmaId);
                    stmt.setDate(3, dataHoje);
                    stmt.setString(4, valor);
                    stmt.addBatch();
                    temFrequencia = true;
                }
            }

            if (!temFrequencia) {
                JOptionPane.showMessageDialog(this, "⚠️ Nenhuma presença foi digitada.");
                return;
            }

            stmt.executeBatch();
            JOptionPane.showMessageDialog(this, "✅ Frequência salva com sucesso!");
            dispose();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao salvar frequência: " + ex.getMessage(),
                    "Erro de Banco de Dados", JOptionPane.ERROR_MESSAGE);
        }
    }
}