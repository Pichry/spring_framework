package org.example.service;

import com.hospitalmanagement.entity.Doctor;
import com.hospitalmanagement.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    // Get all doctors
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    // Get doctors with more than 5 patients
    public List<Doctor> getDoctorsWithManyPatients() {
        return doctorRepository.doctorsWithMoreThanFivePatients();
    }

    // Count patients per doctor
    public List<Object[]> countPatientsPerDoctor() {
        return doctorRepository.countPatientsPerDoctor();
    }
}
