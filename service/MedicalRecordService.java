package org.example.service;
import com.hospitalmanagement.entity.MedicalRecord;
import com.hospitalmanagement.entity.Patient;
import com.hospitalmanagement.repository.MedicalRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalRecordService {

    @Autowired
    private MedicalRecordRepository medicalRecordRepository;

    // Get all records
    public List<MedicalRecord> getAllRecords() {
        return medicalRecordRepository.findAll();
    }

    // Get records for a specific patient
    public List<MedicalRecord> getRecordsByPatient(Patient patient) {
        return medicalRecordRepository.findByPatient(patient);
    }
}
