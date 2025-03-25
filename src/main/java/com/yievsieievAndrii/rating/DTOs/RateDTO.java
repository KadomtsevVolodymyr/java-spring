package com.yievsieievAndrii.rating.DTOs;

import com.yievsieievAndrii.rating.models.RateEnum;

public class RateDTO {

  private Long userId;
  private String carId;
  private RateEnum rate;
  private String review;

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getCarId() {
    return carId;
  }

  public void setCarId(String carId) {
    this.carId = carId;
  }

  public String getReview() {
    return review;
  }

  public void setReview(String review) {
    this.review = review;
  }

  public RateEnum getRate() {
    return rate;
  }

  public void setRate(RateEnum rate) {
    this.rate = rate;
  }
}
