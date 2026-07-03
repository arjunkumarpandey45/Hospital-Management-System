package com.arjunkumarpandey.HospitalManagementSystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Insurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true, length = 40)
    private String policyNumber;
    @Column(nullable = false, length = 100)
    private String provider;
    @Column(nullable = false)
    private LocalDate endDate;
    @CreationTimestamp
    @Column(nullable = false,updatable = false)
    private LocalDate createdAt;
    @OneToOne(mappedBy = "insurance")//inverse side
    private  Patient patient;
}
