package model;

public class Journal {
    private String title;
    private String abstractText;
    private String keywords;
    private String content;
    private String userEmail;

    public Journal(String title, String abstractText, String keywords, String content, String userEmail) {
        this.title = title;
        this.abstractText = abstractText;
        this.keywords = keywords;
        this.content = content;
        this.userEmail = userEmail;
    }

    public String getTitle() {
        return title;
    }

    public String getAbstractText() {
        return abstractText;
    }

    public String getKeywords() {
        return keywords;
    }

    public String getContent() {
        return content;
    }

    public String getUserEmail() {
        return userEmail;
    }
}
