package com.scarletshroud.course_work.service;

import com.scarletshroud.course_work.entity.Progress;
import com.scarletshroud.course_work.repository.ProgressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProgressService {
    private final ProgressRepository progressRepository;

    @Autowired
    public ProgressService(ProgressRepository progressRepository) {
        this.progressRepository = progressRepository;
    }

    public Optional<Progress> getProgressTrick(Long userId, Long trickId) {
        return progressRepository.getProgressTrick(userId, trickId);
    }

    public void updateUserTrickStatus(Long userId, Long trickId, String trickStatus) {
        progressRepository.updateUserTrickStatus(userId, trickId, trickStatus);
    }

    public void removeUserTrick(Long userId, Long trickId) {
        progressRepository.deleteUserTrick(userId, trickId);
    }

    public void addTrick(Long userId, Long trickId, String trickStatus) {
        progressRepository.addTrick(userId, trickId, trickStatus);
    }
}
