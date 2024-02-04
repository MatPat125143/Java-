import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Automat extends JFrame {
    private JButton a1Button;
    private JButton a2Button;
    private JButton a3Button;
    private JButton a4Button;
    private JButton a5Button;
    private JButton a6Button;
    private JButton a7Button;
    private JButton a8Button;
    private JButton a9Button;
    private JButton a0Button;
    private JTextField Chosen;
    private JButton a5ZłButton;
    private JButton a2ZłButton;
    private JButton a1ZłButton;
    private JButton a50GrButton;
    private JButton a20GrButton;
    private JButton a10GrButton;
    private JTextField Money;
    private JButton logButton;
    private JButton wyjścieButton;
    private JButton kupButton;
    private JButton anulujButton;
    private JPanel LOGOJPanel;
    private JPanel MainJPanel;
    private JPanel ControlJPanel;
    private JPanel NumberJPanel;
    private JLabel Choice;
    private JPanel CoinJPanel;
    private JLabel Value;
    private JPanel ActionJPanel;
    private JPanel OptionJPanel;
    private JTable Product;
    private JPanel Automat;

    public Automat() {
        super("Automat z Napojami");
        this.setContentPane(this.Automat);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int width = 800, height = 800;
        this.setSize(width, height);
        this.setVisible(true);
        Chosen.setEnabled(false);
        Money.setEnabled(false);

        showAssortment();
        a1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {ChosenProdukt("1");}
        });
        a2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {ChosenProdukt("2");}
        });
        a3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {ChosenProdukt("3");}
        });
        a4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {ChosenProdukt("4");}
        });
        a5Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {ChosenProdukt("5");}
        });
        a6Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {ChosenProdukt("6");}
        });
        a7Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {ChosenProdukt("7");}
        });
        a8Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {ChosenProdukt("8");}
        });
        a9Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {ChosenProdukt("9");}
        });
        a0Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {ChosenProdukt("0");}
        });
        a10GrButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Sum(0.1);
            }
        });
        a20GrButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Sum(0.2);
            }
        });
        a50GrButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Sum(0.5);
            }
        });
        a1ZłButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {Sum(1.0);}
        });
        a2ZłButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { Sum(2.0);}
        });
        a5ZłButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { Sum(5.0);
            }
        });
        kupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String chosenProductNumber = Chosen.getText().trim();

                if (!chosenProductNumber.isEmpty()) {
                    int productId = Integer.parseInt(chosenProductNumber);
                    double customerMoney = Double.parseDouble(Money.getText().trim());

                    try (Connection connection = DatabaseConnector.getConnection()) {
                        String query = "SELECT nazwa, cena FROM napoje WHERE id = ?";

                        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                            preparedStatement.setInt(1, productId);
                            ResultSet resultSet = preparedStatement.executeQuery();

                            if (resultSet.next()) {
                                String productName = resultSet.getString("nazwa");
                                double productPrice = resultSet.getDouble("cena");

                                if (customerMoney >= productPrice) {

                                    double change = customerMoney - productPrice;

                                    change = Math.round(change * 100.0) / 100.0;

                                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                    String transactionDate = dateFormat.format(new Date());

                                    String insertTransactionQuery = "INSERT INTO transakcje (id_napoju, data_transakcji, kwota) VALUES (?, ?, ?)";

                                    try (PreparedStatement insertStatement = connection.prepareStatement(insertTransactionQuery)) {
                                        insertStatement.setInt(1, productId);
                                        insertStatement.setString(2, transactionDate);
                                        insertStatement.setDouble(3, productPrice);
                                        insertStatement.executeUpdate();

                                        JOptionPane.showMessageDialog(null, "Transakcja udana!\n"
                                                + "Wydano produkt: " + productName + "\n"
                                                + "Reszta: " + change +" zł");

                                        Chosen.setText("");
                                        Money.setText("0.00");
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "Niewystarczająca ilość środków.");
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Produkt o podanym numerze nie istnieje.");
                            }
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Nie wybrano produktu.");
                }
            }
        });
        anulujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Chosen.setText("");
                Money.setText("0.00");
            }
        });
        logButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login login = new Login();
                login.setVisible(true);
                dispose();
            }
        });
        wyjścieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    private void showAssortment() {
        try (Connection connection = DatabaseConnector.getConnection()) {
            String query = "SELECT id, nazwa, pojemnosc, cena FROM napoje";

            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(query);

                DefaultTableModel model = new DefaultTableModel();
                model.addColumn("Nr.");
                model.addColumn("Nazwa");
                model.addColumn("Pojemność");
                model.addColumn("Cena");

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String nazwa = resultSet.getString("nazwa");
                    int pojemnosc = resultSet.getInt("pojemnosc");
                    double cena = resultSet.getDouble("cena");

                    Produkt product = new Produkt(id, nazwa, pojemnosc, cena);
                    model.addRow(new Object[]{product.getId(), product.getNazwa(), product.getPojemnosc(), product.getCena()});
                }
                Product.setModel(model);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void ChosenProdukt(String text) {
        String currentText = Chosen.getText();
        Chosen.setText(currentText + text);
    }

    private void Sum(double amount) {
        String currentSum = Money.getText().trim();
        try {
            double currentPrice = Double.parseDouble(currentSum);
            currentPrice += amount;

            DecimalFormat df = new DecimalFormat();
            Money.setText(df.format(currentPrice));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Błąd przetwarzania kwoty. Upewnij się, że wprowadzona kwota jest liczbą.");
        }
    }
}
