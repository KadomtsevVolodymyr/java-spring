package com.yievsieievAndrii.carsharing;

import java.util.List;
import java.util.Optional;

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

  public Optional<Car> getCarById(Long id) {
    return carsharingRepository.findById(id);
  }

  public Car createCar(Car car) {
    return carsharingRepository.save(car);
  }

}
