package com.scarletshroud.course_work.dto;

import com.scarletshroud.course_work.entity.Video;
import java.util.LinkedList;
import java.util.List;

public class TrickDTO {
    private Long id;
    private String name;
    private String description;
    private String howTo;
    private String complexity;
    private Integer peopleStudied;
    private List<Video> videos;
    private List<CommentDTO> comments;

    public TrickDTO(Long id, String name, String description, String howTo, String complexity, Integer peopleStudied, Video video, List<CommentDTO> comments) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.howTo = howTo;
        this.complexity = complexity;
        this.peopleStudied = peopleStudied;
        videos = new LinkedList<>();
        videos.add(video);
        this.comments = comments;
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

    public void setPeopleStudied(Integer peopleStudied) {
        this.peopleStudied = peopleStudied;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

    public List<CommentDTO> getComments() {
        return comments;
    }

    public void setComments(List<CommentDTO> comments) {
        this.comments = comments;
    }
}

