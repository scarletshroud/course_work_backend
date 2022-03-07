package com.scarletshroud.course_work.dto;

import com.scarletshroud.course_work.entity.Trick;

import java.util.List;

public class ProfileDTO {
    private String username;
    private String photoUrl;
    private String status;
    private Long homeSpotId;
    private String homeSpotName;
    private LocationDTO locationDTO;
    private List<Trick> learnedTricks;

    public ProfileDTO() {
    }

    public ProfileDTO(String username, String photoUrl, String status, Long homeSpotId, String homeSpotName, LocationDTO location, List<Trick> learnedTricks) {
        this.username = username;
        this.photoUrl = photoUrl;
        this.status = status;
        this.homeSpotId = homeSpotId;
        this.homeSpotName = homeSpotName;
        this.locationDTO = location;
        this.learnedTricks = learnedTricks;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getHomeSpotName() {
        return homeSpotName;
    }

    public void setHomeSpotName(String homeSpotName) {
        this.homeSpotName = homeSpotName;
    }

    public LocationDTO getLocationDTO() {
        return locationDTO;
    }

    public void setLocationDTO(LocationDTO locationDTO) {
        this.locationDTO = locationDTO;
    }

    public List<Trick> getLearnedTricks() {
        return learnedTricks;
    }

    public void setLearnedTricks(List<Trick> learnedTricks) {
        this.learnedTricks = learnedTricks;
    }

    public Long getHomeSpotId() {
        return homeSpotId;
    }

    public void setHomeSpotId(Long homeSpotId) {
        this.homeSpotId = homeSpotId;
    }
}
