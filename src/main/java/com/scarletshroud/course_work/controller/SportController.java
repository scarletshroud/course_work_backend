package com.scarletshroud.course_work.controller;

import com.scarletshroud.course_work.dto.UserTokenDTO;
import com.scarletshroud.course_work.entity.Sport;
import com.scarletshroud.course_work.service.SportService;
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
public class SportController {
    private final SportService sportService;

    @Autowired
    public SportController(SportService sportService) {
        this.sportService = sportService;
    }

    @GetMapping("/sport")
    public ResponseEntity<Object> getUserTricks(@RequestBody UserTokenDTO token) {
        Optional<List<Sport>> allSport = sportService.getAll();
        return allSport.<ResponseEntity<Object>>map(sports -> new ResponseEntity<>(sports, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }
}
