package com.volodymyrKadomtsev.rating;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.volodymyrKadomtsev.carsharing.Car;
import com.volodymyrKadomtsev.carsharing.CarsharingService;
import com.volodymyrKadomtsev.user.User;
import com.volodymyrKadomtsev.user.UserRepository;
import com.volodymyrKadomtsev.user.UserService;

@RestController
@RequestMapping("/ratings")
public class RatingController {
  private final RatingService RatingService;
  private final UserService userService;
  private final CarsharingService carsharingService;

  public RatingController(RatingService RatingService, UserService userService, CarsharingService carsharingService) {
    this.RatingService = RatingService;
    this.userService = userService;
    this.carsharingService = carsharingService;
  }

  @GetMapping
  public List<Rate> getAllRatings() {
    return RatingService.getAllRatings();
  }

  // @GetMapping("/{rateId}")
  // public Optional<Rate> getRatingById(@PathVariable Long rateId) {
  // return RatingService.getRatingById(rateId);
  // }

  @PostMapping
  public Rate createRating(@RequestBody RateDTO rateDTO) {

    User user = userService.getUserById(rateDTO.getUserId())
        .orElseThrow(() -> new IllegalArgumentException(""));

    Car car = carsharingService.getCarById(rateDTO.getCarId())
        .orElseThrow(() -> new IllegalArgumentException(""));

    Rate rate = new Rate(user, car, rateDTO.getRate(), rateDTO.getReview());

    return RatingService.createRating(rate);
  }

}
