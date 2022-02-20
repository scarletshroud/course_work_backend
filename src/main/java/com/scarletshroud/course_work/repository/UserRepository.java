package com.scarletshroud.course_work.repository;

import com.scarletshroud.course_work.entity.Trick;
import com.scarletshroud.course_work.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findUserById(Long id);
    Optional<User> findUserByEmail(String email);

    @Query(value = "UPDATE USERS SET USERNAME = ?2, SPORT_ID = ?3 WHERE USERS.ID = ?1",
            nativeQuery = true)
    void updateUser(Long userId, String username, Long sportId);
}
