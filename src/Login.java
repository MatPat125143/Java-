
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    private JTextField LoginText;
    private JPasswordField PasswordText;
    private JButton zalogujButton;
    private JButton anulujButton;
    private JPanel LogoJPanel;
    private JPanel FormJPanel;
    private JPanel OptionJPanel;
    private JLabel Password;
    private JLabel Login;
    private JLabel Logo;
    private JPanel LoginPanel;

    public Login() {
        super("Logowanie");
        this.setContentPane(this.LoginPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int width = 600, heigth = 400;
        this.setSize(width, heigth);
        this.setVisible(true);


        zalogujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = LoginText.getText();
                String password = new String(PasswordText.getPassword());
                if (username.equals("admin") && password.equals("admin")) {
                    JOptionPane.showMessageDialog(Login, "Logowanie przebiegło poprawnie", "Logowanie Administratora", JOptionPane.INFORMATION_MESSAGE);
                    AdminPanel adminPanel = new AdminPanel();
                    adminPanel.setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(Login, "Nieprawidłowy login lub hasło", "Błąd w logowaniu", JOptionPane.WARNING_MESSAGE);
                }
            }
        });


        anulujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Automat automat = new Automat();
                automat.setVisible(true);
                dispose();
            }
        });
    }


}
