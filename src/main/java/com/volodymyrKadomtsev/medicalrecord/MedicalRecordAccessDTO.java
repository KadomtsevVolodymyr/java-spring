package com.volodymyrKadomtsev.medicalrecord;

import java.time.LocalDate;

public class MedicalRecordAccessDTO {

  private Long doctorId;
  private Long recordId;

  private LocalDate grantedAt;
  private LocalDate expiresAt;
  private String isExpired;

  public Long getDoctorId() {
    return doctorId;
  }

  public void setDoctorId(Long doctorId) {
    this.doctorId = doctorId;
  }

  public Long getRecordId() {
    return recordId;
  }

  public void setRecordId(Long recordId) {
    this.recordId = recordId;
  }

  public LocalDate getGrantedAt() {
    return grantedAt;
  }

  public void setGrantedAt(LocalDate grantedAt) {
    this.grantedAt = grantedAt;
  }

  public LocalDate getExpiresAt() {
    return expiresAt;
  }

  public void setExpiresAt(LocalDate expiresAt) {
    this.expiresAt = expiresAt;
  }

  public String getIsExpired() {
    return isExpired;
  }

  public void setIsExpired(String isExpired) {
    this.isExpired = isExpired;
  }
}