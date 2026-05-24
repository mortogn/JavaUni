package pages;

import javax.swing.*;
import java.awt.*;

import ui.Button;
import ui.MainFrame;

public class LoginPage extends JPanel {

    private static final int FIELD_HEIGHT = 40;
    private static final int FIELD_WIDTH = 300;
    private static final Dimension INPUT_SIZE = new Dimension(FIELD_WIDTH, FIELD_HEIGHT);

    private JLabel pageTitle;
    private JLabel pageDescription;

    private JLabel statusLabel;

    private JLabel userNameFieldLabel;
    private JTextField usernameField;

    private JLabel passwordFieldLabel;
    private JPasswordField passwordField;

    private Button loginButton;

    public LoginPage(MainFrame frame) {

        pageTitle = new JLabel("Welcome Back!");
        pageTitle.setFont(new Font("Arial", Font.BOLD, 30));

        pageDescription = new JLabel("Please log in to continue");
        pageDescription.setFont(new Font("Arial", Font.PLAIN, 12));

        statusLabel = new JLabel("");

        usernameField = new JTextField(20);
        usernameField.setPreferredSize(INPUT_SIZE);
        usernameField.setBorder(inputBorder(usernameField.getBorder()));

        userNameFieldLabel = new JLabel("Username");
        userNameFieldLabel.setFont(new Font("Arial", Font.PLAIN, 12));

        passwordField = new JPasswordField(20);
        passwordField.setPreferredSize(INPUT_SIZE);
        passwordField.setBorder(inputBorder(passwordField.getBorder()));

        passwordFieldLabel = new JLabel("Password");
        passwordFieldLabel.setFont(new Font("Arial", Font.PLAIN, 12));

        loginButton = new Button("Log in");
        loginButton.setPreferredSize(INPUT_SIZE);

        JPanel form = new JPanel(new GridBagLayout());
        form.setBackground(Color.WHITE);
        form.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        // Add items to the form
        form.add(pageTitle, gbc(0, 0, new Insets(10, 0, 0, 0)));
        form.add(pageDescription, gbc(0, 1, new Insets(4, 0, 0, 0)));

        form.add(statusLabel, gbc(0, 2, new Insets(8, 0, 0, 0)));

        form.add(userNameFieldLabel, gbc(0, 3, new Insets(10, 0, 0, 0)));
        form.add(usernameField, gbc(0, 4, new Insets(4, 0, 0, 0)));

        form.add(passwordFieldLabel, gbc(0, 5, new Insets(10, 0, 0, 0)));
        form.add(passwordField, gbc(0, 6, new Insets(4, 0, 0, 0)));
        form.add(loginButton, gbc(0, 7, new Insets(10, 0, 10, 0)));

        setLayout(new GridBagLayout());
        add(form);
    }

    private javax.swing.border.Border inputBorder(javax.swing.border.Border outer) {
        return BorderFactory.createCompoundBorder(
                outer,
                BorderFactory.createEmptyBorder(0, 10, 0, 10));
    }

    private java.awt.GridBagConstraints gbc(int gridx, int gridy, Insets insets) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = insets;
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        return gbc;
    }
}
