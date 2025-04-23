package com.volodymyrKadomtsev.medicalrecord;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class MedicalRecordRepository {

  private final List<MedicalRecord> records = new ArrayList<>();

  @PostConstruct
  private void init() {
    records.add(new MedicalRecord("John Doe", "Flu"));
    records.add(new MedicalRecord("Jane Smith", "Hypertension"));
    records.add(new MedicalRecord("Emily Johnson", "Diabetes"));
    records.add(new MedicalRecord("Michael Brown", "Asthma"));
    records.add(new MedicalRecord("Linda Davis", "Back Pain"));
  }

  public List<MedicalRecord> findAll() {
    return records;
  }

  public MedicalRecord findById(Long id) {
    return records.stream().filter(record -> record.getId().equals(id)).findFirst().orElse(null);
  }

  public MedicalRecord save(MedicalRecord record) {
    // Якщо запис з таким ID вже існує — оновлюємо
    for (int i = 0; i < records.size(); i++) {
      if (records.get(i).getId().equals(record.getId())) {
        records.set(i, record);
        return record;
      }
    }

    // Інакше додаємо новий
    records.add(record);
    return record;
  }

  public boolean deleteById(Long id) {
    return records.removeIf(record -> record.getId().equals(id));
  }

  public boolean finalizeRecord(Long recordId, Long doctorId) {
    MedicalRecord record = findById(recordId);
    if (record != null && record.getDoctorId() == null) {
      record.setDoctorId(doctorId);
      record.setIsFinalized(true);
      return true;
    }
    return false;
  }

  public boolean unfinalizeRecord(Long recordId, Long doctorId) {
    MedicalRecord record = findById(recordId);
    if (record != null && record.getDoctorId() != null) {
      record.setDoctorId(null);
      record.setIsFinalized(false);
      return true;
    }
    return false;
  }
}