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

    public Optional<List<Trick>> getAllTricksBySportId(Long sportId) {
        return trickRepo.getAllTricksBySportId(sportId);
    }

    public Optional<List<Trick>> getUserProgressTricks(Long id) {
        return trickRepo.getUserProgressTricks(id);
    }

    public void incrementTrickLearnedPeople(Long id) {
        trickRepo.incrementTrickLearnedPeople(id);
    }

    public void decrementTrickLearnedPeople(Long id) {
        trickRepo.decrementTrickLearnedPeople(id);
    }

    public Optional<Trick> findTrickById(Long id) {
        return trickRepo.findTrickById(id);
    }
}
