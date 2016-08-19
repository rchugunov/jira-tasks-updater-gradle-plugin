
package ru.rambler.jiratasksupdater.jirarest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Fields {

    @SerializedName("fixVersions")
    @Expose
    private FixVersions fixVersions;
    @SerializedName("versions")
    @Expose
    private Versions versions;

    /**
     * No args constructor for use in serialization
     */
    public Fields() {
    }

    public FixVersions getFixVersions() {
        return fixVersions;
    }

    public void setFixVersions(FixVersions fixVersions) {
        this.fixVersions = fixVersions;
    }

    public Versions getVersions() {
        return versions;
    }

    public void setVersions(Versions versions) {
        this.versions = versions;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(fixVersions).append(versions).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Fields) == false) {
            return false;
        }
        Fields rhs = ((Fields) other);
        return new EqualsBuilder().append(fixVersions, rhs.fixVersions).append(versions, rhs.versions).isEquals();
    }

}
