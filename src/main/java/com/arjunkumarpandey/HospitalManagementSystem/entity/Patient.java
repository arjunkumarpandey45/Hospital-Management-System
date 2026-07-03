package com.arjunkumarpandey.HospitalManagementSystem.entity;

import com.arjunkumarpandey.HospitalManagementSystem.entity.type.BloodGroupType;
import com.arjunkumarpandey.HospitalManagementSystem.entity.type.Gender;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@ToString
@Data
@Table(
//        name = "patient_table",
        uniqueConstraints = {
                @UniqueConstraint(name = "unique_patient_by_birthdate", columnNames = {"name", "birthDate"})
        },
        indexes = {
                @Index(name = "index_patient_birthDate", columnList = "birthDate")
        }
)
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(unique = true, nullable = false)
    private String email;
    @ToString.Exclude
    private LocalDate birthDate;
    @Enumerated(EnumType.STRING)
    private BloodGroupType bloodGroup;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;
    @OneToOne
   @JoinColumn(name = "insurance_id")//owning_side
    private Insurance insurance;
    @OneToMany(mappedBy = "patient")

    private List<Appointment> appointments;
}
