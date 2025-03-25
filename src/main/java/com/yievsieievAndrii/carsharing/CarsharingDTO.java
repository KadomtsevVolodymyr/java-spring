package com.yievsieievAndrii.carsharing;

import java.time.LocalDate;

public class CarsharingDTO {

  private Long userId;
  private Long carId;

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

  public Long getCarId() {
    return carId;
  }

  public void setCarId(Long carId) {
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
