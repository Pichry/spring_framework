package org.example.repository;

import com.hospitalmanagement.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    Patient findByEmail(String email);

    // 1. Patients diagnosed more than once
    @Query("SELECT p FROM Patient p JOIN p.medicalRecords m GROUP BY p HAVING COUNT(m) > 1")
    List<Patient> patientsWithMultipleDiagnoses();
}