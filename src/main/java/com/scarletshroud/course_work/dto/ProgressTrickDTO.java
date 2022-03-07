package com.scarletshroud.course_work.dto;

public class ProgressTrickDTO {

    private Long id;
    private String name;
    private String trickStatus;

    public ProgressTrickDTO(Long id, String name, String trickStatus) {
        this.id = id;
        this.name = name;
        this.trickStatus = trickStatus;
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

    public String getTrickStatus() {
        return trickStatus;
    }

    public void setTrickStatus(String trickStatus) {
        this.trickStatus = trickStatus;
    }
}
