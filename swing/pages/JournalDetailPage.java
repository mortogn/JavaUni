package pages;

import javax.swing.*;

import model.Journal;
import model.User;
import services.UserServices;
import ui.MainFrame;

import java.awt.*;

public class JournalDetailPage extends JPanel {

    private final UserServices userServices = new UserServices();

    private MainFrame frame;

    private JButton homeButton;

    private JLabel titleLabel;
    private JLabel authorLabel;
    private JLabel keywordsLabel;

    private JTextArea contentArea;

    public JournalDetailPage(MainFrame frame) {
        this.frame = frame;

        initComponents();
        styleComponents();
        layoutComponents();
        initListeners();
    }

    private void initComponents() {
        homeButton = new JButton("<- Home");

        titleLabel = new JLabel("Untitled");
        authorLabel = new JLabel("Author");
        keywordsLabel = new JLabel("Keywords");

        contentArea = new JTextArea();
    }

    private void styleComponents() {
        setLayout(new BorderLayout());

        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        authorLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        keywordsLabel.setFont(new Font("Arial", Font.PLAIN, 13));

        contentArea.setEditable(false);
        contentArea.setLineWrap(true);
        contentArea.setWrapStyleWord(true);
        contentArea.setFont(new Font("Arial", Font.PLAIN, 14));
        contentArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }

    private void layoutComponents() {
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));
        headerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        homeButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        titleLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        authorLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        keywordsLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        headerPanel.add(homeButton);
        headerPanel.add(Box.createVerticalStrut(15));
        headerPanel.add(titleLabel);
        headerPanel.add(Box.createVerticalStrut(8));
        headerPanel.add(authorLabel);
        headerPanel.add(Box.createVerticalStrut(6));
        headerPanel.add(keywordsLabel);

        JScrollPane contentScrollPane = new JScrollPane(contentArea);
        contentScrollPane.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));

        add(headerPanel, BorderLayout.NORTH);
        add(contentScrollPane, BorderLayout.CENTER);
    }

    private void initListeners() {
        homeButton.addActionListener(e -> frame.navigateTo("home"));
    }

    public void setJournal(Journal journal) {
        if (journal == null) {
            titleLabel.setText("Untitled");
            authorLabel.setText("Author: Unknown");
            keywordsLabel.setText("Keywords: -");
            contentArea.setText("");
            return;
        }

        titleLabel.setText(nonBlank(journal.getTitle(), "Untitled"));

        String author = resolveAuthorName(journal.getUserEmail());
        authorLabel.setText("Author: " + author);

        String keywords = nonBlank(journal.getKeywords(), "-");
        keywordsLabel.setText("Keywords: " + keywords);

        contentArea.setText(nonBlank(journal.getContent(), "No content available."));
        contentArea.setCaretPosition(0);
    }

    private String resolveAuthorName(String email) {
        if (email == null || email.isBlank()) {
            return "Unknown";
        }

        User user = userServices.getUserByEmail(email);

        if (user != null && user.getFullname() != null && !user.getFullname().isBlank()) {
            return user.getFullname();
        }

        return email;
    }

    private String nonBlank(String value, String fallback) {
        if (value == null || value.isBlank()) {
            return fallback;
        }
        return value;
    }
}
