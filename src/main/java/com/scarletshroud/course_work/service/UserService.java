package com.scarletshroud.course_work.service;

import com.scarletshroud.course_work.entity.User;
import com.scarletshroud.course_work.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepo;

    @Autowired
    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public Optional<User> findUserByEmail(String email) {
        return userRepo.findUserByEmail(email);
    }

    public Optional<User> findUserById(Long id) {
        return userRepo.findUserById(id);
    }

    public void saveUser(User user) {
        userRepo.save(user);
    }
}
