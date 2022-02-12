package com.scarletshroud.course_work.repository;

import com.scarletshroud.course_work.dto.LocationDTO;
import com.scarletshroud.course_work.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LocationRepository extends JpaRepository<Location, Long> {
    Optional<Location> findById(Long id);
}
