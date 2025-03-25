//package com.flux.flux_carsharing.carsharing.views;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.flux.flux_carsharing.carsharing.models.Car;
//import com.flux.flux_carsharing.carsharing.services.CarsharingService;
//
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;
//
///**
// * CarsharingPagesController
// */
//@Controller
//@RequestMapping("/views/cars")
//public class CarsharingPagesController {
//
//  private final CarsharingService carsharingService;
//
//  public CarsharingPagesController(CarsharingService carsharingService) {
//    this.carsharingService = carsharingService;
//  }
//
//  @GetMapping
//  public Mono<String> viewCars(Model model) {
//    return carsharingService
//    .getCarsPage()
//    .doOnNext(html -> model.addAttribute("htmlContent", html))
//    .thenReturn("cars");
//  }
//
//  // @GetMapping("/create")
//  // public String createCarForm(Model model) {
//  // }
//  //
//  // @PostMapping
//  // public String createCar(@ModelAttribute Car car, BindingResult bindingResult,
//  // Model model) {
//  // }
//  //
//  // @DeleteMapping("/{id}")
//  // public String deleteCar(@PathVariable Long id) {
//  // }
//  //
//  // @GetMapping("/{id}/update")
//  // public String showUpdateForm(@PathVariable Long id, Model model) {
//  // }
//  //
//  // @PostMapping("/{id}/update")
//  // public String updateCar(@PathVariable Long id, @ModelAttribute Car car,
//  // BindingResult bindingResult, Model model) {
//  // }
//  //
//  // @PutMapping("/{id}/bookCar")
//  // public String bookCar(@PathVariable Long id) {
//  // }
//  //
//  //
//  //
//  // @PutMapping("/{id}/unbookCar")
//  // public String unbookCar(@PathVariable Long id) {
//  // }
//
//}
