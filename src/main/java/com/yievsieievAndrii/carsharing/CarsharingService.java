package com.yievsieievAndrii.carsharing;

import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.yievsieievAndrii.user.UserRepository;

/**
 * CarsharingService
 */
@Service
public class CarsharingService {

  private final CarsharingRepository carsharingRepository;
  private final UserRepository userRepository;

  public CarsharingService(CarsharingRepository carsharingRepository, UserRepository userRepository) {
    this.carsharingRepository = carsharingRepository;
    this.userRepository = userRepository;
  }

  public List<Carsharing> getAllCars() {
    return carsharingRepository.findAll();
  }

  public Carsharing getCarById(Long id) {
    return carsharingRepository.findById(id);
  }

  public boolean bookCar(Long carId) {
    String username = SecurityContextHolder.getContext().getAuthentication().getName();
    Long userId = userRepository.findAll().stream().filter(user -> user.getUsername().equals(username)).map(user -> user.getId()).findFirst().orElse(null);
    if(userId == null) {
      return false;
    }
    return carsharingRepository.bookCar(carId, userId);
  }

  public boolean unbookCar(Long carId) {
    String username = SecurityContextHolder.getContext().getAuthentication().getName();
    Long userId = userRepository.findAll().stream().filter(user -> user.getUsername().equals(username)).map(user -> user.getId()).findFirst().orElse(null);
    if(userId == null) {
      return false;
    }
    return carsharingRepository.unbookCar(carId, userId);
  }

}
