package com.volodymyrKadomtsev.rating;

import java.io.Serializable;
import java.util.Objects;

public class RateId implements Serializable {

  private Long patientId;
  private Long doctorId;

  public RateId() {
  }

  public RateId(Long patientId, Long doctorId) {
    this.patientId = patientId;
    this.doctorId = doctorId;
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

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (!(o instanceof RateId))
      return false;
    RateId that = (RateId) o;
    return Objects.equals(patientId, that.patientId) &&
        Objects.equals(doctorId, that.doctorId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(patientId, doctorId);
  }
}