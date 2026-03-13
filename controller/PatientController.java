package org.example.controller;
import com.hospitalmanagement.entity.Patient;
import com.hospitalmanagement.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    // Get all patients
    @GetMapping
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    // Get patients diagnosed more than once
    @GetMapping("/multiple-diagnoses")
    public List<Patient> getPatientsWithMultipleDiagnoses() {
        return patientService.getPatientsWithMultipleDiagnoses();
    }
}
