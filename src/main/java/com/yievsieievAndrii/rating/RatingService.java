package com.yievsieievAndrii.rating;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class RatingService  {

  private final RatingRepository ratingRepository;

  public RatingService(RatingRepository ratingRepository) {
    this.ratingRepository = ratingRepository;
  }

  public List<Rate> getAllRatings() {
    return ratingRepository.findAll();
  }

  //public Optional<Rate> getRatingById(Long rateId) {
  //  return ratingRepository.findById(rateId);
  //}

  public Rate createRating(Rate rate) {
    return ratingRepository.save(rate);
  }


}
