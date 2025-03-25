package com.yievsieievAndrii.rating;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

/**
 * RatingRepository
 */
@Repository
public class RatingRepository {
  private final List<Rating> rates = new ArrayList<>();

  @PostConstruct
  private void init() {
    rates.add(new Rating(1L, 1L, RateEnum.GOOD));
    rates.add(new Rating(2L, 2L, RateEnum.GOOD));
    rates.add(new Rating(1L, 2L, RateEnum.BAD));
    rates.add(new Rating(3L, 3L, RateEnum.BAD));
    rates.add(new Rating(2L, 2L, RateEnum.NORMAL));
    rates.add(new Rating(5L, 2L, RateEnum.EXCELLENT));
  }

  public List<Rating> findAll() {
    return rates;
  }

  public Rating findById(Long userId, Long carId) {
    return rates.stream().filter(rate -> rate.getCarId().equals(carId) && rate.getUserId().equals(userId)).findFirst().orElse(null);
  }

  public Rating save(Rating rate) {
    rates.add(rate);
    return rate;
  }
  
  public boolean deleteById(Long userId, Long carId) {
    return rates.removeIf(rate -> rate.getCarId().equals(carId) && rate.getUserId().equals(userId));
  }
  
}
