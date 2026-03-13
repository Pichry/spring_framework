package org.example.controller;

import com.hospitalmanagement.entity.Doctor;
import com.hospitalmanagement.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    // Get all doctors
    @GetMapping
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    // Get doctors with more than 5 patients
    @GetMapping("/popular")
    public List<Doctor> getDoctorsWithManyPatients() {
        return doctorService.getDoctorsWithManyPatients();
    }

    // Get patient count per doctor
    @GetMapping("/patient-count")
    public List<Object[]> getPatientCountPerDoctor() {
        return doctorService.countPatientsPerDoctor();
    }
}
