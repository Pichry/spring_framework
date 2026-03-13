package org.example.controller;
import com.hospitalmanagement.entity.Appointment;
import com.hospitalmanagement.entity.Doctor;
import com.hospitalmanagement.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    // Get all appointments
    @GetMapping
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    // Get total appointments per doctor
    @GetMapping("/per-doctor")
    public List<Object[]> totalAppointmentsPerDoctor() {
        return appointmentService.totalAppointmentsPerDoctor();
    }

    // Get total appointments per month
    @GetMapping("/per-month")
    public List<Object[]> totalAppointmentsPerMonth() {
        return appointmentService.totalAppointmentsPerMonth();
    }

    // Get appointments for a specific doctor
    @GetMapping("/doctor/{doctorId}")
    public List<Appointment> getAppointmentsByDoctor(@PathVariable Long doctorId, @RequestParam Doctor doctor) {
        return appointmentService.getAppointmentsByDoctor(doctor);
    }
}
