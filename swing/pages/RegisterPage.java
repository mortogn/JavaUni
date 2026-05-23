package pages;

import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.MainFrame;

public class RegisterPage extends JPanel {
    private JLabel label = new JLabel("Hello, from Registerpage");

    public RegisterPage(MainFrame frame) {
        add(label);
    }
}