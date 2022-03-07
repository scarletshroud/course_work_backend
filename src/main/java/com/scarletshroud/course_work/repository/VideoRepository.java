package com.scarletshroud.course_work.repository;

import com.scarletshroud.course_work.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface VideoRepository extends JpaRepository<Video, Long> {
    @Query(value =
            "SELECT * FROM VIDEO " +
                    "INNER JOIN SPOT_VIDEOS ON VIDEO.ID = SPOT_VIDEOS.VIDEO_ID " +
                    "WHERE SPOT_VIDEOS.SPOT_ID = ?1",
            nativeQuery = true)
    Optional<List<Video>> getSpotVideosBySpotId(Long id);

    Optional<Video> findById(Long id);
}

