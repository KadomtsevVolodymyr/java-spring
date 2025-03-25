package com.yievsieievAndrii.user;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * UserRepository
 */

public interface RoleRepository extends JpaRepository<Role, Long> {

  Optional<Role> findByName(String name);


}
