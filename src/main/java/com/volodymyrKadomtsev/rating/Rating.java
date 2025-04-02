package com.volodymyrKadomtsev.rating;

public class Rating {
  private Long patientId;
  private Long doctorId;
  private RateEnum rate;

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