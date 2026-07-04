package com.arjunkumarpandey.HospitalManagementSystem.repository;

import com.arjunkumarpandey.HospitalManagementSystem.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepo extends JpaRepository<Department, Long> {
}