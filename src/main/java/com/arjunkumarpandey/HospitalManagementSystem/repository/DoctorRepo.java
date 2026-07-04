package com.arjunkumarpandey.HospitalManagementSystem.repository;

import com.arjunkumarpandey.HospitalManagementSystem.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepo extends JpaRepository<Doctor, Long> {
}