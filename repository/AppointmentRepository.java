package org.example.repository;

import com.hospitalmanagement.entity.Appointment;
import com.hospitalmanagement.entity.Doctor;
import com.hospitalmanagement.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findByDoctor(Doctor doctor);

    List<Appointment> findByPatient(Patient patient);

    // 1. Count appointments per doctor
    @Query("SELECT a.doctor.id, COUNT(a) FROM Appointment a GROUP BY a.doctor.id")
    List<Object[]> totalAppointmentsPerDoctor();

    // 2. Total appointments per month
    @Query("SELECT FUNCTION('MONTH', a.appointmentDate), COUNT(a) FROM Appointment a GROUP BY FUNCTION('MONTH', a.appointmentDate)")
    List<Object[]> totalAppointmentsPerMonth();
}