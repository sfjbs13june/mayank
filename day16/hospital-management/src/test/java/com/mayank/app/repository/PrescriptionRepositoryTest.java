package com.mayank.app.repository;

import com.mayank.app.model.Appointment;
import com.mayank.app.model.Prescription;
import org.junit.Test;
import org.mockito.InjectMocks;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class PrescriptionRepositoryTest {

    @InjectMocks
    PrescriptionRepository prescriptionRepository;

    @Test
    public void getByName_test(){
        Prescription prescription=new Prescription();
        prescription.setDoctorName("X");
        prescription.setAppointmentId("1");
        prescription.setDescription("NA");
        prescription.setPatientName("NONE");
        List<Prescription> result=prescriptionRepository.getByName(prescription.getPatientName());
        assertEquals(result.get(0),prescription);

    }

    @Test
    public void save_test(){
        Prescription prescription=new Prescription();
        prescription.setDoctorName("X");
        prescription.setAppointmentId("1");
        prescription.setDescription("NA");
        prescription.setPatientName("NONE");
        Prescription result=prescriptionRepository.save(prescription);
        assertEquals(result,prescription);

    }
}
