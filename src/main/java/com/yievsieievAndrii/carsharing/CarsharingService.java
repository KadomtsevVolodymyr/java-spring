package com.yievsieievAndrii.carsharing;

import java.util.List;

import org.springframework.stereotype.Service;

/**
 * CarsharingService
 */
@Service
public class CarsharingService {

  private final CarsharingRepository carsharingRepository;

  public CarsharingService(CarsharingRepository carsharingRepository) {
    this.carsharingRepository = carsharingRepository;
  }

  public List<Car> getAllCars() {
    return carsharingRepository.findAll();
  }

  public Car getCarById(Long id) {
    return carsharingRepository.findById(id);
  }

  public boolean bookCar(Long carId, Long userId) {
    if(userId == null) {
      return false;
    }
    return carsharingRepository.bookCar(carId, userId);
  }

  public boolean unbookCar(Long carId, Long userId) {
    if(userId == null) {
      return false;
    }
    return carsharingRepository.unbookCar(carId, userId);
  }

}
