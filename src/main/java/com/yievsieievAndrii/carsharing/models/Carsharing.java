package com.yievsieievAndrii.carsharing.models;

import java.time.LocalDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.GenerationStrategy;

@Document
public class Carsharing {

  @Id
  @GeneratedValue(strategy = GenerationStrategy.UNIQUE)
  private String id;  

  @Field
  private String carId; 

  @Field
  private Long userId;

  @Field
  private LocalDate bookedAt = LocalDate.now();

  @Field
  private LocalDate expiredAt = LocalDate.now().plusDays(3);

  @Field
  private boolean isExpired = false;

  @Field
  private TariffType tariff;

  public Carsharing() {
  }

  public Carsharing(String carId, Long userId) {
    this.carId = carId;
    this.userId = userId;
    this.id = carId + "_" + userId; 
  }

  public Carsharing(String carId, Long userId, TariffType tariffType) {
    this.carId = carId;
    this.userId = userId;
    this.tariff = tariffType;
    this.id = carId + "_" + userId;
  }

  public String getId() {
    return id;
  }

  public String getCarId() {
    return carId;
  }

  public void setCarId(String carId) {
    this.carId = carId;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
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

  public TariffType getTariff() {
    return tariff;
  }

  public void setTariff(TariffType tariff) {
    this.tariff = tariff;
  }
}
