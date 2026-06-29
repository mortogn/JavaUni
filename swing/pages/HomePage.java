package pages;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.*;

import controller.JournalController;
import controller.Session;
import model.Journal;
import model.User;
import services.UserServices;
import ui.Button;
import ui.MainFrame;

public class HomePage extends JPanel {

    private static final int ABSTRACT_PREVIEW_LENGTH = 150;

    private JPanel header = new JPanel();
    private JLabel logo = new JLabel("Journal");
    private JLabel userLabel = new JLabel();

    private JPanel actionsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    private JPanel journalsContainer = new JPanel();

    private Button createButton = new Button("Create New Journal");
    private Button loginButton = new Button("Login");
    private Button registerButton = new Button("Register");

    private JournalController journalController = new JournalController();
    private UserServices userServices = new UserServices();

    private MainFrame frame;

    public HomePage(MainFrame frame) {
        this.frame = frame;

        setLayout(new BorderLayout());

        initHeader();
        initBody();
        styleComponents();
        initListeners();
        refreshSessionUI();

    }

    private void initHeader() {
        header.setLayout(new BorderLayout());
        header.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        header.add(logo, BorderLayout.WEST);

        actionsPanel.setOpaque(false);

        header.add(actionsPanel, BorderLayout.EAST);

        add(header, BorderLayout.NORTH);
    }

    private void initBody() {
        journalsContainer.setLayout(new BoxLayout(journalsContainer, BoxLayout.Y_AXIS));
        journalsContainer.setBorder(BorderFactory.createEmptyBorder(20, 60, 20, 60));
        journalsContainer.setBackground(Color.WHITE);

        JScrollPane journalsScrollPane = new JScrollPane(journalsContainer);
        journalsScrollPane.getVerticalScrollBar().setUnitIncrement(16);
        journalsScrollPane.setBorder(BorderFactory.createEmptyBorder());

        add(journalsScrollPane, BorderLayout.CENTER);
    }

    private void styleComponents() {
        logo.setFont(new Font("Arial", Font.BOLD, 30));
        userLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        createButton.setColors(new Color(242, 242, 242), new Color(230, 230, 230), Color.BLACK);
        registerButton.setColors(new Color(242, 242, 242), new Color(230, 230, 230), Color.BLACK);
        setBackground(Color.WHITE);

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
        renderJournals();
    }

    private void renderJournals() {
        journalsContainer.removeAll();

        List<Journal> journals = journalController.getJournals();

        if (journals.isEmpty()) {
            JLabel emptyLabel = new JLabel("No journals yet.");
            emptyLabel.setFont(new Font("Arial", Font.PLAIN, 16));
            emptyLabel.setForeground(new Color(90, 90, 90));
            emptyLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
            journalsContainer.add(emptyLabel);
        } else {
            for (Journal journal : journals) {
                journalsContainer.add(buildJournalCard(journal));
                journalsContainer.add(Box.createVerticalStrut(14));
            }
        }

        journalsContainer.revalidate();
        journalsContainer.repaint();
    }

    private JPanel buildJournalCard(Journal journal) {
        JPanel card = new JPanel(new BorderLayout(16, 0));
        card.setAlignmentX(Component.LEFT_ALIGNMENT);
        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(40, 40, 40), 1),
                BorderFactory.createEmptyBorder(12, 12, 12, 12)));
        card.setBackground(Color.WHITE);
        card.setCursor(new Cursor(Cursor.HAND_CURSOR));

        JPanel previewBox = new JPanel();
        previewBox.setPreferredSize(new Dimension(130, 110));
        previewBox.setMaximumSize(new Dimension(130, 110));
        previewBox.setBorder(BorderFactory.createLineBorder(new Color(40, 40, 40), 1));
        previewBox.setBackground(Color.WHITE);
        previewBox.setLayout(new BoxLayout(previewBox, BoxLayout.Y_AXIS));

        JLabel previewTitle = new JLabel("Title");
        previewTitle.setFont(new Font("Arial", Font.BOLD, 20));
        previewTitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel previewSmall = new JLabel("Small");
        previewSmall.setFont(new Font("Arial", Font.PLAIN, 16));
        previewSmall.setAlignmentX(Component.CENTER_ALIGNMENT);

        previewBox.add(Box.createVerticalGlue());
        previewBox.add(previewTitle);
        previewBox.add(Box.createVerticalStrut(6));
        previewBox.add(previewSmall);
        previewBox.add(Box.createVerticalGlue());

        JPanel details = new JPanel();
        details.setLayout(new BoxLayout(details, BoxLayout.Y_AXIS));
        details.setBackground(Color.WHITE);

        JLabel titleLabel = new JLabel(nonBlank(journal.getTitle(), "Untitled"));
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));

        JLabel authorLabel = new JLabel(resolveAuthor(journal.getUserEmail()));
        authorLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        JLabel abstractLabel = new JLabel(truncate(nonBlank(journal.getAbstractText(), "-"), ABSTRACT_PREVIEW_LENGTH));
        abstractLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        JLabel keywordsLabel = new JLabel(nonBlank(journal.getKeywords(), "-"));
        keywordsLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        details.add(titleLabel);
        details.add(Box.createVerticalStrut(6));
        details.add(authorLabel);
        details.add(Box.createVerticalStrut(6));
        details.add(abstractLabel);
        details.add(Box.createVerticalStrut(6));
        details.add(keywordsLabel);

        card.add(previewBox, BorderLayout.WEST);
        card.add(details, BorderLayout.CENTER);

        MouseAdapter openDetailListener = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.navigateToJournalDetail(journal);
            }
        };

        attachClickListener(card, openDetailListener);

        return card;
    }

    private void attachClickListener(Component component, MouseAdapter listener) {
        component.addMouseListener(listener);

        if (component instanceof Container) {
            for (Component child : ((Container) component).getComponents()) {
                attachClickListener(child, listener);
            }
        }
    }

    private String resolveAuthor(String email) {
        if (email == null || email.isBlank()) {
            return "Unknown author";
        }

        User user = userServices.getUserByEmail(email);

        if (user != null && user.getFullname() != null && !user.getFullname().isBlank()) {
            return user.getFullname();
        }

        return email;
    }

    private String truncate(String text, int maxLength) {
        if (text == null || text.length() <= maxLength) {
            return text;
        }
        return text.substring(0, maxLength) + "...";
    }

    private String nonBlank(String value, String fallback) {
        if (value == null || value.isBlank()) {
            return fallback;
        }
        return value;
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
        frame.navigateTo("createJournal");
    }

}