package com.flux.flux_carsharing.user.repositories;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import com.flux.flux_carsharing.user.models.User;

import reactor.core.publisher.Mono;

/**
 * UserRepository
 */
public interface UserRepository extends R2dbcRepository<User, Long> {
  Mono<User> findByUsername(String username);
}
