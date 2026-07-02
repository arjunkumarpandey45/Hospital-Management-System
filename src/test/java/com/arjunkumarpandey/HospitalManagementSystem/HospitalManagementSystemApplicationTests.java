package com.arjunkumarpandey.HospitalManagementSystem;

import com.arjunkumarpandey.HospitalManagementSystem.entity.Patient;
import com.arjunkumarpandey.HospitalManagementSystem.repository.PatientRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

@SpringBootTest
class HospitalManagementSystemApplicationTests {
    @Autowired
    private PatientRepo patientRepo;

    @Test
    void contextLoads() {
    }

    @Test
    public void getAllPatientTest() {

//	List<Patient> p1= patientRepo.findByName("Priya Singh");
//	List<Patient> p=patientRepo.findByBloodGroup(BloodGroupType.A_POSITIVE);
//		List<Patient> p=patientRepo.findAllPatient();
//		int rowAffected=patientRepo.updatenameWithId("ARTI",4L);
//		System.out.println(rowAffected);
//		List<PatientDto> patients =
//				patientRepo.findPatientDTOByBloodGroup(BloodGroupType.A_POSITIVE);
//
//		patients.forEach(p -> {
//			System.out.println(p.getName());
//			System.out.println(p.getBirthDate());
//		});
		Page<Patient> patients = patientRepo.findAllPatient(
				PageRequest.of(1, 2, Sort.by("name"))
		);

		patients.forEach(System.out::println);

		System.out.println("Total Elements : " + patients.getTotalElements());
		System.out.println("Total Pages    : " + patients.getTotalPages());
		System.out.println("Current Page   : " + patients.getNumber());
		System.out.println("Is First Page  : " + patients.isFirst());
		System.out.println("Is Last Page   : " + patients.isLast());
//		List<PatientProjection> patients =
//				patientRepo.findPatientByBloodGroup(BloodGroupType.A_POSITIVE);
//
//		patients.forEach(p -> {
//			System.out.println(p.getName());
//			System.out.println(p.getBirthDate());
//		});

    }
}
