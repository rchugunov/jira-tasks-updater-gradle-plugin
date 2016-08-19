
package ru.rambler.jiratasksupdater.jirarest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class FixVersions {

    @SerializedName("required")
    @Expose
    private boolean required;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("operations")
    @Expose
    private List<String> operations = new ArrayList<String>();
    @Expose
    private List<JiraIssueFixVersion> allowedValues;

    /**
     * No args constructor for use in serialization
     */
    public FixVersions() {
    }


    /**
     * @return The required
     */
    public boolean isRequired() {
        return required;
    }

    /**
     * @param required The required
     */
    public void setRequired(boolean required) {
        this.required = required;
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
     * @return The operations
     */
    public List<String> getOperations() {
        return operations;
    }

    /**
     * @param operations The operations
     */
    public void setOperations(List<String> operations) {
        this.operations = operations;
    }

    public List<JiraIssueFixVersion> getAllowedValues() {
        return allowedValues;
    }

    public void setAllowedValues(List<JiraIssueFixVersion> allowedValues) {
        this.allowedValues = allowedValues;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(required).append(name).append(operations).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof FixVersions) == false) {
            return false;
        }
        FixVersions rhs = ((FixVersions) other);
        return new EqualsBuilder().append(required, rhs.required).append(name, rhs.name).append(operations, rhs.operations).isEquals();
    }

}
