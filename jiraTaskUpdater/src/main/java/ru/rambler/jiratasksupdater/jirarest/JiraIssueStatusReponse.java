package ru.rambler.jiratasksupdater.jirarest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.List;

import javax.annotation.Generated;

public class JiraIssueStatusReponse {
    private Fields fields;
    private List<Fields.JiraIssueTransitionStatus> transitions;

    public List<Fields.JiraIssueTransitionStatus> getTransitions() {
        return transitions;
    }

    public void setTransitions(List<Fields.JiraIssueTransitionStatus> transitions) {
        this.transitions = transitions;
    }

    public Fields getFields() {
        return fields;
    }

    public void setFields(Fields fields) {
        this.fields = fields;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("fields", fields)
                .append("transitions", transitions)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        JiraIssueStatusReponse that = (JiraIssueStatusReponse) o;

        return new EqualsBuilder()
                .append(fields, that.fields)
                .append(transitions, that.transitions)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(fields)
                .append(transitions)
                .toHashCode();
    }

    public static class Fields {
        private JiraIssueTransitionStatus status;

        public JiraIssueTransitionStatus getStatus() {
            return status;
        }

        public void setStatus(JiraIssueTransitionStatus status) {
            this.status = status;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;

            if (o == null || getClass() != o.getClass()) return false;

            Fields fields = (Fields) o;

            return new EqualsBuilder()
                    .append(status, fields.status)
                    .isEquals();
        }

        @Override
        public int hashCode() {
            return new HashCodeBuilder(17, 37)
                    .append(status)
                    .toHashCode();
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this)
                    .append("status", status)
                    .toString();
        }

        @Generated("org.jsonschema2pojo")
        public static class JiraIssueTransitionStatus {

            @SerializedName("id")
            @Expose
            private String id;
            @SerializedName("name")
            @Expose
            private String name;
            @SerializedName("to")
            @Expose
            private To to;

            /**
             * No args constructor for use in serialization
             */
            public JiraIssueTransitionStatus() {
            }

            /**
             * @param to
             * @param id
             * @param name
             */
            public JiraIssueTransitionStatus(String id, String name, To to) {
                this.id = id;
                this.name = name;
                this.to = to;
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
             * @return The to
             */
            public To getTo() {
                return to;
            }

            /**
             * @param to The to
             */
            public void setTo(To to) {
                this.to = to;
            }

            @Override
            public String toString() {
                return ToStringBuilder.reflectionToString(this);
            }

            @Override
            public int hashCode() {
                return new HashCodeBuilder().append(id).append(name).append(to).toHashCode();
            }

            @Override
            public boolean equals(Object other) {
                if (other == this) {
                    return true;
                }
                if ((other instanceof JiraIssueTransitionStatus) == false) {
                    return false;
                }
                JiraIssueTransitionStatus rhs = ((JiraIssueTransitionStatus) other);
                return new EqualsBuilder().append(id, rhs.id).append(name, rhs.name).append(to, rhs.to).isEquals();
            }

            @Generated("org.jsonschema2pojo")
            public static class StatusCategory {

                @SerializedName("self")
                @Expose
                private String self;
                @SerializedName("id")
                @Expose
                private int id;
                @SerializedName("key")
                @Expose
                private String key;
                @SerializedName("colorName")
                @Expose
                private String colorName;
                @SerializedName("name")
                @Expose
                private String name;

                /**
                 * No args constructor for use in serialization
                 */
                public StatusCategory() {
                }

                /**
                 * @param id
                 * @param colorName
                 * @param name
                 * @param self
                 * @param key
                 */
                public StatusCategory(String self, int id, String key, String colorName, String name) {
                    this.self = self;
                    this.id = id;
                    this.key = key;
                    this.colorName = colorName;
                    this.name = name;
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
                public int getId() {
                    return id;
                }

                /**
                 * @param id The id
                 */
                public void setId(int id) {
                    this.id = id;
                }

                /**
                 * @return The key
                 */
                public String getKey() {
                    return key;
                }

                /**
                 * @param key The key
                 */
                public void setKey(String key) {
                    this.key = key;
                }

                /**
                 * @return The colorName
                 */
                public String getColorName() {
                    return colorName;
                }

                /**
                 * @param colorName The colorName
                 */
                public void setColorName(String colorName) {
                    this.colorName = colorName;
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

                @Override
                public String toString() {
                    return ToStringBuilder.reflectionToString(this);
                }

                @Override
                public int hashCode() {
                    return new HashCodeBuilder().append(self).append(id).append(key).append(colorName).append(name).toHashCode();
                }

                @Override
                public boolean equals(Object other) {
                    if (other == this) {
                        return true;
                    }
                    if ((other instanceof StatusCategory) == false) {
                        return false;
                    }
                    StatusCategory rhs = ((StatusCategory) other);
                    return new EqualsBuilder().append(self, rhs.self).append(id, rhs.id).append(key, rhs.key).append(colorName, rhs.colorName).append(name, rhs.name).isEquals();
                }

            }

            @Generated("org.jsonschema2pojo")
            public static class To {

                @SerializedName("self")
                @Expose
                private String self;
                @SerializedName("description")
                @Expose
                private String description;
                @SerializedName("iconUrl")
                @Expose
                private String iconUrl;
                @SerializedName("name")
                @Expose
                private String name;
                @SerializedName("id")
                @Expose
                private String id;
                @SerializedName("statusCategory")
                @Expose
                private StatusCategory statusCategory;

                /**
                 * No args constructor for use in serialization
                 */
                public To() {
                }

                /**
                 * @param id
                 * @param description
                 * @param name
                 * @param iconUrl
                 * @param statusCategory
                 * @param self
                 */
                public To(String self, String description, String iconUrl, String name, String id, StatusCategory statusCategory) {
                    this.self = self;
                    this.description = description;
                    this.iconUrl = iconUrl;
                    this.name = name;
                    this.id = id;
                    this.statusCategory = statusCategory;
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
                 * @return The iconUrl
                 */
                public String getIconUrl() {
                    return iconUrl;
                }

                /**
                 * @param iconUrl The iconUrl
                 */
                public void setIconUrl(String iconUrl) {
                    this.iconUrl = iconUrl;
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
                 * @return The statusCategory
                 */
                public StatusCategory getStatusCategory() {
                    return statusCategory;
                }

                /**
                 * @param statusCategory The statusCategory
                 */
                public void setStatusCategory(StatusCategory statusCategory) {
                    this.statusCategory = statusCategory;
                }

                @Override
                public String toString() {
                    return ToStringBuilder.reflectionToString(this);
                }

                @Override
                public int hashCode() {
                    return new HashCodeBuilder().append(self).append(description).append(iconUrl).append(name).append(id).append(statusCategory).toHashCode();
                }

                @Override
                public boolean equals(Object other) {
                    if (other == this) {
                        return true;
                    }
                    if ((other instanceof To) == false) {
                        return false;
                    }
                    To rhs = ((To) other);
                    return new EqualsBuilder().append(self, rhs.self).append(description, rhs.description).append(iconUrl, rhs.iconUrl).append(name, rhs.name).append(id, rhs.id).append(statusCategory, rhs.statusCategory).isEquals();
                }

            }
        }
    }
}
