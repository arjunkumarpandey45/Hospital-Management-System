package com.arjunkumarpandey.HospitalManagementSystem.service;

import com.arjunkumarpandey.HospitalManagementSystem.entity.Insurance;
import com.arjunkumarpandey.HospitalManagementSystem.entity.Patient;
import com.arjunkumarpandey.HospitalManagementSystem.repository.InsuranceRepo;
import com.arjunkumarpandey.HospitalManagementSystem.repository.PatientRepo;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {
    private final InsuranceRepo insuranceRepo;
    private final PatientRepo patientRepo;

    @Transactional
    public Patient assignInsuranceToPatient(Insurance insurance, Long patientId) {
        Patient patient = patientRepo.findById(patientId).orElseThrow(() -> new EntityNotFoundException("Patient Not Found By The ID " + patientId));
        patient.setInsurance(insurance);
        insurance.setPatient(patient);
        return patient;
    }

    @Transactional
    public void removeInsuranceFromPatient(Long patientId) {
        Patient patient = patientRepo.findById(patientId).orElseThrow(() -> new EntityNotFoundException("Patient Not Found By The ID " + patientId));
        patient.setInsurance(null);
    }

}
