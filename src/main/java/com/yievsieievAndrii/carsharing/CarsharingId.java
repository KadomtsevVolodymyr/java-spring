
package com.volodymyrKadomtsev.carsharing;

import java.io.Serializable;

import com.volodymyrKadomtsev.user.User;

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
