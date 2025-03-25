package com.yievsieievAndrii.carsharing.DTOs;

import java.time.LocalDate;

import com.yievsieievAndrii.carsharing.models.TariffType;

public class CarsharingDTO {

  private Long userId;
  private String carId;

  private LocalDate date;
  private LocalDate expiredAt;
  private String isExpired;
  private TariffType tariffType;

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

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public String getIsExpired() {
    return isExpired;
  }

  public void setIsExpired(String isExpired) {
    this.isExpired = isExpired;
  }

  public LocalDate getExpiredAt() {
    return expiredAt;
  }

  public void setExpiredAt(LocalDate expiredAt) {
    this.expiredAt = expiredAt;
  }

  public TariffType getTariffType() {
    return tariffType;
  }

  public void setTariffType(TariffType tariffType) {
    this.tariffType = tariffType;
  }

}
