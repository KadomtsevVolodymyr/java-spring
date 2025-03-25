
package com.yievsieievAndrii.carsharing;

import java.io.Serializable;
import java.util.Objects;
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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    CarsharingId that = (CarsharingId) o;
    return Objects.equals(user, that.user) && Objects.equals(car, that.car);
  }

  @Override
  public int hashCode() {
    return Objects.hash(user, car);
  }

}
