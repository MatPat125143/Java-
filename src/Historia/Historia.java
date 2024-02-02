package Historia;

import AdminPanel.AdminPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        this.setContentPane(this.HistoriJPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int width = 600, height = 400;
        this.setSize(width,height);
        this.setVisible(true);


        wyjścieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminPanel adminPanel = new AdminPanel();
                adminPanel.setVisible(true);
                dispose();
            }
        });
    }

}
