package org.example.service;

import com.hospitalmanagement.entity.Appointment;
import com.hospitalmanagement.entity.Doctor;
import com.hospitalmanagement.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    // Get all appointments
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    // Total appointments per doctor
    public List<Object[]> totalAppointmentsPerDoctor() {
        return appointmentRepository.totalAppointmentsPerDoctor();
    }

    // Total appointments per month
    public List<Object[]> totalAppointmentsPerMonth() {
        return appointmentRepository.totalAppointmentsPerMonth();
    }

    // Get appointments for a doctor
    public List<Appointment> getAppointmentsByDoctor(Doctor doctor) {
        return appointmentRepository.findByDoctor(doctor);
    }
}