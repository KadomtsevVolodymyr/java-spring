package com.flux.flux_carsharing.user.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.flux.flux_carsharing.user.repositories.UserRepository;

import reactor.core.publisher.Mono;

@Service
public class DatabaseReactiveUserDetailsService implements ReactiveUserDetailsService {

    private final UserRepository userRepository;
        private static final Logger logger = LoggerFactory.getLogger(DatabaseReactiveUserDetailsService.class);

    public DatabaseReactiveUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public Mono<UserDetails> findByUsername(String username) {
        return userRepository.findByUsername(username)
            .doOnNext(user -> logger.info("User found in DB: {}", user)) 
            .map(user -> {
                logger.info("User {} logged in", username); 
                return org.springframework.security.core.userdetails.User
                    .withUsername(user.getUsername())
                    .password(user.getPassword())
                    .build();
            })
            .switchIfEmpty(Mono.error(new UsernameNotFoundException("User not found")));
    }
}
