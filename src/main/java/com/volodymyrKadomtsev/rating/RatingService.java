package com.volodymyrKadomtsev.rating;

import java.util.List;
import java.util.Optional;

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
    RateId id = new RateId(patientId, doctorId);
    return ratingRepository.findById(id).orElse(null);
  }

  public Rating createRating(Rating rating) {
    return ratingRepository.save(rating);
  }

  public void deleteRating(Long patientId, Long doctorId) {
    ratingRepository.deleteById(new RateId(patientId, doctorId));
  }
}