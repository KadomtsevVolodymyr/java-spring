package com.yievsieievAndrii.carsharing;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yievsieievAndrii.user.User;
import com.yievsieievAndrii.user.UserService;

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
    System.out.println(cars);
    return cars;
  }

  @GetMapping("/{id}")
  public Optional<Car> getCarById(@PathVariable Long id) {
    return carsharingService.getCarById(id);
  }

  @PostMapping
  public Car createCar(@RequestBody Car car) {
    return carsharingService.createCar(car);
  }


  @PostMapping("/{carId}")
  public Carsharing bookCar(@RequestBody CarsharingDTO carsharingDTO) {
    Car car = carsharingService.getCarById(carsharingDTO.getCarId()).orElseThrow(() -> new IllegalArgumentException());
    User user = userService.getUserById(carsharingDTO.getUserId()).orElseThrow(() -> new IllegalArgumentException());

    Carsharing carsharing = new Carsharing(car, user);
    carsharingService.bookCar(carsharing);


    return carsharing;
  }

}
