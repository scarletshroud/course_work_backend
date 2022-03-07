package com.scarletshroud.course_work.service;

import com.scarletshroud.course_work.entity.Photo;
import com.scarletshroud.course_work.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhotoService {
    private final PhotoRepository photoRepository;

    @Autowired
    public PhotoService(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    public Optional<Photo> getPhotoByAuthorId(Long id, String tag) {
        return photoRepository.findByAuthorId(id, tag);
    }

    public Optional<List<Photo>> getSpotPhotosById(Long id) {
        return photoRepository.getSpotPhotosById(id);
    }
}
