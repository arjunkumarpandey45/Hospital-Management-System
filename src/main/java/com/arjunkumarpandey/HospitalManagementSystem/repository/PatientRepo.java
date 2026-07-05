package com.arjunkumarpandey.HospitalManagementSystem.repository;

import com.arjunkumarpandey.HospitalManagementSystem.ProjectByInterface.PatientProjection;
import com.arjunkumarpandey.HospitalManagementSystem.dto.PatientDto;
import com.arjunkumarpandey.HospitalManagementSystem.entity.Patient;
import com.arjunkumarpandey.HospitalManagementSystem.entity.type.BloodGroupType;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface PatientRepo extends JpaRepository<Patient, Long> {
    List<Patient> findByName(String priyaSingh);

    @Query("select p from Patient p where p.bloodGroup=?1")
    List<Patient> findByBloodGroup(BloodGroupType bloodGroup);

    @Query(value = "select * from patient", nativeQuery = true)
    List<Patient> findAllPatient();

    @Query(value = "select * from patient", countQuery = "SELECT COUNT(*) FROM patient", nativeQuery = true)
    Page<Patient> findAllPatient(Pageable page);

    @Transactional
    @Modifying
    @Query("update Patient p set p.name=:name where p.id=:id")
    int updatenameWithId(@Param("name") String name, @Param("id") Long id);

    @Query(" SELECT p.name AS name,p.birthDate AS birthDate FROM Patient p WHERE p.bloodGroup = :bloodGroup")
    List<PatientProjection> findPatientByBloodGroup(
            @Param("bloodGroup") BloodGroupType bloodGroup
    );

    @Query("  SELECT new com.arjunkumarpandey.HospitalManagementSystem.dto.PatientDto(p.name, p.birthDate) FROM Patient p WHERE p.bloodGroup = :bloodGroup")
    List<PatientDto> findPatientDTOByBloodGroup(
            @Param("bloodGroup") BloodGroupType bloodGroup
    );

    @Query("select p from Patient p left join fetch p.appointments a left join fetch a.doctor")
    List<Patient> findAllPatientWithAppointmentAndDoctor();

    @Query("SELECT p FROM Patient p LEFT JOIN FETCH p.appointments")
    List<Patient> findAllPatientWithAppointment();
    @Query("SELECT p FROM Patient p")
    List<Patient> findAllPatients(Pageable pageable);}

