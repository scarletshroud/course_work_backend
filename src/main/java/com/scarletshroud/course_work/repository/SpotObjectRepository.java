package com.scarletshroud.course_work.repository;

import com.scarletshroud.course_work.entity.SpotObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SpotObjectRepository extends JpaRepository<SpotObject, Long> {

    @Query(value =
            "SELECT * FROM OBJECT " +
                    "INNER JOIN SPOT_OBJECTS ON OBJECT.ID = SPOT_OBJECTS.OBJECT_ID " +
                    "WHERE SPOT_OBJECTS.SPOT_ID = ?1",
            nativeQuery = true)
    Optional<List<SpotObject>> getSpotObjectsBySpotId(Long id);

}
