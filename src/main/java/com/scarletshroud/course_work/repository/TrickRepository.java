package com.scarletshroud.course_work.repository;

import com.scarletshroud.course_work.entity.Trick;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface TrickRepository extends JpaRepository<Trick, Long> {
    @Query(value =
            "SELECT * FROM TRICK " +
                    "INNER JOIN SPORT_TRICKS ON TRICK.ID = SPORT_TRICKS.TRICK_ID " +
                    "WHERE SPORT_TRICKS.SPORT_ID = ?1",
            nativeQuery = true)
    Optional<List<Trick>> getAllTricksBySportId(Long id);

    @Query(value = "SELECT * FROM TRICK " +
            "INNER JOIN PROGRESS ON TRICK.ID = PROGRESS.TRICK_ID " +
            "WHERE PROGRESS.USER_ID = ?1",
            nativeQuery = true)
    Optional<List<Trick>> getUserProgressTricks(Long id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE TRICK " +
            "SET PEOPLE_STUDIED = PEOPLE_STUDIED + 1 " +
            "WHERE TRICK.ID = ?1",
            nativeQuery = true)
    void incrementTrickLearnedPeople(Long id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE TRICK " +
            "SET PEOPLE_STUDIED = PEOPLE_STUDIED - 1 " +
            "WHERE TRICK.ID = ?1",
            nativeQuery = true)
    void decrementTrickLearnedPeople(Long id);

    Optional<Trick> findTrickById(Long id);
}
