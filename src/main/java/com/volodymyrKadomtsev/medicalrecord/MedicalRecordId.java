package com.volodymyrKadomtsev.medicalrecord;

import java.io.Serializable;

import com.volodymyrKadomtsev.user.User;

public class MedicalRecordId implements Serializable {

  private User doctor;
  private MedicalRecord record;

  public MedicalRecordId() {
  }

  public MedicalRecordId(User doctor, MedicalRecord record) {
    this.doctor = doctor;
    this.record = record;
  }

  // Getters, Setters, equals(), hashCode() якщо потрібно
}