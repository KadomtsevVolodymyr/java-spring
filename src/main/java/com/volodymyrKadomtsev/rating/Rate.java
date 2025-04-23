// Rate.java
package com.volodymyrKadomtsev.rating;

import com.volodymyrKadomtsev.user.User;
import jakarta.persistence.*;

@Entity
@Table(name = "rate")
public class Rate {

  @EmbeddedId
  private RateId id;

  @ManyToOne
  @MapsId("patientId")
  @JoinColumn(name = "patient_id")
  private User patient;

  @ManyToOne
  @MapsId("doctorId")
  @JoinColumn(name = "doctor_id")
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
    this.review = review;
    this.rate = rate;
    this.id = new RateId(patient.getId(), doctor.getId());
  }

  public RateId getId() {
    return id;
  }

  public void setId(RateId id) {
    this.id = id;
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
}