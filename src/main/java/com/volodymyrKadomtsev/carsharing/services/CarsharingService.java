package com.volodymyrKadomtsev.carsharing.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.volodymyrKadomtsev.carsharing.models.Car;
import com.volodymyrKadomtsev.carsharing.models.Carsharing;
import com.volodymyrKadomtsev.carsharing.repositories.CarRepository;
import com.volodymyrKadomtsev.carsharing.repositories.CarsharingRepository;

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
    return carRepository.findAllWithBookingStatus();
  }

  public Optional<Car> getCarById(Long id) {
    return carRepository.findById(id);
  }

  public Car createCar(Car car) {
    return carRepository.save(car);
  }

  public String deleteCar(Long id) {
    carsharingRepository.deleteByCarId(id);
    carRepository.deleteById(id);
    return "deleted";
  }

  public void updateCar(Car car) {
    carRepository.save(car);
  }

  public void unbookCar(Long carId, Long userId) {
    carsharingRepository.unbookCar(carId, userId);
  }

  public Carsharing bookCar(Carsharing carsharing) {
    return carsharingRepository.save(carsharing);
  }

}
