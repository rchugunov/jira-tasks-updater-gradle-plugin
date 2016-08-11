package ru.rambler.jiratasksupdater.jirarest;


public class JiraFixedVersionRequest {
    private JiraIssue.Update update;

    public JiraIssue.Update getUpdate() {
        return update;
    }

    public void setUpdate(JiraIssue.Update update) {
        this.update = update;
    }
}
