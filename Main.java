package org.example;

package org.example;

import org.example.entity.Doctor;
import org.example.entity.Patient;
import org.example.entity.Appointment;
import org.example.entity.MedicalRecord;

import org.example.service.DoctorService;
import org.example.service.PatientService;
import org.example.service.AppointmentService;
import org.example.service.MedicalRecordService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class HospitalManagementMain {

    public static void main(String[] args) {


        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring-config.xml");


        DoctorService doctorService = context.getBean(DoctorService.class);
        PatientService patientService = context.getBean(PatientService.class);
        AppointmentService appointmentService = context.getBean(AppointmentService.class);
        MedicalRecordService medicalRecordService = context.getBean(MedicalRecordService.class);


        Doctor doctor1 = new Doctor();
        doctor1.setFirstName("Chnisse");
        doctor1.setLastName("umuhoza");
        doctor1.setSpecialty("Cardiology");
        doctor1.setPhoneNumber("0781111111");
        doctor1.setEmail("umuhoza@hospital.com");

        doctorService.saveDoctor(doctor1);

        Doctor doctor2 = new Doctor();
        doctor2.setFirstName("esther");
        doctor2.setLastName("kyle");
        doctor2.setSpecialty("Pediatrics");
        doctor2.setPhoneNumber("0782222222");
        doctor2.setEmail("kyle@hospital.com");

        doctorService.saveDoctor(doctor2);


        Patient patient1 = new Patient();
        patient1.setFirstName("Johnathan");
        patient1.setLastName("Mariki");
        patient1.setGender("Male");
        patient1.setPhoneNumber("0783333333");
        patient1.setEmail("john@gmail.com");
        patient1.setDateOfBirth(LocalDate.of(1990, 5, 10));

        patientService.savePatient(patient1);

        Patient patient2 = new Patient();
        patient2.setFirstName("Janethe");
        patient2.setLastName("Donath");
        patient2.setGender("Female");
        patient2.setPhoneNumber("0784444444");
        patient2.setEmail("jane@gmail.com");
        patient2.setDateOfBirth(LocalDate.of(1995, 8, 20));

        patientService.savePatient(patient2);


        Appointment appointment1 = new Appointment();
        appointment1.setDoctor(doctor1);
        appointment1.setPatient(patient1);
        appointment1.setAppointmentDate(LocalDateTime.of(2026,3,15,10,30));
        appointment1.setStatus("Scheduled");

        appointmentService.saveAppointment(appointment1);

        Appointment appointment2 = new Appointment();
        appointment2.setDoctor(doctor2);
        appointment2.setPatient(patient2);
        appointment2.setAppointmentDate(LocalDateTime.of(2026,3,16,14,0));
        appointment2.setStatus("Scheduled");

        appointmentService.saveAppointment(appointment2);


        MedicalRecord record1 = new MedicalRecord();
        record1.setDoctor(doctor1);
        record1.setPatient(patient1);
        record1.setDiagnosis("Hypertension");
        record1.setTreatment("Medication and diet");

        medicalRecordService.saveRecord(record1);

        MedicalRecord record2 = new MedicalRecord();
        record2.setDoctor(doctor2);
        record2.setPatient(patient2);
        record2.setDiagnosis("Flu");
        record2.setTreatment("Rest and hydration");

        medicalRecordService.saveRecord(record2);

        System.out.println("Data inserted successfully!");
    }
}
