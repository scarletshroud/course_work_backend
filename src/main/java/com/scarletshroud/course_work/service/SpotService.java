package com.scarletshroud.course_work.service;

import com.scarletshroud.course_work.dto.SpotDTO;
import com.scarletshroud.course_work.entity.Location;
import com.scarletshroud.course_work.entity.Spot;
import com.scarletshroud.course_work.entity.SpotActivity;
import com.scarletshroud.course_work.repository.LocationRepository;
import com.scarletshroud.course_work.repository.SpotActivityRepository;
import com.scarletshroud.course_work.repository.SpotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class SpotService {
    private final SpotRepository spotRepo;

    @Autowired
    public SpotService(SpotRepository spotRepo, SpotActivityRepository spotActivityRepo, LocationRepository locationRepo) {
        this.spotRepo = spotRepo;
    }

    public Optional<List<Spot>> getSpotsByLocation(Float latitude, Float longitude) {
        return spotRepo.getSpotsByLocation(latitude, longitude);
    }

    public Optional<Spot> getSpotById(Long id) {
        return spotRepo.findById(id);
    }
}
