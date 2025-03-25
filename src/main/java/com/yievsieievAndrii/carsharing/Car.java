package com.yievsieievAndrii.carsharing;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "cars")
public class Car {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank(message = "Mark cannot be empty")
  @Size(min = 2, message = "Mark must be at least 2 characters")
  @Column(nullable = false)
  private String mark;

  @NotBlank(message = "Model cannot be empty")
  @Column(nullable = false)
  private String model;

  @OneToOne(mappedBy = "car", fetch = FetchType.LAZY)
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
