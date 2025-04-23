package com.volodymyrKadomtsev.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@Service
public class UserService {

  private final List<User> users = new ArrayList<>();

  @PostConstruct
  private void init() {
    users.add(new User("anna", "anna@gmail.com", "pass123"));
    users.add(new User("dr.smith", "smith@hospital.com", "medic456"));
    users.add(new User("julia", "julia@yahoo.com", "secure789"));
    users.add(new User("dr.jones", "jones@clinic.org", "healing321"));
    users.add(new User("mark", "mark@mail.com", "markpass"));
  }

  public List<User> getAllUsers() {
    return users;
  }

  public Optional<User> getUserById(Long id) {
    return users.stream().filter(user -> user.getId().equals(id)).findFirst();
  }

  public User createUser(User user) {
    users.add(user);
    return user;
  }

  public boolean deleteUser(Long id) {
    return users.removeIf(user -> user.getId().equals(id));
  }

  public Optional<User> findByUsername(String username) {
    return users.stream().filter(u -> u.getUsername().equalsIgnoreCase(username)).findFirst();
  }
}