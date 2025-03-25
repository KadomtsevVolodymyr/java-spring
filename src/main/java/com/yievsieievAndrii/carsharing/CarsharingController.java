package com.yievsieievAndrii.carsharing;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

  //@GetMapping("/page")
  //public String viewCars(Model model) {
  //  model.addAttribute("message", "Hello World");
  //
  //  return "index";
  //}

  @GetMapping("/{id}")
  public Car getCarById(@PathVariable Long id) {
    return carsharingService.getCarById(id);

  }

  @PostMapping("/{carId}/{userId}")
  public boolean bookCar(@PathVariable Long carId, @PathVariable Long userId) {
    return carsharingService.bookCar(carId, userId);
  }

  @DeleteMapping("/{carId}/{userId}")
  public boolean unbookCar(@PathVariable Long carId, @PathVariable Long userId) {
    return carsharingService.unbookCar(carId, userId);
  }

}
