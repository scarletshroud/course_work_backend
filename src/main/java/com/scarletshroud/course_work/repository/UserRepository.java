package com.scarletshroud.course_work.repository;

import com.scarletshroud.course_work.entity.Trick;
import com.scarletshroud.course_work.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findUserById(Long id);
    Optional<User> findUserByEmail(String email);

    @Modifying
    @Transactional
    @Query(value = "UPDATE USERS SET USERNAME = ?1, SPORT_ID = ?2 WHERE USERS.ID = ?3",
            nativeQuery = true)
    void updateUser(String username, Long sportId, Long userId);
}
