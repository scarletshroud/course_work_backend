package com.scarletshroud.course_work.entity;

import javax.persistence.*;

@Entity
@Table(name="progress")
@IdClass(ProgressKey.class)
public class Progress {
    @Id
    @Column(name="trick_id")
    private Long trickId;

    @Id
    @Column(name="user_id")
    private Long userId;

    @Column(name="trick_status")
    private String trickStatus;

    public Progress() {

    }

    public Long getTrickId() {
        return trickId;
    }

    public void setTrickId(Long trickId) {
        this.trickId = trickId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTrickStatus() {
        return trickStatus;
    }

    public void setTrickStatus(String trickStatus) {
        this.trickStatus = trickStatus;
    }
}
