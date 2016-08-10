package ru.rambler.jiratasksupdater.jirarest;


import java.util.Map;

public class Errors {
    private String type;
    private Map<String, String> patternProperties;
    private boolean additionalProperties;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<String, String> getPatternProperties() {
        return patternProperties;
    }

    public void setPatternProperties(Map<String, String> patternProperties) {
        this.patternProperties = patternProperties;
    }

    public boolean isAdditionalProperties() {
        return additionalProperties;
    }

    public void setAdditionalProperties(boolean additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Errors errors = (Errors) o;

        if (additionalProperties != errors.additionalProperties) return false;
        if (type != null ? !type.equals(errors.type) : errors.type != null) return false;
        return patternProperties != null ? patternProperties.equals(errors.patternProperties) : errors.patternProperties == null;

    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (patternProperties != null ? patternProperties.hashCode() : 0);
        result = 31 * result + (additionalProperties ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Errors{" +
                "type='" + type + '\'' +
                ", patternProperties=" + patternProperties +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
