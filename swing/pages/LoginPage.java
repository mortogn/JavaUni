package pages;

import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.MainFrame;

public class LoginPage extends JPanel {

    private JLabel label = new JLabel("Hello, from login");

    public LoginPage(MainFrame frame) {
        add(label);
    }
}
