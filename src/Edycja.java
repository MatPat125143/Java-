import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Edycja extends JFrame{
    private JTable Product;
    private JTextField price;
    private JTextField capacity;
    private JButton dodajButton;
    private JButton usuńButton;
    private JButton zapiszButton;
    private JButton wyczyśćButton;
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

        productName.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (c == ',') {
                    e.consume();
                }
            }
        });

        price.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                String filter = "0123456789.";
                char c = e.getKeyChar();
                if(filter.indexOf(c)<0) {
                    e.consume();
                }
            }
        });

        capacity.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                String filter = "0123456789.";
                char c = e.getKeyChar();
                if(filter.indexOf(c)<0) {
                    e.consume();
                }
            }
        });

        number.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                String filter = "0123456789.";
                char c = e.getKeyChar();
                if(filter.indexOf(c)<0) {
                    e.consume();
                }
            }
        });
    }

}
