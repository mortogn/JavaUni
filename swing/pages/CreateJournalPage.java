package pages;

import javax.swing.*;
import javax.swing.border.Border;

import controller.JournalController;
import ui.MainFrame;
import util.GridBagUtil;

import java.awt.*;
import ui.Button;

public class CreateJournalPage extends JPanel {

    JournalController journalController = new JournalController();

    private final int FIELD_HEIGHT = 40;
    private final int FIELD_WIDTH = 650;
    private final int TEXTAREA_HEIGHT = 250;

    private final Dimension INPUT_SIZE = new Dimension(FIELD_WIDTH, FIELD_HEIGHT);
    private final Dimension TEXTAREA_SIZE = new Dimension(FIELD_WIDTH, TEXTAREA_HEIGHT);

    private MainFrame frame;

    private JButton homeButton;

    private JLabel titleLabel;
    private JLabel subtitleLabel;

    private JLabel statusLabel;

    private JLabel titleFieldLabel;
    private JTextField titleField;

    private JLabel abstractLabel;
    private JTextArea abstractField;
    private JScrollPane abstractScrollPane;

    private JLabel keywords;
    private JTextField keywordsField;

    private JLabel contentLabel;
    private JTextArea contentField;
    private JScrollPane contentScrollPane;

    private Button createButton;

    public CreateJournalPage(MainFrame mainFrame) {
        this.frame = mainFrame;
        setLayout(new BorderLayout());
        initComponents();
        styleComponents();
        layoutComponents();
        initListeners();
    }

    private void initComponents() {

        homeButton = new JButton("<- Home");

        titleLabel = new JLabel("Create a new journal");
        subtitleLabel = new JLabel("Please fill in the details to create a journal");

        statusLabel = new JLabel(" ");

        titleFieldLabel = new JLabel("Title");
        titleField = new JTextField();

        abstractLabel = new JLabel("Abstract");
        abstractField = new JTextArea();
        abstractScrollPane = new JScrollPane(abstractField);

        keywords = new JLabel("Keywords");
        keywordsField = new JTextField();

        contentLabel = new JLabel("Content");
        contentField = new JTextArea();
        contentScrollPane = new JScrollPane(contentField);

        createButton = new Button("Create Journal");
        createButton.setPreferredSize(INPUT_SIZE);

    }

    private void styleComponents() {
        titleLabel.setFont(new Font("Arial", Font.BOLD, 40));
        subtitleLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        statusLabel.setForeground(Color.GRAY);

        titleField.setPreferredSize(INPUT_SIZE);
        titleField.setBorder(inputBorder(titleField.getBorder()));

        abstractField.setBorder(inputBorder(abstractField.getBorder()));
        abstractField.setLineWrap(true);
        abstractField.setWrapStyleWord(true);
        abstractScrollPane.setPreferredSize(TEXTAREA_SIZE);

        keywordsField.setPreferredSize(INPUT_SIZE);
        keywordsField.setBorder(inputBorder(keywordsField.getBorder()));

        contentField.setBorder(inputBorder(contentField.getBorder()));
        contentField.setLineWrap(true);
        contentField.setWrapStyleWord(true);
        contentScrollPane.setPreferredSize(TEXTAREA_SIZE);
    }

    private void layoutComponents() {

        GridBagUtil gbu = new GridBagUtil();

        JPanel form = new JPanel(new GridBagLayout());

        form.add(titleLabel, gbu.gbc(10, 0, 0, 0));
        form.add(subtitleLabel, gbu.gbc(4, 0, 0, 0));

        form.add(statusLabel, gbu.gbc(5, 0, 0, 0));

        form.add(titleFieldLabel, gbu.gbc(8, 0, 0, 0));
        form.add(titleField, gbu.gbc(4, 0, 0, 0));

        form.add(abstractLabel, gbu.gbc(5, 0, 0, 0));
        form.add(abstractScrollPane, gbu.gbc(5, 0, 0, 0));

        form.add(keywords, gbu.gbc(5, 0, 0, 0));
        form.add(keywordsField, gbu.gbc(5, 0, 0, 0));

        form.add(contentLabel, gbu.gbc(5, 0, 0, 0));
        form.add(contentScrollPane, gbu.gbc(5, 0, 0, 0));

        form.add(createButton, gbu.gbc(5, 0, 0, 0));

        JScrollPane pageScrollPane = new JScrollPane(form);
        pageScrollPane.getVerticalScrollBar().setUnitIncrement(16);

        add(homeButton, BorderLayout.NORTH);
        add(pageScrollPane, BorderLayout.CENTER);
    }

    private void initListeners() {
        homeButton.addActionListener(e -> frame.navigateTo("home"));
        createButton.addActionListener(e -> createJournal());
    }

    private void createJournal() {
        String title = titleField.getText().trim();
        String abstractText = abstractField.getText().trim();
        String keywords = keywordsField.getText().trim();
        String content = contentField.getText().trim();

        try {
            journalController.createJournal(title, abstractText, keywords, content);
            JOptionPane.showMessageDialog(this, "Journal created successfully!", "Success",
                    JOptionPane.INFORMATION_MESSAGE);
            resetForm();
            frame.navigateTo("home");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error creating journal: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
            statusLabel.setText("Error creating journal: " + e.getMessage());
            statusLabel.setForeground(Color.RED);
            return;
        }
    }

    private void resetForm() {
        titleField.setText("");
        abstractField.setText("");
        keywordsField.setText("");
        contentField.setText("");

        statusLabel.setText(" ");
        statusLabel.setForeground(Color.GRAY);

        titleField.requestFocusInWindow();
    }

    private Border inputBorder(Border originalBorder) {
        return BorderFactory.createCompoundBorder(originalBorder, BorderFactory.createEmptyBorder(5, 10, 5, 10));
    }
}