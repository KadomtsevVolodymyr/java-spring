package com.yievsieievAndrii.carsharing;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cars")
public class CarsharingController {

  private final CarsharingService carsharingService;

  public CarsharingController(CarsharingService carsharingService) {
    this.carsharingService = carsharingService;
  }

  @GetMapping
  public List<Car> getAllCars() {
    return carsharingService.getAllCars();
  }

  @GetMapping("/{id}")
  public Optional<Car> getCarById(@PathVariable Long id) {
    return carsharingService.getCarById(id);
  }

  @PostMapping
  public Car createCar(@RequestBody Car car) {
    return carsharingService.createCar(car);
  }

  // @GetMapping("/page")
  // public String viewCars(Model model) {
  // model.addAttribute("message", "Hello World");
  //
  // return "index";
  // }

  // @PostMapping("/{carId}/{userId}")
  // public boolean bookCar(@PathVariable Long carId, @PathVariable Long userId) {
  // return carsharingService.bookCar(carId, userId);
  // }

  // @DeleteMapping("/{carId}/{userId}")
  // public boolean unbookCar(@PathVariable Long carId, @PathVariable Long userId)
  // {
  // return carsharingService.unbookCar(carId, userId);
  // }

}
