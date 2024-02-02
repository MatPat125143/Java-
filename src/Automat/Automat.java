package Automat;

import javax.swing.*;

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
        int width = 600, height = 800;
        this.setSize(width, height);
        this.setVisible(true);
    }


}
