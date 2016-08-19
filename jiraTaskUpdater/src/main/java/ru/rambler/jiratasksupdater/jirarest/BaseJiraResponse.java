package ru.rambler.jiratasksupdater.jirarest;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;

public class BaseJiraResponse {
    @Expose
    private List<String> errorMessages = new ArrayList<String>();
    @SerializedName("errors")
    @Expose
    private Errors errors;
    @SerializedName("status")
    @Expose
    private Integer status;

    /**
     * @return The errorMessages
     */
    public List<String> getErrorMessages() {
        return errorMessages;
    }

    /**
     * @param errorMessages The errorMessages
     */
    public void setErrorMessages(List<String> errorMessages) {
        this.errorMessages = errorMessages;
    }

    /**
     * @return The errors
     */
    public Errors getErrors() {
        return errors;
    }

    /**
     * @param errors The errors
     */
    public void setErrors(Errors errors) {
        this.errors = errors;
    }

    /**
     * @return The status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status The status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        BaseJiraResponse that = (BaseJiraResponse) o;

        return new EqualsBuilder()
                .append(errorMessages, that.errorMessages)
                .append(errors, that.errors)
                .append(status, that.status)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(errorMessages)
                .append(errors)
                .append(status)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("errorMessages", errorMessages)
                .append("errors", errors)
                .append("status", status)
                .toString();
    }
}
