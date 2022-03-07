package com.scarletshroud.course_work.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class CommentDTO {
    private Long id;
    private String text;
    private String authorName;
    private Long creationDate;


    public CommentDTO(Long id, String text, String authorName, Date creationDate) {
        this.id = id;
        this.text = text;
        this.authorName = authorName;
        this.creationDate = creationDate.getTime();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Long getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Long creationDate) {
        this.creationDate = creationDate;
    }
}
