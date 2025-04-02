package com.volodymyrKadomtsev.user.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.volodymyrKadomtsev.user.models.Role;

/**
 * UserRepository
 */

public interface RoleRepository extends JpaRepository<Role, Long> {

  Optional<Role> findByName(String name);

}
