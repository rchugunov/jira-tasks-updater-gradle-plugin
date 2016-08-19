package ru.rambler.jiratasksupdater.jirarest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class JiraIssue {

    @SerializedName("update")
    @Expose
    private Update update;

    @SerializedName("transition")
    @Expose
    private Transition transition;

    public JiraIssue() {
    }

    public JiraIssue(Update update, Transition transition) {
        this.update = update;
        this.transition = transition;
    }

    public Update getUpdate() {
        return update;
    }

    public void setUpdate(Update update) {
        this.update = update;
    }

    public Transition getTransition() {
        return transition;
    }

    public void setTransition(Transition transition) {
        this.transition = transition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        JiraIssue jiraIssue = (JiraIssue) o;

        return new EqualsBuilder()
                .append(update, jiraIssue.update)
                .append(transition, jiraIssue.transition)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(update)
                .append(transition)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("fields", update)
                .append("transition", transition)
                .toString();
    }

    @Generated("org.jsonschema2pojo")
    public static class Update {
        private List<FixVersions> fixVersions;

        public Update() {
        }

        public Update(List<FixVersions> fixVersions) {
            this.fixVersions = fixVersions;
        }

        public List<FixVersions> getFixVersions() {
            return fixVersions;
        }

        public void setFixVersions(List<FixVersions> fixVersions) {
            this.fixVersions = fixVersions;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;

            if (o == null || getClass() != o.getClass()) return false;

            Update fields = (Update) o;

            return new EqualsBuilder()
                    .append(fixVersions, fields.fixVersions)
                    .isEquals();
        }

        @Override
        public int hashCode() {
            return new HashCodeBuilder(17, 37)
                    .append(fixVersions)
                    .toHashCode();
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this)
                    .append("fixVersions", fixVersions)
                    .toString();
        }
    }

    @Generated("org.jsonschema2pojo")
    public static class FixVersions {
        private List<FixedVersion> set;

        public FixVersions() {
        }

        public FixVersions(List<FixedVersion> set) {
            this.set = set;
        }

        public List<FixedVersion> getSet() {
            return set;
        }

        public void setSet(List<FixedVersion> set) {
            this.set = set;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;

            if (o == null || getClass() != o.getClass()) return false;

            FixVersions that = (FixVersions) o;

            return new EqualsBuilder()
                    .append(set, that.set)
                    .isEquals();
        }

        @Override
        public int hashCode() {
            return new HashCodeBuilder(17, 37)
                    .append(set)
                    .toHashCode();
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this)
                    .append("set", set)
                    .toString();
        }
    }

    @Generated("org.jsonschema2pojo")
    public static class FixedVersion {
        private String name;

        public FixedVersion() {
        }

        public FixedVersion(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;

            if (o == null || getClass() != o.getClass()) return false;

            FixedVersion that = (FixedVersion) o;

            return new EqualsBuilder()
                    .append(name, that.name)
                    .isEquals();
        }

        @Override
        public int hashCode() {
            return new HashCodeBuilder(17, 37)
                    .append(name)
                    .toHashCode();
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this)
                    .append("name", name)
                    .toString();
        }
    }

    @Generated("org.jsonschema2pojo")
    public static class Transition {
        private String id;

        public Transition() {
        }

        public Transition(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;

            if (o == null || getClass() != o.getClass()) return false;

            Transition that = (Transition) o;

            return new EqualsBuilder()
                    .append(id, that.id)
                    .isEquals();
        }

        @Override
        public int hashCode() {
            return new HashCodeBuilder(17, 37)
                    .append(id)
                    .toHashCode();
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this)
                    .append("id", id)
                    .toString();
        }
    }
}