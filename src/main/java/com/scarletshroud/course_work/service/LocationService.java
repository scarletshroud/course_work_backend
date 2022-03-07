package com.scarletshroud.course_work.service;

import com.scarletshroud.course_work.entity.Location;
import com.scarletshroud.course_work.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LocationService {

    private final LocationRepository locationRepository;

    @Autowired
    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public Optional<Location> getLocationById(Long id) {
        return locationRepository.findById(id);
    }
}
