package com.scarletshroud.course_work.repository;

import com.scarletshroud.course_work.entity.Sport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public interface SportRepository extends JpaRepository<Sport, Long> {
    Optional<Sport> findSportByKind(String kind);

    Optional<List<Sport>> getAll();

    @Query(value = "UPDATE SPORT SET AMOUNT_OF_RIDERS = ?2 WHERE SPORT.ID = ?1",
            nativeQuery = true)
    void updateSportAmountOfRiders(Long id, Long amount);
}
