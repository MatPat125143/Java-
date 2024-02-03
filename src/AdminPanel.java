import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminPanel extends JFrame {
    private JButton edytujButton;
    private JButton historiaButton;
    private JButton wyjścieButton;
    private JPanel AdminPanel;
    private JPanel LOGOPanel;
    private JLabel LOGO;
    private JPanel EditPanel;
    private JLabel Edit;
    private JPanel HistoryPanel;
    private JPanel ExitPanel;
    private JLabel History;

    public AdminPanel() {
        super("Panel Administracyjny");
        this.setContentPane(this.AdminPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int width = 600, height = 400;
        this.setSize(width, height);
        this.setVisible(true);


        edytujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Edycja edycja = new Edycja();
                edycja.setVisible(true);
                dispose();
            }
        });

        historiaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Historia historia = new Historia();
                historia.setVisible(true);
                dispose();
            }
        });

        wyjścieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Automat automat = new Automat();
                dispose();
            }
        });
    }
}
