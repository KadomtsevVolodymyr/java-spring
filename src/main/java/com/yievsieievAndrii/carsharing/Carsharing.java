package com.yievsieievAndrii.carsharing;

import java.time.LocalDate;

import com.yievsieievAndrii.user.User;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Carsharing
 */
@Entity
@Table(name = "carsharing")
@IdClass(CarsharingId.class)
public class Carsharing {

  @ManyToOne
  @Id
  @JoinColumn(name = "car_id", nullable = false)
  private Car car;

  @ManyToOne
  @Id
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  private LocalDate bookedAt = LocalDate.now();

  private LocalDate expiredAt = LocalDate.now().plusDays(3);

  private boolean isExpired = false;

  public Carsharing() {
  }

  public Carsharing(Car car, User user) {
    this.car = car;
    this.user = user;
  }

  public Car getCar() {
    return car;
  }

  public void setCar(Car car) {
    this.car = car;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public LocalDate getBookedAt() {
    return bookedAt;
  }

  public void setBookedAt(LocalDate bookedAt) {
    this.bookedAt = bookedAt;
  }

  public boolean isExpired() {
    return isExpired;
  }

  public void setExpired(boolean isExpired) {
    this.isExpired = isExpired;
  }

  public LocalDate getExpiredAt() {
    return expiredAt;
  }

  public void setExpiredAt(LocalDate expiredAt) {
    this.expiredAt = expiredAt;
  }

}
