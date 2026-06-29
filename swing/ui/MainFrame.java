package ui;

import javax.swing.*;
import java.awt.*;

import model.Journal;
import pages.*;

public class MainFrame extends JFrame {

    private CardLayout cardLayout;
    private JPanel mainPanel;
    private HomePage homePage;
    private JournalDetailPage journalDetailPage;

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
        journalDetailPage = new JournalDetailPage(this);

        CreateJournalPage createJournalPage = new CreateJournalPage(this);

        mainPanel.add(loginPage, "login");
        mainPanel.add(registerPage, "register");
        mainPanel.add(homePage, "home");
        mainPanel.add(createJournalPage, "createJournal");
        mainPanel.add(journalDetailPage, "journalDetail");

        navigateTo("home");

        add(mainPanel);

    }

    public void navigateTo(String page) {
        if ("home".equals(page)) {
            homePage.refreshSessionUI();
        }

        cardLayout.show(mainPanel, page);
    }

    public void navigateToJournalDetail(Journal journal) {
        journalDetailPage.setJournal(journal);
        navigateTo("journalDetail");
    }

}
