package com.yievsieievAndrii.rating;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratings")
public class RatingController {
  private final RatingService RatingService;

  public RatingController(RatingService RatingService) {
    this.RatingService = RatingService;
  }

  @GetMapping
  public List<Rating> getAllRatings() {
    return RatingService.getAllRatings();
  }

  @GetMapping("/{userId}/{carId}")
  public Rating getRatingById(@PathVariable Long userId, @PathVariable Long carId) {
    return RatingService.getRatingById(userId, carId);
  }

  @PostMapping
  public Rating createRating(@RequestBody Rating rate) {
    return RatingService.createRating(rate);
  }

  
}
