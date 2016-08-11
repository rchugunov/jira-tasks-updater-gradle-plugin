
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
public class Versions {

    @SerializedName("required")
    @Expose
    private boolean required;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("operations")
    @Expose
    private List<String> operations = new ArrayList<String>();
    @SerializedName("allowedValues")
    @Expose
    private List<JiraIssueFixVersion> allowedValues = new ArrayList<JiraIssueFixVersion>();

    /**
     * No args constructor for use in serialization
     */
    public Versions() {
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

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(required).append(name).append(operations).append(allowedValues).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Versions) == false) {
            return false;
        }
        Versions rhs = ((Versions) other);
        return new EqualsBuilder().append(required, rhs.required).append(name, rhs.name).append(operations, rhs.operations).append(allowedValues, rhs.allowedValues).isEquals();
    }

}
