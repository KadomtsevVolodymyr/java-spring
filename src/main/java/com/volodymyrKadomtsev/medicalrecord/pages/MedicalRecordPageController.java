package com.volodymyrKadomtsev.medicalrecord.pages;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.volodymyrKadomtsev.medicalrecord.MedicalRecord;
import com.volodymyrKadomtsev.medicalrecord.MedicalRecordService;
import com.volodymyrKadomtsev.user.User;
import com.volodymyrKadomtsev.user.UserService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/views/records")
public class MedicalRecordPageController {

  private static final String REDIRECT_RECORDS = "redirect:/views/records";

  private final MedicalRecordService medicalRecordService;
  private final UserService userService;

  public MedicalRecordPageController(MedicalRecordService medicalRecordService, UserService userService) {
    this.medicalRecordService = medicalRecordService;
    this.userService = userService;
  }

  @GetMapping
  public String viewRecords(Model model) {
    List<MedicalRecord> records = medicalRecordService.getAllRecords();
    model.addAttribute("records", records);
    return "records";
  }

  @GetMapping("/create")
  public String createRecordForm(Model model) {
    model.addAttribute("record", new MedicalRecord());
    return "createRecord";
  }

  @PostMapping
  public String createRecord(@Valid @ModelAttribute MedicalRecord record, BindingResult bindingResult, Model model) {
    if (bindingResult.hasErrors()) {
      model.addAttribute("record", record);
      return "createRecord";
    }
    medicalRecordService.createRecord(record);
    return REDIRECT_RECORDS;
  }

  @DeleteMapping("/{id}")
  public String deleteRecord(@PathVariable Long id) {
    medicalRecordService.deleteRecord(id);
    return REDIRECT_RECORDS;
  }

  @GetMapping("/{id}/update")
  public String showUpdateForm(@PathVariable Long id, Model model) {
    MedicalRecord record = medicalRecordService.getRecordById(id);
    if (record == null)
      throw new IllegalArgumentException("Invalid record ID");
    model.addAttribute("record", record);
    return "updateRecord";
  }

  @PostMapping("/{id}/update")
  public String updateRecord(@PathVariable Long id, @Valid @ModelAttribute MedicalRecord record,
      BindingResult bindingResult, Model model) {
    if (bindingResult.hasErrors()) {
      model.addAttribute("record", record);
      return "updateRecord";
    }
    record.setId(id);
    medicalRecordService.updateRecord(id, record);
    return REDIRECT_RECORDS;
  }

  @PutMapping("/{id}/finalize")
  public String finalizeRecord(@PathVariable Long id) {
    User doctor = userService.getUserById(1L).orElseThrow(() -> new IllegalArgumentException("Invalid user id"));
    medicalRecordService.finalizeRecord(id, doctor.getId());
    return REDIRECT_RECORDS;
  }

  @PutMapping("/{id}/unfinalize")
  public String unfinalizeRecord(@PathVariable Long id) {
    medicalRecordService.unfinalizeRecord(id, 1L);
    return REDIRECT_RECORDS;
  }
}