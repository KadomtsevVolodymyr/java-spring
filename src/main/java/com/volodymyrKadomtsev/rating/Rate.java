package com.volodymyrKadomtsev.rating;

import com.volodymyrKadomtsev.user.User;
import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "rate")
@IdClass(RateId.class)
public class Rate {

  @Id
  @ManyToOne
  @JoinColumn(name = "patient_id", nullable = false)
  private User patient;

  @Id
  @ManyToOne
  @JoinColumn(name = "doctor_id", nullable = false)
  private User doctor;

  @Column(length = 2048, nullable = false)
  private String review;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private RateEnum rate;

  public Rate() {
  }

  public Rate(User patient, User doctor, RateEnum rate, String review) {
    this.patient = patient;
    this.doctor = doctor;
    this.rate = rate;
    this.review = review;
  }

  public User getPatient() {
    return patient;
  }

  public void setPatient(User patient) {
    this.patient = patient;
  }

  public User getDoctor() {
    return doctor;
  }

  public void setDoctor(User doctor) {
    this.doctor = doctor;
  }

  public RateEnum getRate() {
    return rate;
  }

  public void setRate(RateEnum rate) {
    this.rate = rate;
  }

  public String getReview() {
    return review;
  }

  public void setReview(String review) {
    this.review = review;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Rate)) return false;
    Rate that = (Rate) o;
    return Objects.equals(patient, that.patient) &&
           Objects.equals(doctor, that.doctor);
  }

  @Override
  public int hashCode() {
    return Objects.hash(patient, doctor);
  }
}