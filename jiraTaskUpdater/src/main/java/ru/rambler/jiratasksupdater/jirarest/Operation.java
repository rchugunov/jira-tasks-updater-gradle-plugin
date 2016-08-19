package ru.rambler.jiratasksupdater.jirarest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;


/**
 * Simple Link
 * <p>
 */
@Generated("org.jsonschema2pojo")
public class Operation {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("styleClass")
    @Expose
    private String styleClass;
    @SerializedName("iconClass")
    @Expose
    private String iconClass;
    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("href")
    @Expose
    private String href;
    @SerializedName("weight")
    @Expose
    private Integer weight;

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
     * @return The styleClass
     */
    public String getStyleClass() {
        return styleClass;
    }

    /**
     * @param styleClass The styleClass
     */
    public void setStyleClass(String styleClass) {
        this.styleClass = styleClass;
    }

    /**
     * @return The iconClass
     */
    public String getIconClass() {
        return iconClass;
    }

    /**
     * @param iconClass The iconClass
     */
    public void setIconClass(String iconClass) {
        this.iconClass = iconClass;
    }

    /**
     * @return The label
     */
    public String getLabel() {
        return label;
    }

    /**
     * @param label The label
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * @return The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return The href
     */
    public String getHref() {
        return href;
    }

    /**
     * @param href The href
     */
    public void setHref(String href) {
        this.href = href;
    }

    /**
     * @return The weight
     */
    public Integer getWeight() {
        return weight;
    }

    /**
     * @param weight The weight
     */
    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Operation operation = (Operation) o;

        if (id != null ? !id.equals(operation.id) : operation.id != null) return false;
        if (styleClass != null ? !styleClass.equals(operation.styleClass) : operation.styleClass != null)
            return false;
        if (iconClass != null ? !iconClass.equals(operation.iconClass) : operation.iconClass != null)
            return false;
        if (label != null ? !label.equals(operation.label) : operation.label != null) return false;
        if (title != null ? !title.equals(operation.title) : operation.title != null) return false;
        if (href != null ? !href.equals(operation.href) : operation.href != null) return false;
        if (weight != null ? !weight.equals(operation.weight) : operation.weight != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (styleClass != null ? styleClass.hashCode() : 0);
        result = 31 * result + (iconClass != null ? iconClass.hashCode() : 0);
        result = 31 * result + (label != null ? label.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (href != null ? href.hashCode() : 0);
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "id='" + id + '\'' +
                ", styleClass='" + styleClass + '\'' +
                ", iconClass='" + iconClass + '\'' +
                ", label='" + label + '\'' +
                ", title='" + title + '\'' +
                ", href='" + href + '\'' +
                ", weight=" + weight +
                '}';
    }
}

