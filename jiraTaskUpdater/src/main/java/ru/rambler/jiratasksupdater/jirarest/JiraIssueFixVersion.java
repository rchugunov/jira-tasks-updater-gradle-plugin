

package ru.rambler.jiratasksupdater.jirarest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class JiraIssueFixVersion {

    @SerializedName("self")
    @Expose
    private String self;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("archived")
    @Expose
    private boolean archived;
    @SerializedName("released")
    @Expose
    private boolean released;
    @SerializedName("releaseDate")
    @Expose
    private String releaseDate;
    @SerializedName("overdue")
    @Expose
    private boolean overdue;
    @SerializedName("userReleaseDate")
    @Expose
    private String userReleaseDate;
    @SerializedName("projectId")
    @Expose
    private int projectId;

    /**
     * No args constructor for use in serialization
     */
    public JiraIssueFixVersion() {
    }

    /**
     * @param released
     * @param id
     * @param releaseDate
     * @param archived
     * @param overdue
     * @param name
     * @param userReleaseDate
     * @param self
     * @param projectId
     */
    public JiraIssueFixVersion(String self, String id, String name, boolean archived, boolean released, String releaseDate, boolean overdue, String userReleaseDate, int projectId) {
        this.self = self;
        this.id = id;
        this.name = name;
        this.archived = archived;
        this.released = released;
        this.releaseDate = releaseDate;
        this.overdue = overdue;
        this.userReleaseDate = userReleaseDate;
        this.projectId = projectId;
    }

    /**
     * @return The self
     */
    public String getSelf() {
        return self;
    }

    /**
     * @param self The self
     */
    public void setSelf(String self) {
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
    public boolean isArchived() {
        return archived;
    }

    /**
     * @param archived The archived
     */
    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    /**
     * @return The released
     */
    public boolean isReleased() {
        return released;
    }

    /**
     * @param released The released
     */
    public void setReleased(boolean released) {
        this.released = released;
    }

    /**
     * @return The releaseDate
     */
    public String getReleaseDate() {
        return releaseDate;
    }

    /**
     * @param releaseDate The releaseDate
     */
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    /**
     * @return The overdue
     */
    public boolean isOverdue() {
        return overdue;
    }

    /**
     * @param overdue The overdue
     */
    public void setOverdue(boolean overdue) {
        this.overdue = overdue;
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
     * @return The projectId
     */
    public int getProjectId() {
        return projectId;
    }

    /**
     * @param projectId The projectId
     */
    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(self).append(id).append(name).append(archived).append(released).append(releaseDate).append(overdue).append(userReleaseDate).append(projectId).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof JiraIssueFixVersion) == false) {
            return false;
        }
        JiraIssueFixVersion rhs = ((JiraIssueFixVersion) other);
        return new EqualsBuilder().append(self, rhs.self).append(id, rhs.id).append(name, rhs.name).append(archived, rhs.archived).append(released, rhs.released).append(releaseDate, rhs.releaseDate).append(overdue, rhs.overdue).append(userReleaseDate, rhs.userReleaseDate).append(projectId, rhs.projectId).isEquals();
    }

}
