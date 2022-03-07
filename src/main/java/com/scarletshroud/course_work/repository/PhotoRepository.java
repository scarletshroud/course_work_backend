package com.scarletshroud.course_work.repository;

import com.scarletshroud.course_work.entity.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PhotoRepository extends JpaRepository<Photo, Long> {
    @Query(value =
            "SELECT * FROM PHOTO " +
                    "WHERE PHOTO.author_id = ?1 AND PHOTO.TAG = ?2",
            nativeQuery = true)
    Optional<Photo> findByAuthorId(Long id, String tag);

    @Query(value =
            "SELECT * FROM PHOTO " +
                    "INNER JOIN SPOT_PHOTOS ON PHOTO.ID = SPOT_PHOTOS.PHOTO_ID " +
                    "WHERE SPOT_PHOTOS.SPOT_ID = ?1",
            nativeQuery = true)
    Optional<List<Photo>> getSpotPhotosById(Long id);
}
