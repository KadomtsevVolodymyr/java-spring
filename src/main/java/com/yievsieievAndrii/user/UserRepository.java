package com.yievsieievAndrii.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

/**
 * UserRepository
 */
@Repository
public class UserRepository {
  private final List<User> users = new ArrayList<>();

  @PostConstruct
  private void init() {
    users.add(new User("bobross", "bobross@mail.com", "{noop}1234"));
    users.add(new User("johndoe", "towers@mail.com", "{noop}1229"));
    users.add(new User("mazerati_boy", "hanged@mail.com", "{noop}11214"));
    users.add(new User("one_name", "star@mail.com", "{noop}9994"));
    users.add(new User("chelik", "magician@mail.com", "{noop}2224"));
    users.add(new User("average_car_user", "lovers_car@mail.com", "{noop}1234"));
  }

  public List<User> findAll() {
    return users;
  }

  public User findById(Long id) {
    return users.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
  }

  public User save(User user) {
    users.add(user);
    return user;
  }

  public boolean deleteById(Long id) {
    return users.removeIf(user -> user.getId().equals(id));
  }
}
