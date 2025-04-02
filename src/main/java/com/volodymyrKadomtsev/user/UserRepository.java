package com.volodymyrKadomtsev.user;

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
    users.add(new User("anna_patient", "anna@gmail.com", "pass123"));
    users.add(new User("dr.smith", "smith@hospital.com", "medic456"));
    users.add(new User("julia_patient", "julia@yahoo.com", "secure789"));
    users.add(new User("dr.jones", "jones@clinic.org", "healing321"));
    users.add(new User("mark_patient", "mark@mail.com", "markpass"));
    users.add(new User("dr.watson", "watson@healthcare.com", "doctor007"));
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
