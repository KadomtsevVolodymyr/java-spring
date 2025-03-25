package com.yievsieievAndrii.carsharing;


import java.util.HashMap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
@RestController
public class CarsharingApplication {

  private HashMap<Integer, String> cars = new HashMap<>();

  @PostConstruct
  public void init() {
    cars.put(1, "Toyota Supra");
    cars.put(2, "Nissan Skyline R34 GTR");
    cars.put(3, "Honda Civic");
    cars.put(4, "Toyota AE86");
    cars.put(5, "Mitsubishi Lancer Evo VIII");
    cars.put(6, "Mazda RX7");
  }

	public static void main(String[] args) {
		SpringApplication.run(CarsharingApplication.class, args);
	}


  @GetMapping("/available")
  public String helloWorld() {
    StringBuilder carsString = new StringBuilder();
    cars.forEach((key, value) -> carsString.append("ID: ").append(key).append(" Car: ").append(value).append("<br>"));
    return carsString.toString();
  }


}
