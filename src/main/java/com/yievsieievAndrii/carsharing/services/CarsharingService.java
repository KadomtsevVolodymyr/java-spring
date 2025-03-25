package com.yievsieievAndrii.carsharing.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.yievsieievAndrii.carsharing.models.Car;
import com.yievsieievAndrii.carsharing.models.Carsharing;
import com.yievsieievAndrii.carsharing.repositories.CarRepository;
import com.yievsieievAndrii.carsharing.repositories.CarsharingRepository;

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
    return (List<Car>) carRepository.findAll();
  }

  public Optional<Car> getCarById(String id) {
    return carRepository.findById(id);
  }

  public Car createCar(Car car) {
    return carRepository.save(car);
  }

  public String deleteCar(String id) {
    carsharingRepository.deleteByCarId(id);
    carRepository.deleteById(id);
    return "deleted";
  }

  public void updateCar(Car car) {
    carRepository.save(car);
  }

  public void unbookCar(String carId, Long userId) {
    carsharingRepository.deleteByCarIdAndUserId(carId, userId);
  }

  public Carsharing bookCar(Carsharing carsharing) {
    return carsharingRepository.save(carsharing);
  }

}
