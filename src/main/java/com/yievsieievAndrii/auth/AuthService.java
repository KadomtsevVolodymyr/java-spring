
package com.yievsieievAndrii.auth;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.yievsieievAndrii.user.Role;
import com.yievsieievAndrii.user.RoleRepository;
import com.yievsieievAndrii.user.User;
import com.yievsieievAndrii.user.UserRepository;

/**
 * AuthService
 */
@Service
public class AuthService {


  @Autowired
  private UserRepository userRepository;

  @Autowired
  private RoleRepository roleRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  //@Autowired
  //private JwtTokenProvider provider;
  //
  //@Autowired
  //private AuthenticationManager authenticationManager;

  public void registerUser(RegisterRequest request) {
    if (userRepository.findByUsername(request.getUsername()).isPresent()) {
      throw new RuntimeException("Username already exists");
    }

    User user = new User();
    user.setUsername(request.getUsername());
    user.setEmail(request.getEmail());
    user.setPassword(passwordEncoder.encode(request.getPassword()));

    Role role = roleRepository.findByName("USER")
        .orElseThrow(() -> new RuntimeException("Role not found!"));
    user.setRoles(Collections.singleton(role));

    userRepository.save(user);
  }


  public void registerUser(User user) {
    if (userRepository.findByUsername(user.getUsername()).isPresent()) {
      throw new RuntimeException("Username already exists");
    }

    // Кодируем пароль
    user.setPassword(passwordEncoder.encode(user.getPassword()));

    // Присваиваем роль USER
    Role role = roleRepository.findByName("USER")
        .orElseThrow(() -> new RuntimeException("Role not found!"));
    user.setRoles(Collections.singleton(role));

    // Сохраняем пользователя в базе данных
    userRepository.save(user);
  }

  //public String login(AuthRequest request) {
  //  try {
  //    Authentication authentication = authenticationManager.authenticate(
  //        new UsernamePasswordAuthenticationToken(
  //            request.getUsername(), request.getPassword()));
  //
  //    SecurityContextHolder.getContext().setAuthentication(authentication);
  //    return provider.generateToken(authentication);
  //  } catch (AuthenticationException e) {
  //    throw new RuntimeException("Invalid username or password");
  //  }
  //}

}
