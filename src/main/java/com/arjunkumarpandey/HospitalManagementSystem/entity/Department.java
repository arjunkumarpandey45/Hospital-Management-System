package com.arjunkumarpandey.HospitalManagementSystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,unique = true,length = 100)
    private String name;
    @OneToOne
    private Doctor headDoctor;
    @ManyToMany
    @JoinTable(
//            name="DeptAndDoct",
//            joinColumns = @JoinColumn(name = "dpt_id"),
//            inverseJoinColumns = @JoinColumn(name = "doct_id")
    )
    private Set<Doctor> doctors=new HashSet<>();
}
