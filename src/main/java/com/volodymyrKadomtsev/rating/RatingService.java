package com.volodymyrKadomtsev.rating;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class RatingService {

  private final RatingRepository ratingRepository;

  public RatingService(RatingRepository ratingRepository) {
    this.ratingRepository = ratingRepository;
  }

  public List<Rating> getAllRatings() {
    return ratingRepository.findAll();
  }

  public Rating getRatingById(Long patientId, Long doctorId) {
    return ratingRepository.findById(patientId, doctorId);
  }

  public Rating createRating(Rating rating) {
    return ratingRepository.save(rating);
  }
}