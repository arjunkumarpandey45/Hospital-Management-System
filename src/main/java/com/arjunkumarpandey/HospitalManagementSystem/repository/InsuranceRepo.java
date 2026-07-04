package com.arjunkumarpandey.HospitalManagementSystem.repository;

import com.arjunkumarpandey.HospitalManagementSystem.entity.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRepo extends JpaRepository<Insurance, Long> {
}