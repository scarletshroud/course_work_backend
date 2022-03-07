package com.scarletshroud.course_work.repository;

import com.scarletshroud.course_work.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query(value =
            "SELECT * FROM COMMENT " +
                    "INNER JOIN SPOT_COMMENTS ON COMMENT.ID = SPOT_COMMENTS.SPOT_ID " +
                    "WHERE SPOT_COMMENTS.SPOT_ID = ?1",
            nativeQuery = true)
    Optional<List<Comment>> getCommentsBySpotId(Long id);

    @Query(value =
            "SELECT * FROM COMMENT " +
                    "INNER JOIN TRICK_COMMENTS ON COMMENT.ID = TRICK_COMMENTS.TRICK_ID " +
                    "WHERE TRICK_COMMENTS.TRICK_ID = ?1",
            nativeQuery = true)
    Optional<List<Comment>> getCommentsByTrickId(Long id);
}
