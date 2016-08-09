package ru.rambler.jiratasksupdater;


import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class JiraTasksUpdaterPlugin implements Plugin<Project> {

    private final static String JIRA_TASKS_UPDATER_PLUGIN = "jiraTasksUpdater";
    private final static String JIRA_TASKS_UPDATER_TASK = "updateJiraTasks";

    @Override
    public void apply(Project project) {
        project.getExtensions().create(JIRA_TASKS_UPDATER_PLUGIN, JiraTasksUpdaterExtension.class);

        createTask(project);

        for (Project p : project.getSubprojects()) {
            createTask(p);
        }
    }

    private void createTask(Project p) {
        JiraIssuesUpdaterTask androidAnalyticsTask = p
                .getTasks()
                .create(JIRA_TASKS_UPDATER_TASK, JiraIssuesUpdaterTask.class);

//        androidAnalyticsTask.setDescription("Retrieves " + p.getName() + " analytics.");
    }
}
