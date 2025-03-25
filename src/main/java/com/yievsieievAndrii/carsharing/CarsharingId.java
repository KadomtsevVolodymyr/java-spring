
package com.yievsieievAndrii.carsharing;

import java.io.Serializable;

import com.yievsieievAndrii.user.User;

/**
 * CarsharingId
 */
public class CarsharingId implements Serializable {

  private User user;
  private Car car;

  public CarsharingId() {

  }

  public CarsharingId(User user, Car car) {
    this.car = car;
    this.user = user;
  }

}
