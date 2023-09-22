package com.mayank.app.controller;

import com.mayank.app.model.Appointment;
import com.mayank.app.model.Prescription;
import com.mayank.app.repository.AppointmentRepository;
import com.mayank.app.repository.PrescriptionRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class PrescriptionControllerTest {

    @InjectMocks
    PrescriptionController prescriptionController;

    @Mock
    PrescriptionRepository prescriptionRepository;

    @Test
    public void getAppointments_test(){
        Prescription prescription=new Prescription();
        prescription.setDoctorName("X");
        prescription.setAppointmentId("1");
        prescription.setDescription("NA");
        prescription.setPatientName("NONE");
        List<Prescription> result=prescriptionController.getAllPrescriptions(prescription.getPatientName());
        assertEquals(result.get(0),prescription);

    }

    @Test
    public void saveAppointments_test(){
        Prescription prescription=new Prescription();
        prescription.setDoctorName("X");
        prescription.setAppointmentId("1");
        prescription.setDescription("NA");
        prescription.setPatientName("NONE");
        Prescription result=prescriptionController.savePrescription(prescription);
        assertEquals(result,prescription);
    }
}
