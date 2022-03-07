package com.scarletshroud.course_work.repository;

import com.scarletshroud.course_work.entity.SpotActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SpotActivityRepository extends JpaRepository<SpotActivity, Long> {
    Optional<SpotActivity> findById(Long id);
}
