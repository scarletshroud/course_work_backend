package com.scarletshroud.course_work.controller;

import com.scarletshroud.course_work.dto.LightSpotDTO;
import com.scarletshroud.course_work.dto.SpotDTO;
import com.scarletshroud.course_work.dto.LocationDTO;
import com.scarletshroud.course_work.entity.Location;
import com.scarletshroud.course_work.entity.Spot;
import com.scarletshroud.course_work.entity.SpotActivity;
import com.scarletshroud.course_work.repository.LocationRepository;
import com.scarletshroud.course_work.repository.SpotActivityRepository;
import com.scarletshroud.course_work.service.LocationService;
import com.scarletshroud.course_work.service.SpotActivityService;
import com.scarletshroud.course_work.service.SpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class MapController {

    private final SpotService spotService;
    private final LocationService locationService;
    private final SpotActivityService spotActivityService;

    @Autowired
    public MapController(SpotService spotService, LocationService locationService, SpotActivityService spotActivityService) {
        this.spotService = spotService;
        this.locationService = locationService;
        this.spotActivityService = spotActivityService;
    }

    @PostMapping("spots")
    public ResponseEntity<Object> getSpotsOnArea(@RequestBody LocationDTO locationDTO) {
        Optional<List<Spot>> spots = spotService.getSpotsByLocation(locationDTO.getLatitude(), locationDTO.getLongitude());
        LinkedList<LightSpotDTO> lightSpotDTOList = new LinkedList<>();
        if (spots.isPresent()) {
            for (Spot spot : spots.get()) {
                Optional<SpotActivity> spotActivity = spotActivityService.findById(spot.getActivityId());
                Optional<Location> location = locationService.getLocationById(spot.getLocationId());
                lightSpotDTOList.add(new LightSpotDTO(spot, spotActivity.get(), location.get()));
            }
        }

        if (!lightSpotDTOList.isEmpty())
            return new ResponseEntity<Object>(lightSpotDTOList, HttpStatus.OK);

        final String responseMessage = "There are no spots in this area";
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }
}
