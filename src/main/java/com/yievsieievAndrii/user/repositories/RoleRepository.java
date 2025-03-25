package com.yievsieievAndrii.user.repositories;



import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.yievsieievAndrii.user.models.Role;

/**
 * UserRepository
 */

public interface RoleRepository extends CrudRepository<Role, Long> {

  Optional<Role> findByName(String name);


}
