package com.volodymyrKadomtsev.rating;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(RateId.class)
@Table(name = "ratings")
public class Rating implements Serializable {

  @Id
  private Long patientId;

  @Id
  private Long doctorId;

  @Enumerated(EnumType.STRING)
  private RateEnum rate;

  public Rating() {
  }

  public Rating(Long patientId, Long doctorId, RateEnum rate) {
    this.patientId = patientId;
    this.doctorId = doctorId;
    this.rate = rate;
  }

  public Long getPatientId() {
    return patientId;
  }

  public void setPatientId(Long patientId) {
    this.patientId = patientId;
  }

  public Long getDoctorId() {
    return doctorId;
  }

  public void setDoctorId(Long doctorId) {
    this.doctorId = doctorId;
  }

  public RateEnum getRate() {
    return rate;
  }

  public void setRate(RateEnum rate) {
    this.rate = rate;
  }
}