package org.pk.com.domain;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Objects;

public class DocumentId implements Serializable {

    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "version", nullable = false)
    private Integer version;

    public DocumentId() {
        //Default Constructor
    }

    public DocumentId(Long id, Integer version) {
        this.id = id;
        this.version = version;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocumentId that = (DocumentId) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(version, that.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, version);
    }

    @Override
    public String toString() {
        return "DocumentId{" +
                "id=" + id +
                ", version=" + version +
                '}';
    }
}
