package com.arjunkumarpandey.HospitalManagementSystem.dto;

import lombok.*;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class PatientDto {
    private String name;
    private LocalDate birthDate;

}
