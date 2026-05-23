package ui;

import javax.swing.*;

import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;

import java.awt.*;

public class MainFrame extends JFrame {

    private CardLayout cardLayout;
    private JPanel mainPanel;

    public MainFrame() {
        setTitle("Journal");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(800, 600));
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        mainPanel.add(new LoginPage(this), "login");
        mainPanel.add(new RegisterPage(this), "register");
        mainPanel.add(new HomePage(this), "home");

        navigateTo("home");

        add(mainPanel);

    }

    public void navigateTo(String page) {
        cardLayout.show(mainPanel, page);
    }

}
