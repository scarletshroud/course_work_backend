package com.scarletshroud.course_work.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="video")
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="path")
    private String path;

    @Column(name="tag")
    private String tag;

    @Column(name="author_id")
    private Long authorId;

    @Column(name="creation_date")
    private Date creationDate;

    public Video() {

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

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Date getCreation_date() {
        return creationDate;
    }

    public void setCreation_date(Date creation_date) {
        this.creationDate = creation_date;
    }
}
