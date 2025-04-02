package com.volodymyrKadomtsev.medicalrecord;

public class MedicalRecord {

  private Long id;
  private static Long incrementId = 1L;

  private String patientName;
  private String diagnosis;
  private Boolean isFinalized = false;
  private Long doctorId = null;

  public MedicalRecord(String patientName, String diagnosis) {
    this.id = MedicalRecord.incrementId++;
    this.patientName = patientName;
    this.diagnosis = diagnosis;
  }

  public Long getId() {
    return id;
  }

  public static Long getIncrementId() {
    return incrementId;
  }

  public static void setIncrementId(Long incrementId) {
    MedicalRecord.incrementId = incrementId;
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