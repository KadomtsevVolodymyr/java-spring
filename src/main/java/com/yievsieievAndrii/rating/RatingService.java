package com.yievsieievAndrii.rating;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class RatingService  {

  private final RatingRepository ratingRepository;

  public RatingService(RatingRepository ratingRepository) {
    this.ratingRepository = ratingRepository;
  }

  public List<Rating> getAllRatings() {
    return ratingRepository.findAll();
  }

  public Rating getRatingById(Long userId, Long carId) {
    return ratingRepository.findById(userId, carId);
  }

  public Rating createRating(Rating rate) {
    return ratingRepository.save(rate);
  }


}
