
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Historia extends JFrame {
    private JTable Histori;
    private JButton wyjścieButton;
    private JPanel LOGOJPanel;
    private JLabel Logo;
    private JPanel HistoriJPanel;
    private JPanel OptionJPanel;
    private JPanel HistoryPanel;
    private JScrollPane History;

    public Historia() {
        super("Historia Transakcji");
        this.setContentPane(this.HistoryPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int width = 400, height = 400;
        this.setSize(width,height);
        this.setVisible(true);

        showTransactions();
        wyjścieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminPanel adminPanel = new AdminPanel();
                adminPanel.setVisible(true);
                dispose();
            }
        });
    }

    private void showTransactions() {
        String url = "jdbc:mysql://localhost:3306/produkty?serverTimezone=UTC";
        String user = "root";
        String password = "";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT t.id, n.nazwa, t.data_transakcji, t.kwota FROM transakcje t JOIN napoje n ON t.id_napoju = n.id;";

            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(query);

                DefaultTableModel model = new DefaultTableModel();
                model.addColumn("Nr.");
                model.addColumn("Nazwa");
                model.addColumn("Data-Transakcji");
                model.addColumn("Kwota");

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String nazwa = resultSet.getString("nazwa");
                    String data = resultSet.getString("data_transakcji");
                    double kwota = resultSet.getDouble("kwota");

                    model.addRow(new Object[]{id, nazwa, data, kwota});
                }
                Histori.setModel(model);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
