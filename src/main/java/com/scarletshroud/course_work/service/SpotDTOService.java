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
public class SpotDTOService {
    private final SpotRepository spotRepo;
    private final LocationRepository locationRepo;
    private final SpotActivityRepository spotActivityRepo;

    @Autowired
    public SpotDTOService(SpotRepository spotRepo, SpotActivityRepository spotActivityRepo, LocationRepository locationRepo) {
        this.spotRepo = spotRepo;
        this.spotActivityRepo = spotActivityRepo;
        this.locationRepo = locationRepo;
    }

    public List<SpotDTO> getSpotDTOListByLocation(Float latitude, Float longitude) {
        Optional<List<Spot>> spots = spotRepo.getSpotsByLocation(latitude, longitude);
        LinkedList<SpotDTO> spotDTOList = new LinkedList<SpotDTO>();
        if (spots.isPresent()) {
            for (Spot spot : spots.get()) {
                Optional<SpotActivity> spotActivity = spotActivityRepo.findById(spot.getActivityId());
                Optional<Location> location = locationRepo.findById(spot.getLocationId());
                spotDTOList.add(new SpotDTO(spot, spotActivity.get(), location.get()));
            }
        }
        return spotDTOList;
    }
}
