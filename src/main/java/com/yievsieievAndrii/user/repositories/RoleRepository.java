package com.yievsieievAndrii.user.repositories;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yievsieievAndrii.user.models.Role;

/**
 * UserRepository
 */

public interface RoleRepository extends JpaRepository<Role, Long> {

  Optional<Role> findByName(String name);


}
