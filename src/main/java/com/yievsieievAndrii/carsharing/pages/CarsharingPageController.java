package com.yievsieievAndrii.carsharing.pages;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yievsieievAndrii.carsharing.Car;
import com.yievsieievAndrii.carsharing.CarsharingService;
import com.yievsieievAndrii.user.UserService;

/**
 * CarsharingPageController
 */
@Controller
@RequestMapping("/views/cars")
public class CarsharingPageController {

  private final CarsharingService carsharingService;
  private final UserService userService;

  public CarsharingPageController(CarsharingService carsharingService, UserService userService) {
    this.carsharingService = carsharingService;
    this.userService = userService;
  }

  @GetMapping
  public String viewCars(Model model) {
    List<Car> cars = carsharingService.getAllCars();
    model.addAttribute("cars", cars);

    return "cars";
  }

  @GetMapping("/create")
  public String createCarForm(Model model) {
    model.addAttribute("car", new Car());
    return "createCar";
  }

  @PostMapping
  public String createCar(@ModelAttribute Car car) {
    carsharingService.createCar(car);
    return "redirect:/views/cars";
  }

  @DeleteMapping("/{id}")
  public String deleteCar(@PathVariable Long id) {
    carsharingService.deleteCar(id);
    return "redirect:/views/cars";
  }

  @GetMapping("/{id}/update")
  public String showUpdateForm(@PathVariable Long id, Model model) {
    Car car = carsharingService.getCarById(id).orElseThrow(() -> new IllegalArgumentException("Invalid car id"));
    model.addAttribute("car", car);
    return "updateCar"; 
  }

  @PostMapping("/{id}/update")
  public String updateCar(@PathVariable Long id, @ModelAttribute Car car) {
    car.setId(id); 
    carsharingService.updateCar(car); 
    return "redirect:/views/cars"; 
  }

}
