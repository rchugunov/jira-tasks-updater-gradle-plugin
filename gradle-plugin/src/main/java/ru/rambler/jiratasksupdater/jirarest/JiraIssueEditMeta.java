
package ru.rambler.jiratasksupdater.jirarest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class JiraIssueEditMeta {

    @SerializedName("fields")
    @Expose
    private Fields fields;

    /**
     * No args constructor for use in serialization
     */
    public JiraIssueEditMeta() {
    }

    /**
     * @param fields
     */
    public JiraIssueEditMeta(Fields fields) {
        this.fields = fields;
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

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(fields).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof JiraIssueEditMeta) == false) {
            return false;
        }
        JiraIssueEditMeta rhs = ((JiraIssueEditMeta) other);
        return new EqualsBuilder().append(fields, rhs.fields).isEquals();
    }

}
