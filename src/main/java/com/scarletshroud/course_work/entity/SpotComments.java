package com.scarletshroud.course_work.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/*@Entity
@Table(name="spot_comments")*/
public class SpotComments {

    @Column(name="spot_id")
    private Long spotId;

    @Column(name="comment_id")
    private Long commentId;

    public SpotComments() {

    }

    public Long getSpotId() {
        return spotId;
    }

    public void setSpotId(Long spotId) {
        this.spotId = spotId;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }
}
