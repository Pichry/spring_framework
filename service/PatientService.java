package org.example.service;

import com.hospitalmanagement.entity.Patient;
import com.hospitalmanagement.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    // Get all patients
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    // Patients diagnosed more than once
    public List<Patient> getPatientsWithMultipleDiagnoses() {
        return patientRepository.patientsWithMultipleDiagnoses();
    }
}