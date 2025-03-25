package com.yievsieievAndrii.carsharing;

import com.yievsieievAndrii.user.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cars")
public class Car {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String mark;

  @Column(nullable = false)
  private String model;

  private Boolean isBooked = false;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = true)
  private User user;


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

  public User getUserId() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Boolean getIsBooked() {
    return isBooked;
  }

  public void setIsBooked(Boolean isBooked) {
    this.isBooked = isBooked;
  }

}
