package cm.mayank.app.unittest;

import cm.mayank.app.controller.PatientController;
import cm.mayank.app.model.Patient;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

@RunWith(MockitoJUnitRunner.class)
public class ControllerAppTest {

@InjectMocks
    private PatientController controllerApp=new PatientController();

    @Test
    public void test_createPatient(){
        Patient patient1=new Patient("P","X","M","A");
        Patient result=controllerApp.createPatient(patient1);
        assertEquals(patient1.getId(),result.getId());

    }

    @Test
    public void test_readeStudent(){
        Patient patient1=new Patient("P","X","M","A");
        controllerApp.createPatient(patient1);
        Patient result=controllerApp.getPatient("X");
        assertEquals("P",result.getPatient());
        assertEquals("X",result.getId());
        assertEquals("M",result.getHospital());
        assertEquals("A",result.getDisease());
    }

    @Test
    public void test_updateStudent(){
        Patient patient1=new Patient("P","X","M","A");
        controllerApp.createPatient(patient1);
        Patient result=controllerApp.updatePatient("X","UP");
        assertEquals("P",result.getPatient());
        assertEquals("123",result.getId());
        assertEquals("UP",result.getHospital());
        assertEquals("A",result.getDisease());

    }

    @Test
    public void test_deleteStudent(){
        Patient patient1=new Patient("P","X","M","A");
        controllerApp.createPatient(patient1);
        controllerApp.deletePatient("X");
        Patient result=controllerApp.getPatient("X");
        assertNull(result);
    }
}
