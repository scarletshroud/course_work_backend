package com.scarletshroud.course_work.repository;

import com.scarletshroud.course_work.entity.Progress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface ProgressRepository extends JpaRepository<Progress, Long> {
    @Query(value ="SELECT * FROM PROGRESS " +
            "WHERE USER_ID = ?1 AND TRICK_ID = ?2",
            nativeQuery = true)
    Optional<Progress> getProgressTrick(Long userId, Long trickId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE PROGRESS SET TRICK_STATUS = ?3 WHERE PROGRESS.USER_ID = ?1 AND PROGRESS.TRICK_ID = ?2",
            nativeQuery = true)
    void updateUserTrickStatus(Long userId, Long trickId, String status);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM PROGRESS WHERE PROGRESS.USER_ID = ?1 AND PROGRESS.TRICK_ID = ?2",
            nativeQuery = true)
    void deleteUserTrick(Long userId, Long trickId);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO PROGRESS values (?2, ?1, ?3)",
            nativeQuery = true)
    void addTrick(Long userId, Long trickId, String status);
}
