package cm.mayank.app.unittest;


import cm.mayank.app.controller.PatientController;
import cm.mayank.app.model.Patient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(MockitoJUnitRunner.class)
public class PatientControllerTest {

    @InjectMocks
    private PatientController patientController;

    @Test
    public void test_createPatient(){
        Patient patient=new Patient("p1","x1","MH","NA");
        Patient result=patientController.createPatient(patient);
        assertEquals(patient.getId(),result.getId());
    }

    @Test
    public void test_getPatient(){
        Patient patient=new Patient("p1","x1","MH","NA");
        patientController.createPatient(patient);
        Patient result=patientController.getPatient("x1");
        assertEquals(patient.getPatient(),result.getPatient());
    }

    @Test
    public void test_updatePatient(){
        Patient patient=new Patient("p1","x1","MH","NA");
        patientController.createPatient(patient);
        Patient result=patientController.updatePatient("x1","UPDATED");
        assertEquals(patient.getHospital(),result.getHospital());
    }

    @Test
    public void test_deletePatient(){
        Patient patient=new Patient("p1","x1","MH","NA");
        patientController.createPatient(patient);
        patientController.deletePatient("x1");
        assertNull(patientController.getPatient("x1"));
    }
}
