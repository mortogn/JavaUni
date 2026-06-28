package pages;

import java.awt.*;

import javax.swing.*;

import controller.Session;
import model.User;
import ui.Button;
import ui.MainFrame;

public class HomePage extends JPanel {

    private JPanel header = new JPanel();
    private JLabel logo = new JLabel("Journal");
    private JLabel userLabel = new JLabel();

    private JPanel actionsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

    private Button createButton = new Button("Create New Journal");
    private Button loginButton = new Button("Login");
    private Button registerButton = new Button("Register");

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

        actionsPanel.setOpaque(false);

        header.add(actionsPanel, BorderLayout.EAST);

        add(header, BorderLayout.NORTH);
    }

    private void styleComponents() {
        logo.setFont(new Font("Arial", Font.BOLD, 30));
        userLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        createButton.setColors(new Color(242, 242, 242), new Color(230, 230, 230), Color.BLACK);
        registerButton.setColors(new Color(242, 242, 242), new Color(230, 230, 230), Color.BLACK);

    }

    private void initListeners() {
        createButton.addActionListener(e -> handleNavigationToCreate());
        loginButton.addActionListener(e -> handleNavigationToLogin());
        registerButton.addActionListener(e -> handleNavigationToRegister());
    }

    public void refreshSessionUI() {
        User currentUser = Session.getCurrentUser();

        actionsPanel.removeAll();

        if (currentUser != null) {
            userLabel.setText("Hi, " + getFirstName(currentUser.getFullname()));
            actionsPanel.add(userLabel);
            actionsPanel.add(createButton);
        } else {
            actionsPanel.add(loginButton);
            actionsPanel.add(registerButton);
        }

        actionsPanel.revalidate();
        actionsPanel.repaint();
    }

    private String getFirstName(String fullname) {
        if (fullname == null || fullname.isBlank()) {
            return "User";
        }

        String[] names = fullname.trim().split("\\s+");
        return names[0];
    }

    private void handleNavigationToLogin() {
        frame.navigateTo("login");
    }

    private void handleNavigationToRegister() {
        frame.navigateTo("register");
    }

    private void handleNavigationToCreate() {
        JOptionPane.showMessageDialog(this, "Create Journal is coming soon.");
    }

}