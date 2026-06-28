package pages;

import java.awt.*;

import javax.swing.*;

import ui.Button;
import ui.MainFrame;

public class HomePage extends JPanel {

    private JPanel header = new JPanel();
    private JLabel logo = new JLabel("Journal");

    private Button createButton = new Button("Create New Journal");
    private Button loginButton = new Button("Login");

    private MainFrame frame;

    public HomePage(MainFrame frame) {
        this.frame = frame;

        setLayout(new BorderLayout());

        initHeader();
        styleComponents();
        initListeners();

    }

    private void initHeader() {
        header.setLayout(new BorderLayout());
        header.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        header.add(logo, BorderLayout.WEST);

        JPanel actionsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        actionsPanel.setOpaque(false);

        actionsPanel.add(createButton);
        actionsPanel.add(loginButton);

        header.add(actionsPanel, BorderLayout.EAST);

        add(header, BorderLayout.NORTH);
    }

    private void styleComponents() {
        logo.setFont(new Font("Arial", Font.BOLD, 30));
        createButton.setColors(new Color(242, 242, 242), new Color(230, 230, 230), Color.BLACK);

    }

    private void initListeners() {
        createButton.addActionListener(e -> handleNavigationToCreate());
        loginButton.addActionListener(e -> handleNavigationToLogin());
    }

    private void handleNavigationToLogin() {
        frame.navigateTo("login");
    }

    private void handleNavigationToCreate() {
        frame.navigateTo("register");
    }

}