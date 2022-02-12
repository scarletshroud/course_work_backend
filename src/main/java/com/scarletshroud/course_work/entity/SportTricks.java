package com.scarletshroud.course_work.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/*@Entity
@Table(name="sport_tricks") */
public class SportTricks {

    @Column(name="sport_id")
    private Long sportId;

    @Column(name="trick_id")
    private Long trickId;

    public SportTricks() {

    }

    public Long getSportId() {
        return sportId;
    }

    public void setSportId(Long sportId) {
        this.sportId = sportId;
    }

    public Long getTrickId() {
        return trickId;
    }

    public void setTrickId(Long trickId) {
        this.trickId = trickId;
    }
}
