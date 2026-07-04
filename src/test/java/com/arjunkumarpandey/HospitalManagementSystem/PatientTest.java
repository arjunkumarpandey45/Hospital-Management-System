package com.arjunkumarpandey.HospitalManagementSystem;

import com.arjunkumarpandey.HospitalManagementSystem.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PatientTest {
    @Autowired
    private PatientService patientService;

    @Test
    public void getALLPatientTest() {
        System.out.println(patientService.getALlPatient()); ;
    }


}
