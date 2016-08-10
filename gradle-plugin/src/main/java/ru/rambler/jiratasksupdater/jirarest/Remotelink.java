package ru.rambler.jiratasksupdater.jirarest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.net.URI;

import javax.annotation.Generated;


/**
 * Remote Entity Link
 * <p>
 */
@Generated("org.jsonschema2pojo")
public class Remotelink {

    @SerializedName("self")
    @Expose
    private URI self;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("link")
    @Expose
    private Object link;

    /**
     * @return The self
     */
    public URI getSelf() {
        return self;
    }

    /**
     * @param self The self
     */
    public void setSelf(URI self) {
        this.self = self;
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
     * @return The link
     */
    public Object getLink() {
        return link;
    }

    /**
     * @param link The link
     */
    public void setLink(Object link) {
        this.link = link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Remotelink that = (Remotelink) o;

        if (self != null ? !self.equals(that.self) : that.self != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (link != null ? !link.equals(that.link) : that.link != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = self != null ? self.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (link != null ? link.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Remotelink{" +
                "self=" + self +
                ", name='" + name + '\'' +
                ", link=" + link +
                '}';
    }
}
