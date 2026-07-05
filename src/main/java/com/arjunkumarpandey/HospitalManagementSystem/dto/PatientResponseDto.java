package com.arjunkumarpandey.HospitalManagementSystem.dto;

import com.arjunkumarpandey.HospitalManagementSystem.entity.type.BloodGroupType;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PatientResponseDto {
    private Long id;
    private String name;
    private String gender;
    private LocalDate birthDate;
    private BloodGroupType bloodGroup;
}