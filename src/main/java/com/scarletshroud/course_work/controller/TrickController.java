package com.scarletshroud.course_work.controller;

import com.scarletshroud.course_work.dto.*;
import com.scarletshroud.course_work.entity.*;
import com.scarletshroud.course_work.service.*;
import com.scarletshroud.course_work.util.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RequestMapping("api")
public class TrickController {

    private final TrickService trickService;
    private final ProgressService progressService;
    private final VideoService videoService;
    private final CommentService commentService;
    private final UserService userService;

    @Autowired
    public TrickController(TrickService trickService, ProgressService progressService, VideoService videoService, CommentService commentService, UserService userService) {
        this.trickService = trickService;
        this.progressService = progressService;
        this.videoService = videoService;
        this.commentService = commentService;
        this.userService = userService;
    }

    @GetMapping("/trick/{id}")
    public ResponseEntity<Object> getUserInfo(@PathVariable("id") Long trickId) {
        Optional<Trick> trick = trickService.findTrickById(trickId);

        Optional<List<Comment>> comments = commentService.getCommentsByTrickId(trickId);
        LinkedList<CommentDTO> commentDTOList = new LinkedList<>();
        if (comments.isPresent()) {
            for (Comment comment : comments.get()) {
                commentDTOList.add(new CommentDTO(comment.getId(), comment.getText(), userService.findUserById(comment.getId()).get().getUsername(), comment.getCreationDate()));
            }
        }

        Optional<Video> video = videoService.getVideoById(trickId);
        if (trick.isPresent()) {
            TrickDTO trickDTO = new TrickDTO(trick.get().getId(), trick.get().getName(), trick.get().getDescription(), trick.get().getHowTo(), trick.get().getComplexity(), trick.get().getPeopleStudied(), video.get(), commentDTOList);
            return new ResponseEntity<>(trickDTO, HttpStatus.OK);
        }
       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("tricks/{sportId}")
    public ResponseEntity<Object> getSportTricks(@PathVariable("sportId") Long sportId) {
        Optional<List<Trick>> tricks = trickService.getAllTricksBySportId(sportId);
        LinkedList<TrickDTO> trickDTOLinkedList = new LinkedList<>();

        if (tricks.isPresent()) {
            for (Trick trick : tricks.get()) {
                Optional<Video> video = videoService.getVideoById(trick.getVideoId());
                trickDTOLinkedList.add(new TrickDTO(trick.getId(), trick.getName(), trick.getDescription(), trick.getHowTo(), trick.getComplexity(), trick.getPeopleStudied(), video.get(), null));
            }
        }

        return new ResponseEntity<>(trickDTOLinkedList, HttpStatus.OK);
    }

    @PostMapping("/progress")
    public ResponseEntity<Object> getUserProgress(@RequestBody UserTokenDTO userToken) {
        Long userId = SessionService.sessionService.get(userToken.getToken());
        Optional<List<Trick>> tricks = trickService.getUserProgressTricks(userId);

        List<ProgressTrickDTO> progressTrickDTOList = new LinkedList<>();
        if (tricks.isPresent()) {
            for (Trick trick : tricks.get()) {
                Optional<Progress> progress = progressService.getProgressTrick(userId, trick.getId());
                progressTrickDTOList.add(new ProgressTrickDTO(trick.getId(), trick.getName(), progress.get().getTrickStatus()));
            }
        }

        return new ResponseEntity<>(progressTrickDTOList, HttpStatus.OK);
    }

    @PostMapping("/progress/update")
    public ResponseEntity<Object> removeTrickFromProgress(@RequestBody Map<String, String> jsonRequest) {
        String userToken = jsonRequest.get("token");
        Long userId = SessionService.sessionService.get(userToken);
        Long trickId = Long.parseLong(jsonRequest.get("trickId"));
        String trickStatus = jsonRequest.get("trickStatus");

        if (trickStatus.equals("default")) {
            if (progressService.getProgressTrick(userId, trickId).get().getTrickStatus().equals("learned"))
                trickService.decrementTrickLearnedPeople(trickId);
            progressService.removeUserTrick(userId, trickId);
        }
        else {
            if (progressService.getProgressTrick(userId, trickId).isPresent()) {
                progressService.updateUserTrickStatus(userId, trickId, trickStatus);
            } else {
                progressService.addTrick(userId, trickId, trickStatus);
                if (trickStatus.equals("learned"))
                    trickService.incrementTrickLearnedPeople(trickId);
            }
        }

        return new ResponseEntity<Object>(HttpStatus.OK);
    }
}
