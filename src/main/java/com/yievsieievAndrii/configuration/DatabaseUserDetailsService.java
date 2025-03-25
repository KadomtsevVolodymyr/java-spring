
package com.yievsieievAndrii.configuration;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.yievsieievAndrii.user.User;
import com.yievsieievAndrii.user.Role;
import com.yievsieievAndrii.user.UserRepository;

/**
 * DatabaseUserDetailsService
 */
@Service
public class DatabaseUserDetailsService implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException("user not found: " + username));
    return new org.springframework.security.core.userdetails.User(
        user.getUsername(),
        user.getPassword(),
        user.getRoles().stream()
            .map(Role::getName)
            .map(SimpleGrantedAuthority::new)
            .collect(Collectors.toList()));

  }

}
