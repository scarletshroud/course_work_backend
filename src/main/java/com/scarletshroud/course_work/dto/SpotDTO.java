package com.scarletshroud.course_work.dto;

import com.scarletshroud.course_work.entity.Location;
import com.scarletshroud.course_work.entity.Spot;
import com.scarletshroud.course_work.entity.SpotActivity;

import java.util.Date;

public class SpotDTO {

    private Long id;
    private String name;
    private String description;
    private Date updateDate;
    private Long peopleVisited;
    private String activity;
    private Float latitude;
    private Float longitude;

    public SpotDTO() {

    }

    public SpotDTO(Spot spot, SpotActivity spotActivity, Location location) {
        this.id = spot.getId();
        this.name = spot.getName();
        this.description = spot.getDescription();
        this.updateDate = spot.getUpdateDate();
        this.peopleVisited = spotActivity.getPeopleVisited();
        this.activity = spotActivity.getActivity();
        this.latitude = location.getLatitude();
        this.longitude = location.getLongitude();
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

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
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
}
