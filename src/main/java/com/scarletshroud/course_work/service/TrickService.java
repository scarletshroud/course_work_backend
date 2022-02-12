package com.scarletshroud.course_work.service;

import com.scarletshroud.course_work.entity.Trick;
import com.scarletshroud.course_work.repository.TrickRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrickService {
    private final TrickRepository trickRepo;

    @Autowired
    public TrickService(TrickRepository trickRepo) {
        this.trickRepo = trickRepo;
    }

    public Optional<List<Trick>> getAllTricksBySport(String sport) {
        return trickRepo.getAllTricksBySport(sport);
    }

    public Optional<List<Trick>> getUserProgressTricks(Long id) {
        return trickRepo.getUserProgressTricks(id);
    }

    public void updateUserTrickStatus(Long userId, Long trickId, String trickStatus) {
        trickRepo.updateUserTrickStatus(userId, trickId, trickStatus);
    }
}
