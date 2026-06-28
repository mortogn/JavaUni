package pages;

import javax.swing.*;

import controller.AuthController;

import java.awt.*;
import java.awt.event.MouseAdapter;

import ui.Button;
import ui.MainFrame;
import util.GridBagUtil;

public class LoginPage extends JPanel {

    private static final int FIELD_HEIGHT = 40;
    private static final int FIELD_WIDTH = 350;
    private static final Dimension INPUT_SIZE = new Dimension(FIELD_WIDTH, FIELD_HEIGHT);

    private final AuthController authController;

    private MainFrame frame;

    private JButton homeButton;

    private JLabel pageTitle;
    private JLabel pageDescription;

    private JLabel statusLabel;

    private JLabel emailLabel;
    private JTextField emailField;

    private JLabel passwordLabel;
    private JPasswordField passwordField;

    private Button loginButton;

    private JLabel createAccountLabel;

    public LoginPage(MainFrame frame) {

        this.frame = frame;
        this.authController = new AuthController();

        initComponents();
        styleComponents();
        layoutComponents();
        initListeners();
    }

    private void initComponents() {

        homeButton = new JButton("<- Home");

        pageTitle = new JLabel("Welcome Back!");
        pageDescription = new JLabel("Please log in to continue");
        statusLabel = new JLabel("");

        emailField = new JTextField();
        emailLabel = new JLabel("Email");

        passwordField = new JPasswordField();
        passwordLabel = new JLabel("Password");

        loginButton = new Button("Log in", FIELD_WIDTH, FIELD_HEIGHT);
        createAccountLabel = new JLabel("Don't have an account? Create one");
    }

    private void styleComponents() {
        pageTitle.setFont(new Font("Arial", Font.BOLD, 30));
        pageDescription.setFont(new Font("Arial", Font.PLAIN, 12));

        emailField.setBorder(inputBorder(emailField.getBorder()));
        emailField.setPreferredSize(INPUT_SIZE);
        emailLabel.setFont(new Font("Arial", Font.PLAIN, 12));

        passwordField.setPreferredSize(INPUT_SIZE);
        passwordField.setBorder(inputBorder(passwordField.getBorder()));
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 12));

    }

    private void layoutComponents() {
        GridBagUtil gbu = new GridBagUtil();

        JPanel form = new JPanel(new GridBagLayout());
        form.setBackground(Color.WHITE);
        form.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        // Add items to the form
        form.add(pageTitle, gbu.gbc(10, 0, 0, 0));
        form.add(pageDescription, gbu.gbc(4, 0, 0, 0));

        form.add(statusLabel, gbu.gbc(8, 0, 0, 0));

        form.add(emailLabel, gbu.gbc(10, 0, 0, 0));
        form.add(emailField, gbu.gbc(4, 0, 0, 0));

        form.add(passwordLabel, gbu.gbc(10, 0, 0, 0));
        form.add(passwordField, gbu.gbc(4, 0, 0, 0));
        form.add(loginButton, gbu.gbc(10, 0, 10, 0));

        setLayout(new GridBagLayout());

        Dimension formSize = form.getPreferredSize();
        Dimension createAccountSize = new Dimension(formSize.width, createAccountLabel.getPreferredSize().height);
        createAccountLabel.setHorizontalAlignment(SwingConstants.CENTER);
        createAccountLabel.setPreferredSize(createAccountSize);
        createAccountLabel.setMaximumSize(createAccountSize);

        JPanel formContainer = new JPanel();
        formContainer.setLayout(new BoxLayout(formContainer, BoxLayout.Y_AXIS));

        homeButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        form.setAlignmentX(Component.LEFT_ALIGNMENT);
        createAccountLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        formContainer.add(homeButton);
        formContainer.add(Box.createVerticalStrut(10));
        formContainer.add(form);
        formContainer.add(Box.createVerticalStrut(10));
        formContainer.add(createAccountLabel);
        add(formContainer);
    }

    private void initListeners() {
        loginButton.addActionListener(e -> handleLogin());
        homeButton.addActionListener(e -> handleNavigationToHome());
        createAccountLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                handleNavigationToRegister();
            }
        });
    }

    private void handleLogin() {
        String email = emailField.getText().trim();
        String password = new String(passwordField.getPassword()).trim();

        if (email.isBlank() || password.isBlank()) {
            statusLabel.setText("Please fill in all the fields");
            statusLabel.setForeground(Color.RED);
            return;
        }

        boolean result = authController.login(email, password);

        if (result) {
            frame.navigateTo("home");
        } else {
            statusLabel.setText("Invalid email or password");
            statusLabel.setForeground(Color.RED);
        }
    }

    private void handleNavigationToHome() {
        frame.navigateTo("home");
    }

    private void handleNavigationToRegister() {
        frame.navigateTo("register");
    }

    private javax.swing.border.Border inputBorder(javax.swing.border.Border outer) {
        return BorderFactory.createCompoundBorder(
                outer,
                BorderFactory.createEmptyBorder(0, 10, 0, 10));
    }

}
