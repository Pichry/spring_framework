package org.example.repository;

import com.hospitalmanagement.entity.MedicalRecord;
import com.hospitalmanagement.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicalRecordRepository extends JpaRepository<MedicalRecord, Long> {

    List<MedicalRecord> findByPatient(Patient patient);

    // No extra queries needed here, reporting done in PatientRepository
}