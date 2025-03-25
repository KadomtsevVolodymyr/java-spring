package com.yievsieievAndrii.carsharing.pages;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

import com.yievsieievAndrii.carsharing.models.Car;
import com.yievsieievAndrii.carsharing.models.Carsharing;
import com.yievsieievAndrii.carsharing.services.CarsharingService;
import com.yievsieievAndrii.user.models.User;
import com.yievsieievAndrii.user.services.UserService;

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
  public String deleteCar(@PathVariable String id) {
    System.out.println(id);
    carsharingService.deleteCar(id);
    return REDIRECT_CARS;
  }

  @GetMapping("/{id}/update")
  public String showUpdateForm(@PathVariable String id, Model model) {
    Car car = carsharingService.getCarById(id).orElseThrow(() -> new IllegalArgumentException("Invalid car id"));
    model.addAttribute("car", car);
    return "updateCar"; 
  }

  @PostMapping("/{id}/update")
  public String updateCar(@PathVariable String id, @Valid @ModelAttribute Car car, BindingResult bindingResult, Model model) {
    if(bindingResult.hasErrors()) {
      model.addAttribute("car", car);
      return "updateCar";
    }
    car.setId(id); 
    carsharingService.updateCar(car); 
    return REDIRECT_CARS; 
  }

  @PutMapping("/{id}/bookCar")
  public String bookCar(@PathVariable String id) {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    String username = authentication.getName();
    Car car = carsharingService.getCarById(id).orElseThrow(() -> new IllegalArgumentException("Invalid car id"));
    User user = userService.getUserByUsername(username).orElseThrow(() -> new IllegalArgumentException("User not found"));
    Carsharing carsharing = new Carsharing(car.getId(), user.getId());
    carsharingService.bookCar(carsharing);

    return REDIRECT_CARS;
  }



  @PutMapping("/{id}/unbookCar")
  public String unbookCar(@PathVariable String id) {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    String username = authentication.getName();
    User user = userService.getUserByUsername(username).orElseThrow(() -> new IllegalArgumentException("User not found"));
    carsharingService.unbookCar(id, user.getId());
    return REDIRECT_CARS;
  }

}
