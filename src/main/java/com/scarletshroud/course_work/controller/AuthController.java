package com.scarletshroud.course_work.controller;

import com.scarletshroud.course_work.entity.User;
import com.scarletshroud.course_work.dto.UserRegisterCredentials;
import com.scarletshroud.course_work.dto.UserLoginCredentials;
import com.scarletshroud.course_work.dto.UserTokenDTO;
import com.scarletshroud.course_work.service.UserService;
import com.scarletshroud.course_work.util.HashEncoder;
import com.scarletshroud.course_work.util.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class AuthController {

    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody UserLoginCredentials userLoginCredentials) {
        Optional<User> user  = userService.findUserByEmail(userLoginCredentials.getEmail());
        if (user.isPresent()) {
            if (HashEncoder.sha256(userLoginCredentials.getPassword()).equals(user.get().getPassword())) {
                final String token = HashEncoder.sha256(user.get().getUsername());
                SessionService.sessionService.add(token, user.get().getId());
                UserTokenDTO userToken = new UserTokenDTO(token);
                return new ResponseEntity<>(userToken, HttpStatus.OK);
            }
        }
        final String responseMessage = "User doesn't exist";
        return new ResponseEntity<>(responseMessage, HttpStatus.UNAUTHORIZED);
    }

    @PostMapping("/registration")
    public ResponseEntity<Object> register(@RequestBody UserRegisterCredentials userRegisterCredentials) {
        Optional<User> user = userService.findUserByEmail(userRegisterCredentials.getEmail());
        if (user.isPresent()) {
            final String responseMessage = "User is already exists";
            return new ResponseEntity<>(responseMessage, HttpStatus.OK);
        }
        userService.saveUser(new User(
                userRegisterCredentials.getEmail(),
                userRegisterCredentials.getUsername(),
                HashEncoder.sha256(userRegisterCredentials.getPassword())
        ));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/logout")
    public ResponseEntity<Object> logout(@RequestBody UserTokenDTO userTokenDTO) {
        SessionService.sessionService.remove(userTokenDTO.getToken());
        return new ResponseEntity<Object>(HttpStatus.OK);
    }
}
