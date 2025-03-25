package com.yievsieievAndrii.carsharing;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

/**
 * CarsharingRepository
 */
@Repository
public class CarsharingRepository {

  private final List<Carsharing> cars = new ArrayList<>();

  @PostConstruct
  private void init() {
    cars.add(new Carsharing("Toyota", "Supra"));
    cars.add(new Carsharing("Nissan", "Skyline R34 GTR"));
    cars.add(new Carsharing("Honda", "Civic"));
    cars.add(new Carsharing("Toyota", "AE86"));
    cars.add(new Carsharing("Mazda", "RX7"));
  }

  // Make a logic where cars available (userId = null)
  public List<Carsharing> findAll() {
    return cars;
  }

  public Carsharing findById(Long id) {
    return cars.stream().filter(car -> car.getId().equals(id)).findFirst().orElse(null);
  }

  public boolean bookCar(Long carId, Long userId) {

    Carsharing car = findById(carId);
    if (car != null && car.getUserId() == null) {
      car.setUserId(userId);
      car.setIsBooked(true);
      return true;
    }
    return false;
  }

  public boolean unbookCar(Long carId, Long userId) {
    Carsharing car = findById(carId);
    if (car != null && car.getUserId() != null) {
      car.setUserId(null);
      car.setIsBooked(false);
      return true;
    }
    return false;
  }

}
