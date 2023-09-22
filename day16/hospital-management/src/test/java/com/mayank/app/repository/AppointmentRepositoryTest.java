package com.mayank.app.repository;

import com.mayank.app.model.Appointment;
import com.mayank.app.model.Prescription;
import org.junit.Test;
import org.mockito.InjectMocks;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AppointmentRepositoryTest {

    @InjectMocks
    AppointmentRepository appointmentRepository;

    @Test
    public void getByName_test(){
        Appointment appointment=new Appointment();
        appointment.setDoctorName("X");
        appointment.setAppointmentId("1");
        appointment.setDate("today");
        appointment.setPrescription(new Prescription());
        appointment.setPatientName("NONE");
        List<Appointment> result=appointmentRepository.getByName(appointment.getPatientName());
        assertEquals(result.get(0),appointment);

    }

    @Test
    public void save_test(){
        Appointment appointment=new Appointment();
        appointment.setDoctorName("X");
        appointment.setAppointmentId("1");
        appointment.setDate("today");
        appointment.setPrescription(new Prescription());
        appointment.setPatientName("NONE");
        Appointment result=appointmentRepository.save(appointment);
        assertEquals(result,appointment);

    }
}
