package services;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import model.Journal;
import util.FileUtil;

public class JournalServices {
    private static final String JOURNAL_DATA_PATH = "data/journals.json";
    private Gson gson = new Gson();

    public List<Journal> getJournals() {
        String json = FileUtil.readFile(JOURNAL_DATA_PATH);

        if (json == null || json.isBlank()) {
            return new ArrayList<>();
        }

        Journal[] journals = gson.fromJson(json, Journal[].class);
        return journals == null ? new ArrayList<>() : new ArrayList<>(List.of(journals));
    }

    public boolean saveJournal(Journal journal) {
        List<Journal> journals = getJournals();
        journals.add(journal);
        String json = gson.toJson(journals);
        FileUtil.writeFile(JOURNAL_DATA_PATH, json);
        return true;
    }

}
