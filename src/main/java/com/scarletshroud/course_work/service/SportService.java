package com.scarletshroud.course_work.service;

import com.scarletshroud.course_work.entity.Sport;
import com.scarletshroud.course_work.repository.SportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class SportService {
    private final SportRepository sportRepository;

    @Autowired
    public SportService(SportRepository sportRepository) {
        this.sportRepository = sportRepository;
    }

    public Optional<Sport> findSportByKind(String kind) {
        return sportRepository.findSportByKind(kind);
    }

    public Optional<List<Sport>> getAll() {
        return sportRepository.getAll();
    }

    public void updateSportAmountOfRiders(Long id, Long amount) {
        sportRepository.updateSportAmountOfRiders(id, amount);
    }
}
