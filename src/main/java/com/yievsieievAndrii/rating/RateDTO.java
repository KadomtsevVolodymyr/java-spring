package com.yievsieievAndrii.rating;

public class RateDTO {

  private Long userId;
  private Long carId;
  private RateEnum rate;
  private String review;

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
