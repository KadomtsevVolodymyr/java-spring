package com.volodymyrKadomtsev.medicalrecord;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "medical_records")
public class MedicalRecord {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank(message = "Patient name is required")
  private String patientName;

  @NotBlank(message = "Diagnosis is required")
  private String diagnosis;

  private Boolean isFinalized = false;
  private Long doctorId;

  public MedicalRecord() {
    // no-args constructor
  }

  public MedicalRecord(String patientName, String diagnosis) {
    this.patientName = patientName;
    this.diagnosis = diagnosis;
  }

  // Getters and Setters
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getPatientName() {
    return patientName;
  }

  public void setPatientName(String patientName) {
    this.patientName = patientName;
  }

  public String getDiagnosis() {
    return diagnosis;
  }

  public void setDiagnosis(String diagnosis) {
    this.diagnosis = diagnosis;
  }

  public Boolean getIsFinalized() {
    return isFinalized;
  }

  public void setIsFinalized(Boolean isFinalized) {
    this.isFinalized = isFinalized;
  }

  public Long getDoctorId() {
    return doctorId;
  }

  public void setDoctorId(Long doctorId) {
    this.doctorId = doctorId;
  }
}