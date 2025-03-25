package com.yievsieievAndrii.carsharing;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

/**
 * CarsharingService
 */
@Service
public class CarsharingService {

  private final CarRepository carRepository;
  private final CarsharingRepository carsharingRepository;

  public CarsharingService(CarRepository carRepository, CarsharingRepository carsharingRepository) {
    this.carRepository = carRepository;
    this.carsharingRepository = carsharingRepository;
  }

  public List<Car> getAllCars() {
    return carRepository.findAll();
  }

  public Optional<Car> getCarById(Long id) {
    return carRepository.findById(id);
  }

  public Car createCar(Car car) {
    return carRepository.save(car);
  }

  public Carsharing bookCar(Carsharing carsharing) {
    return carsharingRepository.save(carsharing);
  }

}
