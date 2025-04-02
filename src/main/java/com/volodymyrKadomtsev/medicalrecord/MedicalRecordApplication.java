package com.volodymyrKadomtsev.medicalrecord;

import java.util.HashMap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
@RestController
public class MedicalRecordApplication {

  private HashMap<Integer, String> patients = new HashMap<>();

  @PostConstruct
  public void init() {
    patients.put(1, "John Doe");
    patients.put(2, "Jane Smith");
    patients.put(3, "Emily Johnson");
    patients.put(4, "Michael Brown");
    patients.put(5, "Linda Davis");
    patients.put(6, "Robert Wilson");
  }

  public static void main(String[] args) {
    SpringApplication.run(MedicalRecordApplication.class, args);
  }

  @GetMapping("/patients")
  public String getPatients() {
    StringBuilder patientsString = new StringBuilder();
    patients.forEach((key, value) -> patientsString.append("ID: ").append(key).append(" Patient: ").append(value).append("<br>"));
    return patientsString.toString();
  }
}
