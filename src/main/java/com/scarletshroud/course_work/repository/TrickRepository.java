package com.scarletshroud.course_work.repository;

import com.scarletshroud.course_work.entity.Trick;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TrickRepository extends JpaRepository<Trick, Long> {
    @Query(value =
            "SELECT * FROM TRICK " +
            "INNER JOIN SPORT_TRICKS ON TRICK.ID = SPORT_TRICKS.TRICK_ID " +
            "INNER JOIN SPORT ON SPORT_TRICKS.SPORT_ID = SPORT.ID " +
            "WHERE SPORT.KIND = ?1",
            nativeQuery = true)
    Optional<List<Trick>> getAllTricksBySport(String sport);
    //Optional<List<Trick>> getAllUserTricks();

    @Query(value = "SELECT * FROM TRICK " +
            "INNER JOIN PROGRESS ON TRICK.ID = PROGRESS.TRICK_ID " +
            "WHERE PROGRESS.USER_ID = ?1",
            nativeQuery = true)
    Optional<List<Trick>> getUserProgressTricks(Long id);

    @Query(value = "UPDATE PROGRESS SET TRICK_STATUS = ?3 WHERE PROGRESS.USER_ID = ?1 AND PROGRESS.TRICK_ID = ?2",
            nativeQuery = true)
    void updateUserTrickStatus(Long userId, Long trickId, String status);
}
