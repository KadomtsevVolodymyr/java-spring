package com.yievsieievAndrii.rating.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.yievsieievAndrii.rating.models.Rate;
import com.yievsieievAndrii.rating.repositories.RatingRepository;

@Service
public class RatingService  {

  private final RatingRepository ratingRepository;

  public RatingService(RatingRepository ratingRepository) {
    this.ratingRepository = ratingRepository;
  }

  public List<Rate> getAllRatings() {
    return (List<Rate>) ratingRepository.findAll();
  }

  //public Optional<Rate> getRatingById(Long rateId) {
  //  return ratingRepository.findById(rateId);
  //}

  public Rate createRating(Rate rate) {
    return ratingRepository.save(rate);
  }


}
