package cm.mayank.app.unittest;

import cm.mayank.app.controller.HospitalController;
import cm.mayank.app.controller.PatientController;
import cm.mayank.app.model.Hospital;
import cm.mayank.app.model.Patient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(MockitoJUnitRunner.class)
public class HospitalControllerTest {

    @InjectMocks
    HospitalController hospitalController;



    @Test
    public void test_createPatient(){
        Hospital hospital=new Hospital("p1","x1","MH");
        Hospital result=hospitalController.createHospital(hospital);
        assertEquals(hospital.getId(),result.getId());
    }
}
