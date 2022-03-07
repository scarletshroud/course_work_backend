package com.scarletshroud.course_work.service;

import com.scarletshroud.course_work.entity.Photo;
import com.scarletshroud.course_work.entity.Video;
import com.scarletshroud.course_work.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VideoService {

    private final VideoRepository videoRepository;

    @Autowired
    public VideoService(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    public Optional<List<Video>> getSpotVideosBySpotId(Long id) {
        return videoRepository.getSpotVideosBySpotId(id);
    }

    public Optional<Video> getVideoById(Long id) {
        return videoRepository.findById(id);
    }
}
