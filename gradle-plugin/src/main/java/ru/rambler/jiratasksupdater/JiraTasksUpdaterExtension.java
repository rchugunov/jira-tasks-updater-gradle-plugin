package ru.rambler.jiratasksupdater;


public class JiraTasksUpdaterExtension {
    private String jiraEndpoint;
    private String username;
    private String password;
    private String projectId;
    private String branch;
    private String jiraVersionName;
    private String stage;
    private String currentStatus;
    private String statusForTest;

    public String getJiraEndpoint() {
        return jiraEndpoint;
    }

    public void setJiraEndpoint(String jiraEndpoint) {
        this.jiraEndpoint = jiraEndpoint;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getJiraVersionName() {
        return jiraVersionName;
    }

    public void setJiraVersionName(String jiraVersionName) {
        this.jiraVersionName = jiraVersionName;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public String getStatusForTest() {
        return statusForTest;
    }

    public void setStatusForTest(String statusForTest) {
        this.statusForTest = statusForTest;
    }
}
