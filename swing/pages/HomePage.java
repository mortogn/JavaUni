package pages;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.Button;
import ui.MainFrame;

public class HomePage extends JPanel {

    private JLabel label = new JLabel("Hello, from home");
    private Button loginNavButton = new Button("Go to Login");
    private Button registerNavButton = new Button("Go to Register");

    public HomePage(MainFrame frame) {
        setLayout(new FlowLayout());

        loginNavButton.addActionListener(e -> {
            frame.navigateTo("login");
        });

        registerNavButton.addActionListener(e -> {
            frame.navigateTo("register");
        });

        add(label);

        add(loginNavButton);
        add(registerNavButton);
    }

}