package com.volodymyrKadomtsev.medicalrecord;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class MedicalRecordService {

  private final MedicalRecordRepository repository;

  public MedicalRecordService(MedicalRecordRepository repository) {
    this.repository = repository;
  }

  public List<MedicalRecord> getAllRecords() {
    return repository.findAll();
  }

  public MedicalRecord getRecordById(Long id) {
    return repository.findById(id).orElse(null);
  }

  public MedicalRecord createRecord(MedicalRecord record) {
    return repository.save(record);
  }

  public MedicalRecord updateRecord(Long id, MedicalRecord updatedRecord) {
    MedicalRecord record = getRecordById(id);
    if (record == null)
      return null;
    record.setPatientName(updatedRecord.getPatientName());
    record.setDiagnosis(updatedRecord.getDiagnosis());
    return repository.save(record);
  }

  public void deleteRecord(Long id) {
    repository.deleteById(id);
  }

  public boolean finalizeRecord(Long recordId, Long doctorId) {
    MedicalRecord record = getRecordById(recordId);
    if (record != null && record.getDoctorId() == null) {
      record.setDoctorId(doctorId);
      record.setIsFinalized(true);
      repository.save(record);
      return true;
    }
    return false;
  }

  public boolean unfinalizeRecord(Long recordId, Long doctorId) {
    MedicalRecord record = getRecordById(recordId);
    if (record != null && record.getDoctorId() != null) {
      record.setDoctorId(null);
      record.setIsFinalized(false);
      repository.save(record);
      return true;
    }
    return false;
  }
}