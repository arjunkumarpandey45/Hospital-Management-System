package com.arjunkumarpandey.HospitalManagementSystem;

import com.arjunkumarpandey.HospitalManagementSystem.repository.PatientRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HospitalManagementSystemApplicationTests {
@Autowired
private PatientRepo patientRepo;
	@Test
	void contextLoads() {
	}
	@Test
	public void getAllPatientTest() {
		System.out.println(patientRepo.findAll());
	}
}
