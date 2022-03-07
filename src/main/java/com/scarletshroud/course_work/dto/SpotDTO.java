package com.scarletshroud.course_work.dto;

import com.scarletshroud.course_work.entity.*;

import java.util.List;

public class SpotDTO {

    private Long id;
    private String name;
    private String description;
    private Long updateDate;
    private Long peopleVisited;
    private String activity;
    private Float latitude;
    private Float longitude;
    private List<SpotObject> objects;
    private List<CommentDTO> comments;
    private List<Video> video;
    private List<Photo> photo;

    public SpotDTO() {
    }

    public SpotDTO(Spot spot, SpotActivity spotActivity, Location location, List<SpotObject> objects, List<CommentDTO> comments, List<Video> video, List<Photo> photo)  {
        this.id = spot.getId();
        this.name = spot.getName();
        this.description = spot.getDescription();
        this.updateDate = spot.getUpdateDate().getTime();
        this.peopleVisited = spotActivity.getPeopleVisited();
        this.activity = spotActivity.getActivity();
        this.latitude = location.getLatitude();
        this.longitude = location.getLongitude();
        this.objects = objects;
        this.comments = comments;
        this.photo = photo;
        this.video = video;
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

    public Long getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Long updateDate) {
        this.updateDate = updateDate;
    }

    public Long getPeopleVisited() {
        return peopleVisited;
    }

    public void setPeopleVisited(Long peopleVisited) {
        this.peopleVisited = peopleVisited;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public List<SpotObject> getObjects() {
        return objects;
    }

    public void setObjects(List<SpotObject> objects) {
        this.objects = objects;
    }

    public List<CommentDTO> getComments() {
        return comments;
    }

    public void setComments(List<CommentDTO> comments) {
        this.comments = comments;
    }

    public List<Photo> getPhoto() {
        return photo;
    }

    public void setPhoto(List<Photo> photo) {
        this.photo = photo;
    }

    public List<Video> getVideo() {
        return video;
    }

    public void setVideo(List<Video> video) {
        this.video = video;
    }
}
