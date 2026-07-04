package com.arjunkumarpandey.HospitalManagementSystem.service;

import com.arjunkumarpandey.HospitalManagementSystem.entity.Patient;
import com.arjunkumarpandey.HospitalManagementSystem.repository.PatientRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepo patientRepo;


    public List<Patient> getALlPatient() {
        return patientRepo.findAllPatientWithAppointmentAndDoctor();
    }

}
