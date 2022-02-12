package com.scarletshroud.course_work.repository;

import com.scarletshroud.course_work.entity.Spot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface SpotRepository extends JpaRepository<Spot, Long> {
    @Query(value =
                    "SELECT * FROM SPOT " +
                    "INNER JOIN LOCATION ON SPOT.LOCATION_ID = LOCATION.ID " +
                    "WHERE LOCATION.LATITUDE - ?1 < 0.1 AND LOCATION.LONGITUDE - ?2 < 0.1",
            nativeQuery = true)
    Optional<List<Spot>> getSpotsByLocation(float latitude, float longitude);
}
