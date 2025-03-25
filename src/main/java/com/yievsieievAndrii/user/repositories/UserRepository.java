package com.yievsieievAndrii.user.repositories;

import java.util.Optional;

import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.data.repository.CrudRepository;

import com.yievsieievAndrii.user.models.User;

/**
 * UserRepository
 */

public interface UserRepository extends CouchbaseRepository<User, Long> {

  Optional<User> findByUsername(String username);

}
