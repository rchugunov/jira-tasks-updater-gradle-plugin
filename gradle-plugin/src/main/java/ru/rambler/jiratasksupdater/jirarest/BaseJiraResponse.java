package ru.rambler.jiratasksupdater.jirarest;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

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
}
