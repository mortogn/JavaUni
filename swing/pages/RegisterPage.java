package pages;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import controller.AuthController;
import ui.Button;
import ui.MainFrame;
import util.GridBagUtil;

public class RegisterPage extends JPanel {
    private static final int FIELD_HEIGHT = 40;
    private static final int FIELD_WIDTH = 350;
    private static final Dimension INPUT_SIZE = new Dimension(FIELD_WIDTH, FIELD_HEIGHT);

    private final AuthController authController;

    private JButton homeButton;

    private JLabel pageTitle;
    private JLabel pageDescription;

    private JLabel statusLabel;

    private JLabel fullnameLabel;
    private JTextField fullnameField;

    private JLabel emailLabel;
    private JTextField emailField;

    private JLabel passwordLabel;
    private JPasswordField passwordField;

    private Button registerButton;

    private JLabel loginLabel;

    private MainFrame frame;

    public RegisterPage(MainFrame frame) {
        this.frame = frame;
        this.authController = new AuthController();

        initComponent();
        styleComponents();
        layoutComponents();
        initListeners();
    }

    private void initComponent() {

        homeButton = new JButton("<- Home");

        pageTitle = new JLabel("Create an account");
        pageDescription = new JLabel("Please fill in the details to create an account");
        statusLabel = new JLabel("");

        fullnameField = new JTextField();
        fullnameLabel = new JLabel("Full name");

        emailField = new JTextField();
        emailLabel = new JLabel("Email");

        passwordField = new JPasswordField();
        passwordLabel = new JLabel("Password");

        registerButton = new Button("Register");

        loginLabel = new JLabel("Already have an account? Log in");
    }

    private void styleComponents() {

        homeButton.setFont(new Font("Arial", Font.PLAIN, 12));

        pageTitle.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 30));
        pageDescription.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 12));

        fullnameField.setPreferredSize(INPUT_SIZE);
        fullnameField.setBorder(inputBorder(fullnameField.getBorder()));
        fullnameLabel.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 12));

        emailField.setPreferredSize(INPUT_SIZE);
        emailField.setBorder(inputBorder(emailField.getBorder()));
        emailLabel.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 12));

        passwordField.setPreferredSize(INPUT_SIZE);
        passwordField.setBorder(inputBorder(passwordField.getBorder()));
        passwordLabel.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 12));

        registerButton.setPreferredSize(INPUT_SIZE);
    }

    private void initListeners() {
        registerButton.addActionListener(e -> handleRegister());
        loginLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.navigateTo("login");
            }
        });
    }

    private void handleRegister() {
        String email = emailField.getText().trim();
        String password = new String(passwordField.getPassword()).trim();
        String fullname = fullnameField.getText().trim();

        if (email.isBlank() || password.isBlank() || fullname.isBlank()) {
            statusLabel.setText("Please fill in all the fields");
            statusLabel.setForeground(Color.RED);
            return;
        }

        boolean success = authController.register(email, password, fullname);

        if (!success) {
            statusLabel.setText("Failed to register. Please try again.");
            statusLabel.setForeground(Color.RED);
            return;
        }

        frame.navigateTo("home");

    }

    private void layoutComponents() {

        GridBagUtil gbu = new GridBagUtil();

        JPanel form = new JPanel(new GridBagLayout());
        form.setBackground(Color.WHITE);
        form.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        form.add(pageTitle, gbu.gbc(0, 0, 0, 0));
        form.add(pageDescription, gbu.gbc(4, 0, 0, 0));

        form.add(statusLabel, gbu.gbc(5, 0, 0, 0));

        form.add(fullnameLabel, gbu.gbc(10, 0, 0, 0));
        form.add(fullnameField, gbu.gbc(4, 0, 0, 0));

        form.add(emailLabel, gbu.gbc(10, 0, 0, 0));
        form.add(emailField, gbu.gbc(4, 0, 0, 0));
        form.add(passwordLabel, gbu.gbc(10, 0, 0, 0));
        form.add(passwordField, gbu.gbc(4, 0, 0, 0));

        form.add(registerButton, gbu.gbc(20, 0, 0, 0));

        setLayout(new GridBagLayout());

        Dimension formSize = form.getPreferredSize();
        Dimension loginSize = new Dimension(formSize.width, loginLabel.getPreferredSize().height);
        loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
        loginLabel.setPreferredSize(loginSize);
        loginLabel.setMaximumSize(loginSize);

        JPanel formContainer = new JPanel();
        formContainer.setLayout(new BoxLayout(formContainer, BoxLayout.Y_AXIS));

        homeButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        form.setAlignmentX(Component.LEFT_ALIGNMENT);
        loginLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        formContainer.add(homeButton);
        formContainer.add(Box.createVerticalStrut(10));
        formContainer.add(form);
        formContainer.add(Box.createVerticalStrut(10));
        formContainer.add(loginLabel);

        add(formContainer);
    }

    private javax.swing.border.Border inputBorder(javax.swing.border.Border outer) {
        return BorderFactory.createCompoundBorder(
                outer,
                BorderFactory.createEmptyBorder(0, 10, 0, 10));
    }

}