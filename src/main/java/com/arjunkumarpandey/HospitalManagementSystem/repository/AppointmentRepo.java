package com.arjunkumarpandey.HospitalManagementSystem.repository;

import com.arjunkumarpandey.HospitalManagementSystem.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepo extends JpaRepository<Appointment, Long> {
}