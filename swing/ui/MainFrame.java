package ui;

import javax.swing.*;
import java.awt.*;

import pages.*;

public class MainFrame extends JFrame {

    private CardLayout cardLayout;
    private JPanel mainPanel;
    private HomePage homePage;

    public MainFrame() {
        setTitle("Journal");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(800, 600));
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        LoginPage loginPage = new LoginPage(this);
        RegisterPage registerPage = new RegisterPage(this);
        homePage = new HomePage(this);

        mainPanel.add(loginPage, "login");
        mainPanel.add(registerPage, "register");
        mainPanel.add(homePage, "home");

        navigateTo("home");

        add(mainPanel);

    }

    public void navigateTo(String page) {
        if ("home".equals(page)) {
            homePage.refreshSessionUI();
        }

        cardLayout.show(mainPanel, page);
    }

}
