package com.volodymyrKadomtsev.medicalrecord;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MedicalRecordRepository extends JpaRepository<MedicalRecord, Long> {

  // Знайти всі записи, створені певним лікарем
  List<MedicalRecord> findByDoctorId(Long doctorId);

  // Знайти всі фіналізовані записи
  List<MedicalRecord> findByIsFinalizedTrue();

  // Знайти всі не фіналізовані записи
  List<MedicalRecord> findByIsFinalizedFalse();

  // Пошук пацієнтів по частині імені (нечітке співпадіння)
  List<MedicalRecord> findByPatientNameContainingIgnoreCase(String namePart);

  // Приклад кастомного запиту (JPQL)
  @Query("SELECT r FROM MedicalRecord r WHERE r.diagnosis LIKE %:keyword%")
  List<MedicalRecord> searchByDiagnosis(String keyword);
}