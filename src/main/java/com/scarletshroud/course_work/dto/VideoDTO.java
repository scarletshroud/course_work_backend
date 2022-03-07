package com.scarletshroud.course_work.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class VideoDTO {
    private Long id;
    private String path;
    private String tag;
    private String authorName;
    private Long creationDate;

    public VideoDTO(Long id, String path, String tag, String authorName, Date creationDate) {
        this.id = id;
        this.path = path;
        this.tag = tag;
        this.authorName = authorName;
        this.creationDate = creationDate.getTime();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorId(Long authorId) {
        this.authorName = authorName;
    }

    public Long getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Long creationDate) {
        this.creationDate = creationDate;
    }
}
