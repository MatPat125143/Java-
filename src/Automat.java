import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

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
        a5ZłButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        a2ZłButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        a1ZłButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        a50GrButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        a20GrButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        a10GrButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        kupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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
        String url = "jdbc:mysql://localhost:3306/produkty?serverTimezone=UTC";
        String user = "root";
        String password = "";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
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

                    model.addRow(new Object[]{id, nazwa, pojemnosc, cena, ilosc});
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


}
