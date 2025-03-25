package com.yievsieievAndrii.rating.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

@Document
public class Rate {

  @Id
  private String id;  

  @Field
  private Long userId;  

  @Field
  private String carId;   

  @Field
  private String review;

  @Field
  private RateEnum rate;

  public Rate() {}

  public Rate(Long userId, String carId, RateEnum rate, String review) {
    this.userId = userId;
    this.carId = carId;
    this.rate = rate;
    this.review = review;
    this.id = userId + "_" + carId; 
  }

  public String getId() {
    return id;
  }

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

  public RateEnum getRate() {
    return rate;
  }

  public void setRate(RateEnum rate) {
    this.rate = rate;
  }

  public String getReview() {
    return review;
  }

  public void setReview(String review) {
    this.review = review;
  }
}
