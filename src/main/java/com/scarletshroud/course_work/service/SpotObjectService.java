package com.scarletshroud.course_work.service;

import com.scarletshroud.course_work.entity.SpotObject;
import com.scarletshroud.course_work.repository.SpotObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpotObjectService {

    private final SpotObjectRepository spotObjectRepository;

    @Autowired
    public SpotObjectService(SpotObjectRepository spotObjectRepository) {
        this.spotObjectRepository = spotObjectRepository;
    }

    public Optional<List<SpotObject>> getSpotObjectsBySpotId(Long id) {
        return spotObjectRepository.getSpotObjectsBySpotId(id);
    }
}
