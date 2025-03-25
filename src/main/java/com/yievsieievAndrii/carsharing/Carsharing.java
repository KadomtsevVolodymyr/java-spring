package com.yievsieievAndrii.carsharing;

public class Carsharing {

  private Long id;

  private static Long incrementId = 1L;

  private String mark;
  private String model;
  private Boolean isBooked = false;

  private Long userId = null;

  public Carsharing(String mark, String model) {
    this.id = Carsharing.incrementId++;
    this.mark = mark;
    this.model = model;
  }

  public Long getId() {
    return id;
  }

  public static Long getIncrementId() {
    return incrementId;
  }

  public static void setIncrementId(Long incrementId) {
    Carsharing.incrementId = incrementId;
  }

  public String getMark() {
    return mark;
  }

  public void setMark(String mark) {
    this.mark = mark;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public Boolean getIsBooked() {
    return isBooked;
  }

  public void setIsBooked(Boolean isBooked) {
    this.isBooked = isBooked;
  }

}
