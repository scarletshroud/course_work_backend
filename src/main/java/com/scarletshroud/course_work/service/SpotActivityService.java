package com.scarletshroud.course_work.service;

import com.scarletshroud.course_work.entity.SpotActivity;
import com.scarletshroud.course_work.repository.SpotActivityRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SpotActivityService {

    private final SpotActivityRepository spotActivityRepository;

    public SpotActivityService(SpotActivityRepository spotActivityRepository) {
        this.spotActivityRepository = spotActivityRepository;
    }

    public Optional<SpotActivity> findById(Long id) {
        return spotActivityRepository.findById(id);
    }
}
