package com.scarletshroud.course_work.dto;

import com.scarletshroud.course_work.entity.*;

import java.util.Date;
import java.util.List;

public class LightSpotDTO {

    private Long id;
    private String name;
    private String description;
    private Float latitude;
    private Float longitude;


    public LightSpotDTO() {

    }

    public LightSpotDTO(Spot spot, SpotActivity spotActivity, Location location) {
        this.id = spot.getId();
        this.name = spot.getName();
        this.description = spot.getDescription();
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
