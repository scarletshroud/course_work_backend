package com.scarletshroud.course_work.controller;

import com.scarletshroud.course_work.entity.Sport;
import com.scarletshroud.course_work.entity.User;
import com.scarletshroud.course_work.dto.UserTokenDTO;
import com.scarletshroud.course_work.service.SportService;
import com.scarletshroud.course_work.service.TrickService;
import com.scarletshroud.course_work.service.UserService;
import com.scarletshroud.course_work.util.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class ProfileController {

        private final UserService userService;
        private final TrickService trickService;
        private final SportService sportService;

        @Autowired
        public ProfileController(UserService userService, TrickService trickService, SportService sportService) {
            this.userService = userService;
            this.trickService = trickService;
            this.sportService = sportService;
        }

        @GetMapping("/me")
        public ResponseEntity<Object> getUserInfo(@RequestBody UserTokenDTO requestToken) {
            Optional<Long> userId = Optional.of(SessionService.sessionService.get(requestToken.getToken()));
            Optional<User> user = userService.findUserById(userId.get());
            return user.<ResponseEntity<Object>>map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
        }

        @GetMapping("/me/tricks")
        public ResponseEntity<Object> getUserTricks(@RequestBody UserTokenDTO token) {
            return new ResponseEntity<>(HttpStatus.OK);
        }

        @PostMapping("/add-user-sport")
        public ResponseEntity<Object> addUserSport(@RequestBody Map<String, String> jsonRequest) {
            String userToken = jsonRequest.get("token");
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
