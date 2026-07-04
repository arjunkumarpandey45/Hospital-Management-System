package com.arjunkumarpandey.HospitalManagementSystem;

import com.arjunkumarpandey.HospitalManagementSystem.entity.Appointment;
import com.arjunkumarpandey.HospitalManagementSystem.repository.AppointmentRepo;
import com.arjunkumarpandey.HospitalManagementSystem.service.AppointmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class AppointmentTest {
    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private AppointmentRepo appointmentRepo;

    @Test
    public void createAppointmentTest() {
        Appointment appointment = Appointment.builder().appointmentTime(LocalDate.of(2025, 9, 4)).reason("Leg Injury").build();
        appointmentService.createAppointment(appointment, 1L, 3L);

        appointmentRepo.save(appointment);

    }

    @Test
    public void reAssignDoctor() {

        appointmentService.reAssignAppointMent(1L,1L);

    }
}
