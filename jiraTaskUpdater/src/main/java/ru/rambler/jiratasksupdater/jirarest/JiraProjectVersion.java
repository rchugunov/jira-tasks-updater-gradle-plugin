package ru.rambler.jiratasksupdater.jirarest;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class JiraProjectVersion {
    @SerializedName("expand")
    @Expose
    private String expand;
    @SerializedName("self")
    @Expose
    private URI self;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("archived")
    @Expose
    private Boolean archived;
    @SerializedName("released")
    @Expose
    private Boolean released;
    @SerializedName("overdue")
    @Expose
    private Boolean overdue;
    @SerializedName("userStartDate")
    @Expose
    private String userStartDate;
    @SerializedName("userReleaseDate")
    @Expose
    private String userReleaseDate;
    @SerializedName("project")
    @Expose
    private String project;
    @SerializedName("projectId")
    @Expose
    private Integer projectId;
    @SerializedName("moveUnfixedIssuesTo")
    @Expose
    private URI moveUnfixedIssuesTo;
    @SerializedName("operations")
    @Expose
    private List<Operation> operations = new ArrayList<Operation>();
    @SerializedName("remotelinks")
    @Expose
    private List<Remotelink> remotelinks = new ArrayList<Remotelink>();

    /**
     * @return The expand
     */
    public String getExpand() {
        return expand;
    }

    /**
     * @param expand The expand
     */
    public void setExpand(String expand) {
        this.expand = expand;
    }

    /**
     * @return The self
     */
    public URI getSelf() {
        return self;
    }

    /**
     * @param self The self
     */
    public void setSelf(URI self) {
        this.self = self;
    }

    /**
     * @return The id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return The description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return The archived
     */
    public Boolean getArchived() {
        return archived;
    }

    /**
     * @param archived The archived
     */
    public void setArchived(Boolean archived) {
        this.archived = archived;
    }

    /**
     * @return The released
     */
    public Boolean getReleased() {
        return released;
    }

    /**
     * @param released The released
     */
    public void setReleased(Boolean released) {
        this.released = released;
    }

    /**
     * @return The overdue
     */
    public Boolean getOverdue() {
        return overdue;
    }

    /**
     * @param overdue The overdue
     */
    public void setOverdue(Boolean overdue) {
        this.overdue = overdue;
    }

    /**
     * @return The userStartDate
     */
    public String getUserStartDate() {
        return userStartDate;
    }

    /**
     * @param userStartDate The userStartDate
     */
    public void setUserStartDate(String userStartDate) {
        this.userStartDate = userStartDate;
    }

    /**
     * @return The userReleaseDate
     */
    public String getUserReleaseDate() {
        return userReleaseDate;
    }

    /**
     * @param userReleaseDate The userReleaseDate
     */
    public void setUserReleaseDate(String userReleaseDate) {
        this.userReleaseDate = userReleaseDate;
    }

    /**
     * @return The project
     */
    public String getProject() {
        return project;
    }

    /**
     * @param project The project
     */
    public void setProject(String project) {
        this.project = project;
    }

    /**
     * @return The projectId
     */
    public Integer getProjectId() {
        return projectId;
    }

    /**
     * @param projectId The projectId
     */
    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    /**
     * @return The moveUnfixedIssuesTo
     */
    public URI getMoveUnfixedIssuesTo() {
        return moveUnfixedIssuesTo;
    }

    /**
     * @param moveUnfixedIssuesTo The moveUnfixedIssuesTo
     */
    public void setMoveUnfixedIssuesTo(URI moveUnfixedIssuesTo) {
        this.moveUnfixedIssuesTo = moveUnfixedIssuesTo;
    }

    /**
     * @return The operations
     */
    public List<Operation> getOperations() {
        return operations;
    }

    /**
     * @param operations The operations
     */
    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }

    /**
     * @return The remotelinks
     */
    public List<Remotelink> getRemotelinks() {
        return remotelinks;
    }

    /**
     * @param remotelinks The remotelinks
     */
    public void setRemotelinks(List<Remotelink> remotelinks) {
        this.remotelinks = remotelinks;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JiraProjectVersion response = (JiraProjectVersion) o;

        if (expand != null ? !expand.equals(response.expand) : response.expand != null)
            return false;
        if (self != null ? !self.equals(response.self) : response.self != null) return false;
        if (id != null ? !id.equals(response.id) : response.id != null) return false;
        if (description != null ? !description.equals(response.description) : response.description != null)
            return false;
        if (name != null ? !name.equals(response.name) : response.name != null) return false;
        if (archived != null ? !archived.equals(response.archived) : response.archived != null)
            return false;
        if (released != null ? !released.equals(response.released) : response.released != null)
            return false;
        if (overdue != null ? !overdue.equals(response.overdue) : response.overdue != null)
            return false;
        if (userStartDate != null ? !userStartDate.equals(response.userStartDate) : response.userStartDate != null)
            return false;
        if (userReleaseDate != null ? !userReleaseDate.equals(response.userReleaseDate) : response.userReleaseDate != null)
            return false;
        if (project != null ? !project.equals(response.project) : response.project != null)
            return false;
        if (projectId != null ? !projectId.equals(response.projectId) : response.projectId != null)
            return false;
        if (moveUnfixedIssuesTo != null ? !moveUnfixedIssuesTo.equals(response.moveUnfixedIssuesTo) : response.moveUnfixedIssuesTo != null)
            return false;
        if (operations != null ? !operations.equals(response.operations) : response.operations != null)
            return false;
        return remotelinks != null ? remotelinks.equals(response.remotelinks) : response.remotelinks == null;

    }

    @Override
    public int hashCode() {
        int result = expand != null ? expand.hashCode() : 0;
        result = 31 * result + (self != null ? self.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (archived != null ? archived.hashCode() : 0);
        result = 31 * result + (released != null ? released.hashCode() : 0);
        result = 31 * result + (overdue != null ? overdue.hashCode() : 0);
        result = 31 * result + (userStartDate != null ? userStartDate.hashCode() : 0);
        result = 31 * result + (userReleaseDate != null ? userReleaseDate.hashCode() : 0);
        result = 31 * result + (project != null ? project.hashCode() : 0);
        result = 31 * result + (projectId != null ? projectId.hashCode() : 0);
        result = 31 * result + (moveUnfixedIssuesTo != null ? moveUnfixedIssuesTo.hashCode() : 0);
        result = 31 * result + (operations != null ? operations.hashCode() : 0);
        result = 31 * result + (remotelinks != null ? remotelinks.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "JiraProjectVersion{" +
                "expand='" + expand + '\'' +
                ", self=" + self +
                ", id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", archived=" + archived +
                ", released=" + released +
                ", overdue=" + overdue +
                ", userStartDate='" + userStartDate + '\'' +
                ", userReleaseDate='" + userReleaseDate + '\'' +
                ", project='" + project + '\'' +
                ", projectId=" + projectId +
                ", moveUnfixedIssuesTo=" + moveUnfixedIssuesTo +
                ", operations=" + operations +
                ", remotelinks=" + remotelinks +
                '}';
    }
}