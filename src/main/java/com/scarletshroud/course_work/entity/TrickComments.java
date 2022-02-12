package com.scarletshroud.course_work.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/*@Entity
@Table(name="trick_comments")*/
public class TrickComments {
    @Column(name="trick_id")
    private Integer trickId;

    @Column(name="comment_id")
    private Long commentId;

    public TrickComments() {

    }

    public Integer getTrickId() {
        return trickId;
    }

    public void setTrickId(Integer trickId) {
        this.trickId = trickId;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }
}
