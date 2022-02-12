package com.scarletshroud.course_work.controller;

import com.scarletshroud.course_work.dto.SportDTO;
import com.scarletshroud.course_work.dto.UserTokenDTO;
import com.scarletshroud.course_work.entity.Trick;
import com.scarletshroud.course_work.service.TrickService;
import com.scarletshroud.course_work.util.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RequestMapping("api")
public class TrickController {

    private final TrickService trickService;

    @Autowired
    public TrickController(TrickService trickService) {
        this.trickService = trickService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "tricks/{type}")
    public ResponseEntity<Object> getSportTricks(@PathVariable("type") String type) {
        Optional<List<Trick>> tricks = trickService.getAllTricksBySport(type);
        return tricks.<ResponseEntity<Object>>map(trickList -> new ResponseEntity<>(trickList, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @PostMapping("/progress")
    public ResponseEntity<Object> getUserProgress(@RequestBody UserTokenDTO userToken) {
        Long userId = SessionService.sessionService.get(userToken.getToken());
        Optional<List<Trick>> tricks = trickService.getUserProgressTricks(userId);
        return tricks.<ResponseEntity<Object>>map(trickList -> new ResponseEntity<>(trickList, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @PostMapping("/progress/update")
    public ResponseEntity<Object> removeTrickFromProgress(@RequestBody Map<String, String> jsonRequest) {
        String userToken = jsonRequest.get("token");
        String trickId = jsonRequest.get("trickId");
        String trickStatus = jsonRequest.get("trickStatus");
        trickService.updateUserTrickStatus(1L, Long.parseLong(trickId), trickStatus);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }
}
