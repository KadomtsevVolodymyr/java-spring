package com.volodymyrKadomtsev.rating.models;

import java.io.Serializable;

import com.volodymyrKadomtsev.carsharing.models.Car;
import com.volodymyrKadomtsev.user.models.User;

/**
 * RateId
 */
public class RateId implements Serializable {

  private User user;
  private Car car;

  public RateId() {
  }

  public RateId(User user, Car car) {
    this.user = user;
    this.car = car;
  }

}
