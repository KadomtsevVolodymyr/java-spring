package com.yievsieievAndrii.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * UserRepository
 */

public interface UserRepository extends JpaRepository<User, Long> {

  @Query("SELECT u FROM User u WHERE u.id = ?1")
  Optional<User> findById(Long id);


  Optional<User> findByUsername(String username);

}
