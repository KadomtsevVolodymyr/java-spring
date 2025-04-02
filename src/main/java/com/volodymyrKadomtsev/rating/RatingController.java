package com.volodymyrKadomtsev.rating;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ratings")
public class RatingController {

  private final RatingService ratingService;

  public RatingController(RatingService ratingService) {
    this.ratingService = ratingService;
  }

  @GetMapping
  public List<Rating> getAllRatings() {
    return ratingService.getAllRatings();
  }

  @GetMapping("/{patientId}/{doctorId}")
  public Rating getRatingById(@PathVariable Long patientId, @PathVariable Long doctorId) {
    return ratingService.getRatingById(patientId, doctorId);
  }

  @PostMapping
  public Rating createRating(@RequestBody Rating rating) {
    return ratingService.createRating(rating);
  }
}