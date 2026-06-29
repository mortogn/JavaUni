package controller;

import java.util.List;

import model.Journal;
import model.User;
import services.JournalServices;

public class JournalController {
    private JournalServices journalServices;

    public JournalController() {
        this.journalServices = new JournalServices();
    }

    public void createJournal(String title, String abstractText, String keywords, String content) {

        User currentUser = Session.getCurrentUser();

        if (currentUser == null) {
            throw new IllegalStateException("No user is currently logged in.");
        }

        String userEmail = currentUser.getEmail();

        Journal journal = new Journal(title, abstractText, keywords, content, userEmail);
        journalServices.saveJournal(journal);
    }

    public List<Journal> getJournals() {
        return journalServices.getJournals();
    }
}
