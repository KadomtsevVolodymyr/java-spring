package com.flux.flux_carsharing.carsharing.services;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.flux.flux_carsharing.carsharing.DTOs.CarsharingDTO;
import com.flux.flux_carsharing.carsharing.models.Car;
import com.flux.flux_carsharing.carsharing.models.Carsharing;
import com.flux.flux_carsharing.configuration.WebClientConfig;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * CarsharingService
 */
@Service
public class CarsharingService {

  private final WebClient webClient;

  public CarsharingService(WebClient webClient) {
    this.webClient = webClient;
  }

  public Flux<Car> getAllCars() {
    return webClient
        .get()
        .uri("/cars")
        .retrieve()
        .bodyToFlux(Car.class);
  }

  public Mono<Car> getCarById(Long id) {
    return webClient
        .get()
        .uri("/cars/{id}", id)
        .retrieve()
        .bodyToMono(Car.class);
  }

  public Mono<Car> createCar(Car car) {
    return webClient
        .post()
        .uri("/cars")
        .bodyValue(car)
        .retrieve()
        .bodyToMono(Car.class);
  }

  public Mono<String> deleteCar(Long id) {
    return webClient
        .delete()
        .uri("/cars/{id}", id)
        .retrieve()
        .bodyToMono(String.class);
  }

  public Mono<Carsharing> bookCar(Long carId, CarsharingDTO carsharingDTO) {
    return webClient
        .post()
        .uri("/cars/{carId}", carId)
        .bodyValue(carsharingDTO)
        .retrieve()
        .bodyToMono(Carsharing.class);
  }

  public Mono<String> unbookCar(Long carId, Long userId) {
    return webClient
        .put()
        .uri("/cars/{carId}/{userId}", carId, userId)
        .retrieve()
        .bodyToMono(String.class);
  }

  // pages
  public Mono<String> getCarsPage() {
    return webClient
        .get()
        .uri("/views/cars")
        .retrieve()
        .bodyToMono(String.class);

  }
}
