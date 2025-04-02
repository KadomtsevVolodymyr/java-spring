package com.volodymyrKadomtsev.rating;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class RatingRepository {
  private final List<Rating> ratings = new ArrayList<>();

  @PostConstruct
  private void init() {
    ratings.add(new Rating(1L, 1L, RateEnum.GOOD));
    ratings.add(new Rating(2L, 2L, RateEnum.GOOD));
    ratings.add(new Rating(1L, 2L, RateEnum.BAD));
    ratings.add(new Rating(3L, 3L, RateEnum.BAD));
    ratings.add(new Rating(2L, 2L, RateEnum.NORMAL));
    ratings.add(new Rating(5L, 2L, RateEnum.EXCELLENT));
  }

  public List<Rating> findAll() {
    return ratings;
  }

  public Rating findById(Long patientId, Long doctorId) {
    return ratings.stream()
        .filter(rate -> rate.getDoctorId().equals(doctorId) && rate.getPatientId().equals(patientId))
        .findFirst()
        .orElse(null);
  }

  public Rating save(Rating rating) {
    ratings.add(rating);
    return rating;
  }

  public boolean deleteById(Long patientId, Long doctorId) {
    return ratings.removeIf(rate -> rate.getDoctorId().equals(doctorId) && rate.getPatientId().equals(patientId));
  }
}