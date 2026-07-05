package com.arjunkumarpandey.HospitalManagementSystem.service;

import com.arjunkumarpandey.HospitalManagementSystem.dto.PatientResponseDto;
import com.arjunkumarpandey.HospitalManagementSystem.entity.Patient;
import com.arjunkumarpandey.HospitalManagementSystem.repository.PatientRepo;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepo patientRepo;
private final ModelMapper modelMapper;

    public List<Patient> getALlPatient() {
        return patientRepo.findAllPatientWithAppointmentAndDoctor();
    }
    public PatientResponseDto getPatientById(Long patientId) {
        Patient patient = patientRepo.findById(patientId).orElseThrow(() -> new EntityNotFoundException("Patient Not " +
                "Found with id: " + patientId));
        return modelMapper.map(patient, PatientResponseDto.class);
    }

    public List<PatientResponseDto> getAllPatients(Integer pageNumber, Integer pageSize) {
        return patientRepo.findAllPatients(PageRequest.of(pageNumber, pageSize))
                .stream()
                .map(patient -> modelMapper.map(patient, PatientResponseDto.class))
                .collect(Collectors.toList());
    }
}
