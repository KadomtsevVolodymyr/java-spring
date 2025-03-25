package com.yievsieievAndrii.rating;

import java.util.Optional;

import com.yievsieievAndrii.carsharing.Car;
import com.yievsieievAndrii.user.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Rating
 */

@Entity
@Table(name = "rate")
@IdClass(RateId.class)
public class Rate {


  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  @Id
  private User user;

  @ManyToOne
  @JoinColumn(name = "car_id", nullable = false)
  @Id
  private Car car;

  @Column(length = 2048, nullable = false)
  private String review;

  @Enumerated(EnumType.STRING)
  private RateEnum rate;

  public Rate() {}

  public Rate(User user, Car car, RateEnum rate, String review) {
    this.user = user;
    this.car = car;
    this.rate = rate;
    this.review = review;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Car getCar() {
    return car;
  }

  public void setCar(Car car) {
    this.car = car;
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
