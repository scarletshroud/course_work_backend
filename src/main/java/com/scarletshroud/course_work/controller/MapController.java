package com.scarletshroud.course_work.controller;

import com.scarletshroud.course_work.dto.SpotDTO;
import com.scarletshroud.course_work.dto.LocationDTO;
import com.scarletshroud.course_work.service.SpotDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class MapController {

    private SpotDTOService spotDTOService;

    @Autowired
    public MapController(SpotDTOService spotDTOService) {
        this.spotDTOService = spotDTOService;
    }

    @GetMapping("spots")
    public ResponseEntity<Object> getSpotsOnArea(@RequestBody LocationDTO locationDTO) {
        List<SpotDTO> spotDTOList = spotDTOService.getSpotDTOListByLocation(locationDTO.getLatitude(), locationDTO.getLongitude());

        if (!spotDTOList.isEmpty())
            return new ResponseEntity<Object>(spotDTOList, HttpStatus.OK);

        final String responseMessage = "There are no spots in this area";
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }
}
