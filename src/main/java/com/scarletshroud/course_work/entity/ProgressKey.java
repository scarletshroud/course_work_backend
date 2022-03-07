package com.scarletshroud.course_work.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class ProgressKey implements Serializable  {
    private Long trickId;
    private Long userId;

    public ProgressKey() {}

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
}
