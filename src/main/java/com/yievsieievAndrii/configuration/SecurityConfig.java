//package com.yievsieievAndrii.configuration;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
///**
// * SecurityConfig
// */
//public class SecurityConfig {
//
//  @Bean
//  public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
//    httpSecurity
//        .csrf(csrf -> csrf.disable())
//        .httpBasic(Customizer.withDefaults())
//        .formLogin(Customizer.withDefaults())
//        .authorizeHttpRequests(authorize -> authorize
//            .requestMatchers("*").permitAll()
//            .anyRequest().hasRole("ADMIN"));
//
//    return httpSecurity.build();
//  }
//
//  @Bean
//  public UserDetailsService usersDetailsService() {
//    UserDetails userDetails = User.builder()
//        .username("user")
//        .password(passwordEncoder().encode("password"))
//        .roles("ADMIN")
//        .build();
//
//    return new InMemoryUserDetailsManager(userDetails);
//  }
//
//  @Bean
//  public PasswordEncoder passwordEncoder() {
//    return new BCryptPasswordEncoder();
//  }
//
//
//}
