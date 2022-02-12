package com.scarletshroud.course_work.entity;

import javax.persistence.*;

@Entity
@Table(name="trick")
public class Trick {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="how_to")
    private String howTo;

    @Column(name="complexity")
    private String complexity;

    @Column(name="people_studied")
    private Integer peopleStudied;

    @Column(name="video_id")
    private Long videoId;

    public Trick() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHowTo() {
        return howTo;
    }

    public void setHowTo(String howTo) {
        this.howTo = howTo;
    }

    public String getComplexity() {
        return complexity;
    }

    public void setComplexity(String complexity) {
        this.complexity = complexity;
    }

    public Integer getPeopleStudied() {
        return peopleStudied;
    }

    public void setPeopleStudied(int peopleStudied) {
        this.peopleStudied = peopleStudied;
    }

    public Long getVideoId() {
        return videoId;
    }

    public void setVideoId(long videoId) {
        this.videoId = videoId;
    }
}
