package com.flux.flux_carsharing.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;

import com.flux.flux_carsharing.user.services.DatabaseReactiveUserDetailsService;


@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    private final DatabaseReactiveUserDetailsService userDetailsService;

    public SecurityConfig(DatabaseReactiveUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        return http
            .csrf(ServerHttpSecurity.CsrfSpec::disable)
            .authorizeExchange(exchanges -> exchanges
                .pathMatchers("/", "/auth/register", "/auth/login").permitAll()
                .anyExchange().authenticated()
            )
            .httpBasic(Customizer.withDefaults()) 
            .formLogin(Customizer.withDefaults()) 
            .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}