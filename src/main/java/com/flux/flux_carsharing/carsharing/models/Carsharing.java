package com.flux.flux_carsharing.carsharing.models;

import com.flux.flux_carsharing.user.models.User;

public class Carsharing {

  private Car car;

  private User user;

  private String bookedAt;

  private String expiredAt;

  private boolean isExpired;

  private TariffType tariff;

  public Carsharing() {
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

  public String getBookedAt() {
    return bookedAt;
  }

  public void setBookedAt(String bookedAt) {
    this.bookedAt = bookedAt;
  }

  public boolean isExpired() {
    return isExpired;
  }

  public void setExpired(boolean isExpired) {
    this.isExpired = isExpired;
  }

  public String getExpiredAt() {
    return expiredAt;
  }

  public void setExpiredAt(String expiredAt) {
    this.expiredAt = expiredAt;
  }

  public TariffType getTariff() {
    return tariff;
  }

  public void setTariff(TariffType tariff) {
    this.tariff = tariff;
  }

}
