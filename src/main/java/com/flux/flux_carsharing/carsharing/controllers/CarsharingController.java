package com.flux.flux_carsharing.carsharing.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flux.flux_carsharing.carsharing.DTOs.CarsharingDTO;
import com.flux.flux_carsharing.carsharing.models.Car;
import com.flux.flux_carsharing.carsharing.models.Carsharing;
import com.flux.flux_carsharing.carsharing.services.CarsharingService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/cars")
public class CarsharingController {

  private final CarsharingService carsharingService;

  public CarsharingController(CarsharingService carsharingService) {
    this.carsharingService = carsharingService;
  }

  @GetMapping
  public Flux<Car> getAllCars() {
    return carsharingService.getAllCars();
  }

  @GetMapping("/{id}")
  public Mono<Car> getCarById(@PathVariable Long id) {
    return carsharingService.getCarById(id);
  }

  @PostMapping
  public Mono<Car> createCar(@RequestBody Car car) {
    return carsharingService.createCar(car);
  }

  @DeleteMapping("/{id}")
  public Mono<String> deleteCar(@PathVariable Long id) {
    return carsharingService.deleteCar(id);
  }

  @PostMapping("/{carId}")
  public Mono<Carsharing> bookCar(@RequestBody CarsharingDTO dto, @PathVariable Long carId) {
    return carsharingService.bookCar(carId, dto);
  }

  @PutMapping("/{carId}/{userId}")
  public Mono<String> unbookCar(@PathVariable Long carId, @PathVariable Long userId) {
    return carsharingService.unbookCar(carId, userId);
  }


}

