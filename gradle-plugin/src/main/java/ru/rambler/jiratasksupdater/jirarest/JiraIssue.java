package ru.rambler.jiratasksupdater.jirarest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class JiraIssue {

    @SerializedName("update")
    @Expose
    private Update update;
    @SerializedName("fields")
    @Expose
    private Fields fields;
    @SerializedName("historyMetadata")
    @Expose
    private HistoryMetadata historyMetadata;
    @SerializedName("properties")
    @Expose
    private List<Property> properties = new ArrayList<Property>();

    /**
     * @return The update
     */
    public Update getUpdate() {
        return update;
    }

    /**
     * @param update The update
     */
    public void setUpdate(Update update) {
        this.update = update;
    }

    /**
     * @return The fields
     */
    public Fields getFields() {
        return fields;
    }

    /**
     * @param fields The fields
     */
    public void setFields(Fields fields) {
        this.fields = fields;
    }

    /**
     * @return The historyMetadata
     */
    public HistoryMetadata getHistoryMetadata() {
        return historyMetadata;
    }

    /**
     * @param historyMetadata The historyMetadata
     */
    public void setHistoryMetadata(HistoryMetadata historyMetadata) {
        this.historyMetadata = historyMetadata;
    }

    /**
     * @return The properties
     */
    public List<Property> getProperties() {
        return properties;
    }

    /**
     * @param properties The properties
     */
    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }

    @Generated("org.jsonschema2pojo")
    public static class Update {

        @SerializedName("summary")
        @Expose
        private List<Summary> summary;
        @SerializedName("components")
        @Expose
        private List<Component> components;
        @SerializedName("timetracking")
        @Expose
        private List<Timetracking> timetracking;
        @SerializedName("labels")
        @Expose
        private List<Label> labels;
        @SerializedName("fixVersions")
        @Expose
        private FixVersions fixVersions;

        /**
         * @return The summary
         */
        public List<Summary> getSummary() {
            return summary;
        }

        /**
         * @param summary The summary
         */
        public void setSummary(List<Summary> summary) {
            this.summary = summary;
        }

        /**
         * @return The components
         */
        public List<Component> getComponents() {
            return components;
        }

        /**
         * @param components The components
         */
        public void setComponents(List<Component> components) {
            this.components = components;
        }

        public FixVersions getFixVersions() {
            return fixVersions;
        }

        public void setFixVersions(FixVersions fixVersions) {
            this.fixVersions = fixVersions;
        }

        /**
         * @return The timetracking
         */
        public List<Timetracking> getTimetracking() {
            return timetracking;
        }

        /**
         * @param timetracking The timetracking
         */
        public void setTimetracking(List<Timetracking> timetracking) {
            this.timetracking = timetracking;
        }

        /**
         * @return The labels
         */
        public List<Label> getLabels() {
            return labels;
        }

        /**
         * @param labels The labels
         */
        public void setLabels(List<Label> labels) {
            this.labels = labels;
        }

        public static class FixVersions {
            private JiraIssueFixVersion set;

            public FixVersions() {
            }

            public FixVersions(JiraIssueFixVersion set) {
                this.set = set;
            }

            public JiraIssueFixVersion getSet() {
                return set;
            }

            public void setSet(JiraIssueFixVersion set) {
                this.set = set;
            }
        }

    }

    @Generated("org.jsonschema2pojo")
    public class Actor {

        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("displayName")
        @Expose
        private String displayName;
        @SerializedName("type")
        @Expose
        private String type;
        @SerializedName("avatarUrl")
        @Expose
        private String avatarUrl;
        @SerializedName("url")
        @Expose
        private String url;

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
         * @return The displayName
         */
        public String getDisplayName() {
            return displayName;
        }

        /**
         * @param displayName The displayName
         */
        public void setDisplayName(String displayName) {
            this.displayName = displayName;
        }

        /**
         * @return The type
         */
        public String getType() {
            return type;
        }

        /**
         * @param type The type
         */
        public void setType(String type) {
            this.type = type;
        }

        /**
         * @return The avatarUrl
         */
        public String getAvatarUrl() {
            return avatarUrl;
        }

        /**
         * @param avatarUrl The avatarUrl
         */
        public void setAvatarUrl(String avatarUrl) {
            this.avatarUrl = avatarUrl;
        }

        /**
         * @return The url
         */
        public String getUrl() {
            return url;
        }

        /**
         * @param url The url
         */
        public void setUrl(String url) {
            this.url = url;
        }
    }

    @Generated("org.jsonschema2pojo")
    public class Cause {

        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("type")
        @Expose
        private String type;

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
         * @return The type
         */
        public String getType() {
            return type;
        }

        /**
         * @param type The type
         */
        public void setType(String type) {
            this.type = type;
        }

    }

    @Generated("org.jsonschema2pojo")
    public class Component {

        @SerializedName("set")
        @Expose
        private String set;

        /**
         * @return The set
         */
        public String getSet() {
            return set;
        }

        /**
         * @param set The set
         */
        public void setSet(String set) {
            this.set = set;
        }

    }

    @Generated("org.jsonschema2pojo")
    public class Edit {

        @SerializedName("originalEstimate")
        @Expose
        private String originalEstimate;
        @SerializedName("remainingEstimate")
        @Expose
        private String remainingEstimate;

        /**
         * @return The originalEstimate
         */
        public String getOriginalEstimate() {
            return originalEstimate;
        }

        /**
         * @param originalEstimate The originalEstimate
         */
        public void setOriginalEstimate(String originalEstimate) {
            this.originalEstimate = originalEstimate;
        }

        /**
         * @return The remainingEstimate
         */
        public String getRemainingEstimate() {
            return remainingEstimate;
        }

        /**
         * @param remainingEstimate The remainingEstimate
         */
        public void setRemainingEstimate(String remainingEstimate) {
            this.remainingEstimate = remainingEstimate;
        }

    }

    @Generated("org.jsonschema2pojo")
    public class ExtraData {

        @SerializedName("keyvalue")
        @Expose
        private String keyvalue;
        @SerializedName("goes")
        @Expose
        private String goes;

        /**
         * @return The keyvalue
         */
        public String getKeyvalue() {
            return keyvalue;
        }

        /**
         * @param keyvalue The keyvalue
         */
        public void setKeyvalue(String keyvalue) {
            this.keyvalue = keyvalue;
        }

        /**
         * @return The goes
         */
        public String getGoes() {
            return goes;
        }

        /**
         * @param goes The goes
         */
        public void setGoes(String goes) {
            this.goes = goes;
        }

    }

    @Generated("org.jsonschema2pojo")
    public class Fields {

        @SerializedName("summary")
        @Expose
        private String summary;
        @SerializedName("customfield_10010")
        @Expose
        private Integer customfield10010;
        @SerializedName("customfield_10000")
        @Expose
        private String customfield10000;

        /**
         * @return The summary
         */
        public String getSummary() {
            return summary;
        }

        /**
         * @param summary The summary
         */
        public void setSummary(String summary) {
            this.summary = summary;
        }

        /**
         * @return The customfield10010
         */
        public Integer getCustomfield10010() {
            return customfield10010;
        }

        /**
         * @param customfield10010 The customfield_10010
         */
        public void setCustomfield10010(Integer customfield10010) {
            this.customfield10010 = customfield10010;
        }

        /**
         * @return The customfield10000
         */
        public String getCustomfield10000() {
            return customfield10000;
        }

        /**
         * @param customfield10000 The customfield_10000
         */
        public void setCustomfield10000(String customfield10000) {
            this.customfield10000 = customfield10000;
        }

    }

    @Generated("org.jsonschema2pojo")
    public class Generator {

        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("type")
        @Expose
        private String type;

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
         * @return The type
         */
        public String getType() {
            return type;
        }

        /**
         * @param type The type
         */
        public void setType(String type) {
            this.type = type;
        }

    }

    @Generated("org.jsonschema2pojo")
    public class HistoryMetadata {

        @SerializedName("type")
        @Expose
        private String type;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("descriptionKey")
        @Expose
        private String descriptionKey;
        @SerializedName("activityDescription")
        @Expose
        private String activityDescription;
        @SerializedName("activityDescriptionKey")
        @Expose
        private String activityDescriptionKey;
        @SerializedName("actor")
        @Expose
        private Actor actor;
        @SerializedName("generator")
        @Expose
        private Generator generator;
        @SerializedName("cause")
        @Expose
        private Cause cause;
        @SerializedName("extraData")
        @Expose
        private ExtraData extraData;

        /**
         * @return The type
         */
        public String getType() {
            return type;
        }

        /**
         * @param type The type
         */
        public void setType(String type) {
            this.type = type;
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
         * @return The descriptionKey
         */
        public String getDescriptionKey() {
            return descriptionKey;
        }

        /**
         * @param descriptionKey The descriptionKey
         */
        public void setDescriptionKey(String descriptionKey) {
            this.descriptionKey = descriptionKey;
        }

        /**
         * @return The activityDescription
         */
        public String getActivityDescription() {
            return activityDescription;
        }

        /**
         * @param activityDescription The activityDescription
         */
        public void setActivityDescription(String activityDescription) {
            this.activityDescription = activityDescription;
        }

        /**
         * @return The activityDescriptionKey
         */
        public String getActivityDescriptionKey() {
            return activityDescriptionKey;
        }

        /**
         * @param activityDescriptionKey The activityDescriptionKey
         */
        public void setActivityDescriptionKey(String activityDescriptionKey) {
            this.activityDescriptionKey = activityDescriptionKey;
        }

        /**
         * @return The actor
         */
        public Actor getActor() {
            return actor;
        }

        /**
         * @param actor The actor
         */
        public void setActor(Actor actor) {
            this.actor = actor;
        }

        /**
         * @return The generator
         */
        public Generator getGenerator() {
            return generator;
        }

        /**
         * @param generator The generator
         */
        public void setGenerator(Generator generator) {
            this.generator = generator;
        }

        /**
         * @return The cause
         */
        public Cause getCause() {
            return cause;
        }

        /**
         * @param cause The cause
         */
        public void setCause(Cause cause) {
            this.cause = cause;
        }

        /**
         * @return The extraData
         */
        public ExtraData getExtraData() {
            return extraData;
        }

        /**
         * @param extraData The extraData
         */
        public void setExtraData(ExtraData extraData) {
            this.extraData = extraData;
        }

    }

    @Generated("org.jsonschema2pojo")
    public class Label {

        @SerializedName("add")
        @Expose
        private String add;
        @SerializedName("remove")
        @Expose
        private String remove;

        /**
         * @return The add
         */
        public String getAdd() {
            return add;
        }

        /**
         * @param add The add
         */
        public void setAdd(String add) {
            this.add = add;
        }

        /**
         * @return The remove
         */
        public String getRemove() {
            return remove;
        }

        /**
         * @param remove The remove
         */
        public void setRemove(String remove) {
            this.remove = remove;
        }

    }

    @Generated("org.jsonschema2pojo")
    public class Property {

        @SerializedName("key")
        @Expose
        private String key;
        @SerializedName("value")
        @Expose
        private String value;

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
         * @return The value
         */
        public String getValue() {
            return value;
        }

        /**
         * @param value The value
         */
        public void setValue(String value) {
            this.value = value;
        }

    }

    @Generated("org.jsonschema2pojo")
    public class Summary {

        @SerializedName("set")
        @Expose
        private String set;

        /**
         * @return The set
         */
        public String getSet() {
            return set;
        }

        /**
         * @param set The set
         */
        public void setSet(String set) {
            this.set = set;
        }

    }

    @Generated("org.jsonschema2pojo")
    public class Timetracking {

        @SerializedName("edit")
        @Expose
        private Edit edit;

        /**
         * @return The edit
         */
        public Edit getEdit() {
            return edit;
        }

        /**
         * @param edit The edit
         */
        public void setEdit(Edit edit) {
            this.edit = edit;
        }

    }
}