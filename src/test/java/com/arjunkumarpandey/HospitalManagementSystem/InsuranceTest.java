package com.arjunkumarpandey.HospitalManagementSystem;

import com.arjunkumarpandey.HospitalManagementSystem.entity.Insurance;
import com.arjunkumarpandey.HospitalManagementSystem.entity.Patient;
import com.arjunkumarpandey.HospitalManagementSystem.service.InsuranceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class InsuranceTest {
    @Autowired
    private InsuranceService insuranceService;

    @Test
    public void testCreateInsurance() {
        Insurance insurance = Insurance.builder().policyNumber("ICIC_4547").provider("ICIC").endDate(LocalDate.of(2027, 12, 12)).build();
        Patient patient = insuranceService.assignInsuranceToPatient(insurance, 1L);
        System.out.println(patient);
    }

    @Test
    public void removeInsuranceTest() {
        insuranceService.removeInsuranceFromPatient(1L);
    }


}
