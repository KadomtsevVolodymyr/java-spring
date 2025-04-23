package com.volodymyrKadomtsev.medicalrecord;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class MedicalRecordService {

  private final MedicalRecordRepository medicalRecordRepository;

  public MedicalRecordService(MedicalRecordRepository medicalRecordRepository) {
    this.medicalRecordRepository = medicalRecordRepository;
  }

  public List<MedicalRecord> getAllRecords() {
    return medicalRecordRepository.findAll();
  }

  public MedicalRecord getRecordById(Long id) {
    return medicalRecordRepository.findById(id);
  }

  public boolean finalizeRecord(Long recordId, Long doctorId) {
    if (doctorId == null) {
      return false;
    }
    return medicalRecordRepository.finalizeRecord(recordId, doctorId);
  }

  public boolean unfinalizeRecord(Long recordId, Long doctorId) {
    if (doctorId == null) {
      return false;
    }
    return medicalRecordRepository.unfinalizeRecord(recordId, doctorId);
  }

  public MedicalRecord createRecord(MedicalRecord record) {
    return medicalRecordRepository.save(record);
  }

  public MedicalRecord updateRecord(Long id, MedicalRecord updatedRecord) {
    MedicalRecord record = medicalRecordRepository.findById(id);
    if (record != null) {
      record.setPatientName(updatedRecord.getPatientName());
      record.setDiagnosis(updatedRecord.getDiagnosis());
      return medicalRecordRepository.save(record);
    }
    return null;
  }
public void deleteRecord(Long id) {
    medicalRecordRepository.deleteById(id);
}
}