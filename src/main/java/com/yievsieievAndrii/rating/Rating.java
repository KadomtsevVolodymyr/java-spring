package com.yievsieievAndrii.rating;

/**
 * Rating
 */

public class Rating {
  private Long userId;
  private Long carId;
  private RateEnum rate;

  public Rating(Long userId, Long carId, RateEnum rate) {
    this.userId = userId;
    this.carId = carId;
    this.rate = rate;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public Long getCarId() {
    return carId;
  }

  public void setCarId(Long carId) {
    this.carId = carId;
  }

  public RateEnum getRate() {
    return rate;
  }

  public void setRate(RateEnum rate) {
    this.rate = rate;
  }

}
