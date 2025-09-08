package part1.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public abstract class BaseFile implements Serializable {
    private UUID id;
    private String contentType;
    private long contentLength;

    public BaseFile() {
        this.id = UUID.randomUUID();
    }

    public BaseFile(UUID id, String contentType, long contentLength) {
        this.id = id;
        this.contentType = contentType;
        this.contentLength = contentLength;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public long getContentLength() {
        return contentLength;
    }

    public void setContentLength(long contentLength) {
        this.contentLength = contentLength;
    }



    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof BaseFile)) return false;
        BaseFile that = (BaseFile) object;
        return this.id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.nonNull(id) ? id.hashCode() : System.identityHashCode(this);
    }
}
