package ru.rambler.jiratasksupdater;


public class JiraTasksUpdaterExtension {
    private String jiraEndpoint;
    private String username;
    private String password;
    private String projectId;
    private String jiraReleaseVersionName;
    private String currentStatus;
    private String statusForTest;
    private boolean findSecondTag;

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

    public String getJiraReleaseVersionName() {
        return jiraReleaseVersionName;
    }

    public void setJiraReleaseVersionName(String jiraReleaseVersionName) {
        this.jiraReleaseVersionName = jiraReleaseVersionName;
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

    public boolean isFindSecondTag() {
        return findSecondTag;
    }

    public void setFindSecondTag(boolean findSecondTag) {
        this.findSecondTag = findSecondTag;
    }
}
