package com.yievsieievAndrii.carsharing.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yievsieievAndrii.carsharing.DTOs.CarsharingDTO;
import com.yievsieievAndrii.carsharing.models.Car;
import com.yievsieievAndrii.carsharing.models.Carsharing;
import com.yievsieievAndrii.carsharing.services.CarsharingService;
import com.yievsieievAndrii.user.models.User;
import com.yievsieievAndrii.user.services.UserService;

@RestController
@RequestMapping("/cars")
public class CarsharingController {

  private final CarsharingService carsharingService;
  private final UserService userService;

  public CarsharingController(CarsharingService carsharingService, UserService userService) {
    this.carsharingService = carsharingService;
    this.userService = userService;
  }

  @GetMapping
  public List<Car> getAllCars() {
    List<Car> cars = carsharingService.getAllCars();
    return cars;
  }

  @GetMapping("/{id}")
  public Optional<Car> getCarById(@PathVariable String id) {
    return carsharingService.getCarById(id);
  }

  @PostMapping
  public Car createCar(@RequestBody Car car) {
    return carsharingService.createCar(car);
  }


  @DeleteMapping("/{id}")
  public String deleteCar(@PathVariable String id) {
    return carsharingService.deleteCar(id);
  }


  @PostMapping("/{carId}")
  public Carsharing bookCar(@PathVariable String carId, @RequestBody CarsharingDTO carsharingDTO) {
    carsharingDTO.setCarId(carId);

    Carsharing carsharing = new Carsharing();

    carsharing.setTariff(carsharingDTO.getTariffType());
    carsharing.setUserId(carsharingDTO.getUserId());
    carsharing.setCarId(carId);

    carsharingService.bookCar(carsharing);


    return carsharing;
  }

  @PutMapping("/{carId}/{userId}")
  public String unbookCar(@PathVariable String carId, @PathVariable Long userId) {
    carsharingService.unbookCar(carId, userId);
    return "unbooked";
  }

}
