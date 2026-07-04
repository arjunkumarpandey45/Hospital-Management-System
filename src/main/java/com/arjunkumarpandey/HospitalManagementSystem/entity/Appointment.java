package com.arjunkumarpandey.HospitalManagementSystem.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private LocalDate appointmentTime;
    @Column(length = 100)
    private String reason;
    @ManyToOne
    @JoinColumn(nullable = false)
    @ToString.Exclude
    private Patient patient;
    @ManyToOne
    @ToString.Exclude
    @JoinColumn(nullable = false)
    private Doctor doctor;
}
