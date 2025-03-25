package com.yievsieievAndrii.carsharing.pages;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yievsieievAndrii.carsharing.Car;
import com.yievsieievAndrii.carsharing.Carsharing;
import com.yievsieievAndrii.carsharing.CarsharingService;
import com.yievsieievAndrii.user.User;
import com.yievsieievAndrii.user.UserService;

import jakarta.validation.Valid;

/**
 * CarsharingPageController
 */
@Controller
@RequestMapping("/views/cars")
public class CarsharingPageController {

  private static final String REDIRECT_CARS = "redirect:/views/cars";

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
  public String createCar(@Valid @ModelAttribute Car car, BindingResult bindingResult, Model model) {
    if(bindingResult.hasErrors()) {
      model.addAttribute("car", car);
      return "createCar";
    }
    carsharingService.createCar(car);
    return REDIRECT_CARS;
  }

  @DeleteMapping("/{id}")
  public String deleteCar(@PathVariable Long id) {
    System.out.println(id);
    carsharingService.deleteCar(id);
    return REDIRECT_CARS;
  }

  @GetMapping("/{id}/update")
  public String showUpdateForm(@PathVariable Long id, Model model) {
    Car car = carsharingService.getCarById(id).orElseThrow(() -> new IllegalArgumentException("Invalid car id"));
    model.addAttribute("car", car);
    return "updateCar"; 
  }

  @PostMapping("/{id}/update")
  public String updateCar(@PathVariable Long id, @Valid @ModelAttribute Car car, BindingResult bindingResult, Model model) {
    if(bindingResult.hasErrors()) {
      model.addAttribute("car", car);
      return "updateCar";
    }
    car.setId(id); 
    carsharingService.updateCar(car); 
    return REDIRECT_CARS; 
  }

  //@PutMapping("/{id}/bookCar")
  //public String bookCar(@PathVariable Long id) {
  //  Car car = carsharingService.getCarById(id).orElseThrow(() -> new IllegalArgumentException("Invalid car id"));
  //  User user = userService.getUserById(1L).orElseThrow(() -> new IllegalArgumentException("Invalid user id"));
  //  Carsharing carsharing = new Carsharing(car, user);
  //  carsharingService.bookCar(carsharing);
  //
  //  return REDIRECT_CARS;
  //}



  @PutMapping("/{id}/unbookCar")
  public String unbookCar(@PathVariable Long id) {
    carsharingService.unbookCar(id, 1L);
    return REDIRECT_CARS;
  }

}
