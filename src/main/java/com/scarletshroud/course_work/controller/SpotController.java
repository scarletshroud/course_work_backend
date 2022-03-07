package com.scarletshroud.course_work.controller;

import com.scarletshroud.course_work.dto.CommentDTO;
import com.scarletshroud.course_work.dto.SpotDTO;
import com.scarletshroud.course_work.entity.*;
import com.scarletshroud.course_work.service.*;
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
public class SpotController {

    private final SpotService spotService;
    private final PhotoService photoService;
    private final VideoService videoService;
    private final LocationService locationService;
    private final SpotObjectService spotObjectService;
    private final SpotActivityService spotActivityService;
    private final CommentService commentService;
    private final UserService userService;

    @Autowired
    public SpotController(SpotService spotService, PhotoService photoService, VideoService videoService, LocationService locationService, SpotObjectService spotObjectService, CommentService commentService, SpotActivityService spotActivityService, UserService userService) {
        this.spotService = spotService;
        this.photoService = photoService;
        this.videoService = videoService;
        this.locationService = locationService;
        this.spotObjectService = spotObjectService;
        this.commentService = commentService;
        this.spotActivityService = spotActivityService;
        this.userService = userService;
    }

    @GetMapping("/spot/{id}")
    public ResponseEntity<Object> getUserInfo(@PathVariable("id") Long spotId) {
        Optional<Spot> spot = spotService.getSpotById(spotId);
        if (spot.isPresent()) {
                Optional<List<Photo>> photos = photoService.getSpotPhotosById(spot.get().getId());
                Optional<List<Video>> videos = videoService.getSpotVideosBySpotId(spot.get().getId());
                Optional<Location> location = locationService.getLocationById(spot.get().getLocationId());
                Optional<List<SpotObject>> spotObjects = spotObjectService.getSpotObjectsBySpotId(spot.get().getId());

                Optional<List<Comment>> comments = commentService.getCommentsBySpotId(spot.get().getId());
                LinkedList<CommentDTO> commentDTOList = new LinkedList<>();
                if (comments.isPresent()) {
                    for (Comment comment : comments.get()) {
                        commentDTOList.add(new CommentDTO(comment.getId(), comment.getText(), userService.findUserById(comment.getId()).get().getUsername(), comment.getCreationDate()));
                    }
                }

                Optional<SpotActivity> spotActivity = spotActivityService.findById(spot.get().getActivityId());
                SpotDTO spotDTO = new SpotDTO(spot.get(), spotActivity.get(), location.get(), spotObjects.get(), commentDTOList, videos.get(), photos.get());
                return new ResponseEntity<>(spotDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
