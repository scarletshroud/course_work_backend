package com.scarletshroud.course_work.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="photo")
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "path")
    private String path;

    @Column(name = "tag")
    private String tag;

    @Column(name = "author_id")
    private Long authorId;

    @Column(name = "creation_date")
    private Date creationDate;

    public Photo() {

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

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creation_date) {
        this.creationDate = creation_date;
    }
}
