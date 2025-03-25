package com.yievsieievAndrii.rating.models;

import java.io.Serializable;

import com.yievsieievAndrii.carsharing.models.Car;
import com.yievsieievAndrii.user.models.User;

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
