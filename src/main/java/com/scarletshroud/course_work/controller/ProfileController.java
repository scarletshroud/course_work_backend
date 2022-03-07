package com.scarletshroud.course_work.controller;

import com.scarletshroud.course_work.dto.LocationDTO;
import com.scarletshroud.course_work.dto.ProfileDTO;
import com.scarletshroud.course_work.entity.*;
import com.scarletshroud.course_work.dto.UserTokenDTO;
import com.scarletshroud.course_work.service.*;
import com.scarletshroud.course_work.util.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class ProfileController {

        private final UserService userService;
        private final TrickService trickService;
        private final SportService sportService;
        private final SpotService spotDTOService;
        private final LocationService locationService;
        private final PhotoService photoService;

        @Autowired
        public ProfileController(UserService userService, TrickService trickService, SportService sportService, SpotService spotDTOService, LocationService locationService, PhotoService photoService) {
            this.userService = userService;
            this.trickService = trickService;
            this.sportService = sportService;
            this.spotDTOService = spotDTOService;
            this.locationService = locationService;
            this.photoService = photoService;
        }

        @GetMapping("/user/{id}")
        public ResponseEntity<Object> getUserInfo(@PathVariable("id") String userId) {
            Optional<User> user = userService.findUserById(Long.parseLong(userId));
            if (user.isPresent()) {
                Optional<List<Trick>> tricks = trickService.getUserProgressTricks(user.get().getId());
                Optional<Spot> homeSpot = spotDTOService.getSpotById(user.get().getHomeSpotId());
                Optional<Location> spotLocation = locationService.getLocationById(homeSpot.get().getLocationId());
                LocationDTO locationDTO = new LocationDTO(spotLocation.get().getLatitude(), spotLocation.get().getLongitude());
                Optional<Photo> photo = photoService.getPhotoByAuthorId(user.get().getId(), "user");
                return new ResponseEntity<>(new ProfileDTO(user.get().getUsername(), photo.get().getPath(), user.get().getStatus(), homeSpot.get().getId(), homeSpot.get().getName(), locationDTO, tricks.get()), HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        @PostMapping("/me/tricks")
        public ResponseEntity<Object> getUserTricks(@RequestBody UserTokenDTO token) {
            return new ResponseEntity<>(HttpStatus.OK);
        }

        @PostMapping("/complete")
        public ResponseEntity<Object> addUserSport(@RequestBody Map<String, String> jsonRequest) {
            String userToken = jsonRequest.get("userToken");
            String username = jsonRequest.get("username");
            String kindOfSport = jsonRequest.get("sport");
            Optional<Sport> sport = sportService.findSportByKind(kindOfSport);

            Long userId = SessionService.sessionService.get(userToken);

            if (sport.isPresent()) {
                userService.updateUser(userId, username, sport.get().getId());
                sportService.updateSportAmountOfRiders(sport.get().getId(), sport.get().getId() + 1);
            }

            return new ResponseEntity<>(HttpStatus.OK);
        }
}
