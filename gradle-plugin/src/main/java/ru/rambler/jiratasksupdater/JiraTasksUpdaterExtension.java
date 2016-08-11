package ru.rambler.jiratasksupdater;


public class JiraTasksUpdaterExtension {
    private String jiraEndpoint;
    private String username;
    private String password;
    private String projectId;
    private String branch;

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

    public String getStage() {
        return null;
    }
}
