package com.flux.flux_carsharing.carsharing.models;

public class Car {

  private Long id;

  private String mark;

  private String model;

  private Carsharing carsharing;

  public Long getId() {
    return id;
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

  public void setId(Long id) {
    this.id = id;
  }

  public Carsharing getCarsharing() {
    return carsharing;
  }

}
