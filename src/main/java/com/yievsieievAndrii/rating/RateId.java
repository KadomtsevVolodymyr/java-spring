package com.yievsieievAndrii.rating;

import java.io.Serializable;

import com.yievsieievAndrii.carsharing.Car;
import com.yievsieievAndrii.user.User;

/**
 * RateId
 */
public class RateId implements Serializable {

  private User user;
  private Car car;

  public RateId() {}

  public RateId(User user, Car car) {
    this.user = user;
    this.car = car;
  }
  
}
