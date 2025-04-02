package com.volodymyrKadomtsev.medicalrecord;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/records")
public class MedicalRecordController {

  private final MedicalRecordService medicalRecordService;

  public MedicalRecordController(MedicalRecordService medicalRecordService) {
    this.medicalRecordService = medicalRecordService;
  }

  @GetMapping
  public List<MedicalRecord> getAllRecords() {
    return medicalRecordService.getAllRecords();
  }

  @GetMapping("/{id}")
  public MedicalRecord getRecordById(@PathVariable Long id) {
    return medicalRecordService.getRecordById(id);
  }

  @PostMapping("/{recordId}/{doctorId}")
  public boolean finalizeRecord(@PathVariable Long recordId, @PathVariable Long doctorId) {
    return medicalRecordService.finalizeRecord(recordId, doctorId);
  }

  @DeleteMapping("/{recordId}/{doctorId}")
  public boolean unfinalizeRecord(@PathVariable Long recordId, @PathVariable Long doctorId) {
    return medicalRecordService.unfinalizeRecord(recordId, doctorId);
  }
}