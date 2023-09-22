package com.mayank.app.controller;

import com.mayank.app.model.Appointment;
import com.mayank.app.model.Prescription;
import com.mayank.app.repository.AppointmentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class DoctorControllerTest {

    @InjectMocks
    DoctorController doctorController;

    @Mock
    AppointmentRepository appointmentRepository;

    @Test
    public void getAppointments_test(){
        Appointment appointment=new Appointment();
        appointment.setDoctorName("X");
        appointment.setAppointmentId("1");
        appointment.setDate("today");
        appointment.setPrescription(new Prescription());
        appointment.setPatientName("NONE");
        List<Appointment> result=doctorController.getAppointments(appointment.getDoctorName());
        assertEquals(result.get(0),appointment);

    }

    @Test
    public void saveAppointments_test(){

        Appointment appointment=new Appointment();
        appointment.setDoctorName("X");
        appointment.setAppointmentId("1");
        appointment.setDate("today");
        appointment.setPrescription(new Prescription());
        appointment.setPatientName("NONE");
        Appointment result=doctorController.saveAppointment(appointment);
        assertEquals(result,appointment);
    }
}
