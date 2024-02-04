import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.*;

public class Edycja extends JFrame{
    private JTable Product;
    private JTextField price;
    private JTextField capacity;
    private JButton dodajButton;
    private JButton usuńButton;
    private JButton wyjścieButton;
    private JTextField number;
    private JPanel EditPanel;
    private JPanel LOGOPanel;
    private JLabel LOGO;
    private JPanel ProductPanel;
    private JScrollPane ProductScroll;
    private JPanel MenuPanel;
    private JPanel OptionPanel;
    private JLabel NameJ;
    private JLabel PriceJ;
    private JLabel CapacityJ;
    private JLabel NumberJ;
    private JPanel ActionPanel;
    private JPanel ExitPanel;
    private JTextField productName;

    public Edycja() {
        super("Asortyment");
        this.setContentPane(EditPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int width = 600, height = 400;
        this.setSize(width, height);
        this.setVisible(true);

        showAssortment();

        productName.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isLetterOrDigit(c) && !Character.isWhitespace(c)) {
                    e.consume();
                    JOptionPane.showMessageDialog(null, "Wprowadź poprawną nazwę (tylko litery, cyfry i spacje).");
                }
            }
        });
        price.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) && c != '.') {
                    e.consume();
                    JOptionPane.showMessageDialog(null, "Wprowadź poprawną cenę (tylko cyfry i kropka).");
                }
            }
        });
        capacity.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume();
                    JOptionPane.showMessageDialog(null, "Wprowadź poprawną ilość (tylko cyfry).");
                }
            }
        });
        number.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) && c != '.') {
                    e.consume();
                    JOptionPane.showMessageDialog(null, "Wprowadź poprawną pojemność (tylko cyfry i kropka).");
                }
            }
        });
        dodajButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nazwa = productName.getText();
                double cena = Double.parseDouble(price.getText());
                int pojemosc = Integer.parseInt(capacity.getText());
                int ilosc = Integer.parseInt(number.getText());

                try (Connection connection = DatabaseConnector.getConnection()) {
                    String query = "INSERT INTO napoje (nazwa, cena, pojemnosc, ilosc) VALUES (?, ?, ?, ?)";

                    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                        preparedStatement.setString(1, nazwa);
                        preparedStatement.setDouble(2, cena);
                        preparedStatement.setInt(3, pojemosc);
                        preparedStatement.setInt(4, ilosc);

                        int rowsAffected = preparedStatement.executeUpdate();

                        if (rowsAffected > 0) {
                            JOptionPane.showMessageDialog(null, "Produkt dodany do bazy danych.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Nie udało się dodać produktu do bazy danych.");
                        }
                        showAssortment();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        usuńButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = Product.getSelectedRow();
                if (selectedRow != -1) {
                    int id = Integer.parseInt(Product.getValueAt(selectedRow, 0).toString());

                    int dialogResult = JOptionPane.showConfirmDialog(null, "Czy na pewno chcesz usunąć ten produkt?", "Potwierdzenie", JOptionPane.YES_NO_OPTION);
                    if (dialogResult == JOptionPane.YES_OPTION) {
                        try (Connection connection = DatabaseConnector.getConnection();
                             Statement statement = connection.createStatement()) {

                            String deleteQuery = "DELETE FROM napoje WHERE id=" + id;
                            int rowsAffected = statement.executeUpdate(deleteQuery);

                            if (rowsAffected > 0) {
                                JOptionPane.showMessageDialog(null, "Produkt został usunięty.");
                                showAssortment();
                            } else {
                                JOptionPane.showMessageDialog(null, "Nie udało się usunąć produktu.");
                            }
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Wybierz produkt do usunięcia z tabeli.");
                }
            }
        });
        wyjścieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminPanel adminPanel = new AdminPanel();
                adminPanel.setVisible(true);
                dispose();
            }
        });
    }
    private void showAssortment() {
        try (Connection connection = DatabaseConnector.getConnection()) {
            String query = "SELECT id, nazwa, pojemnosc, cena, ilosc FROM napoje";

            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(query);

                DefaultTableModel model = new DefaultTableModel();
                model.addColumn("Nr.");
                model.addColumn("Nazwa");
                model.addColumn("Pojemność");
                model.addColumn("Cena");
                model.addColumn("Ilość");

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String nazwa = resultSet.getString("nazwa");
                    int pojemnosc = resultSet.getInt("pojemnosc");
                    double cena = resultSet.getDouble("cena");
                    int ilosc = resultSet.getInt("ilosc");

                    Produkt product = new Produkt(id, nazwa, pojemnosc, cena, ilosc);
                    model.addRow(new Object[]{product.getId(), product.getNazwa(), product.getPojemnosc(), product.getCena(), product.getIlosc()});
                }
                Product.setModel(model);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
