package org.example.controller;
import com.hospitalmanagement.entity.MedicalRecord;
import com.hospitalmanagement.entity.Patient;
import com.hospitalmanagement.service.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medical-records")
public class MedicalRecordController {

    @Autowired
    private MedicalRecordService medicalRecordService;

    // Get all medical records
    @GetMapping
    public List<MedicalRecord> getAllRecords() {
        return medicalRecordService.getAllRecords();
    }

    // Get records for a specific patient
    @GetMapping("/patient/{patientId}")
    public List<MedicalRecord> getRecordsByPatient(@PathVariable Patient patient) {
        return medicalRecordService.getRecordsByPatient(patient);
    }
}
