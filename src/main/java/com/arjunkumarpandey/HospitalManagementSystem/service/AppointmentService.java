package com.arjunkumarpandey.HospitalManagementSystem.service;

import com.arjunkumarpandey.HospitalManagementSystem.entity.Appointment;
import com.arjunkumarpandey.HospitalManagementSystem.entity.Doctor;
import com.arjunkumarpandey.HospitalManagementSystem.entity.Patient;
import com.arjunkumarpandey.HospitalManagementSystem.repository.AppointmentRepo;
import com.arjunkumarpandey.HospitalManagementSystem.repository.DoctorRepo;
import com.arjunkumarpandey.HospitalManagementSystem.repository.PatientRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final DoctorRepo doctorRepo;
    private final PatientRepo patientRepo;
    private final AppointmentRepo appointmentRepo;

    @Transactional
    public Appointment createAppointment(Appointment appointment, Long doctorId, Long patientId) {
        Patient patient = patientRepo.findById(patientId).orElseThrow();
        Doctor doctor = doctorRepo.findById(doctorId).orElseThrow();
        if (appointment.getId() != null) {
            throw new IllegalArgumentException("Appointment is already there!!");
        }
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        return appointmentRepo.save(appointment);
    }

    @Transactional
    public Appointment reAssignAppointMent(Long appointmentId, Long doctorId) {
        Doctor doctor = doctorRepo.findById(doctorId).orElseThrow();
        Appointment appointment = appointmentRepo.findById(appointmentId).orElseThrow();
        appointment.setDoctor(doctor);
        doctor.getAppointments().add(appointment);
        return appointment;
    }

}
