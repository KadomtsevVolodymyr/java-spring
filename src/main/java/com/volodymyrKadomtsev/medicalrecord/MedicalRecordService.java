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
}