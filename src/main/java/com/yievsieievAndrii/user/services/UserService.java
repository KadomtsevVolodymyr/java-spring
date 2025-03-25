package com.yievsieievAndrii.user.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.yievsieievAndrii.user.models.User;
import com.yievsieievAndrii.user.repositories.UserRepository;

@Service
public class UserService {

  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  public Optional<User> getUserById(Long id) {
    return userRepository.findById(id);
  }

  public User createUser(User user) {
    return userRepository.save(user);
  }

  public String deleteUser(Long id) {
    userRepository.deleteById(id);
    return "deleted";
  }

  public Optional<User> getUserByUsername(String username) {
    return userRepository.findByUsername(username);
  }

}
