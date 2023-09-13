package com.mayank.app.unittest;


import com.mayank.app.controller.HospitalController;
import com.mayank.app.model.Hospital;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(MockitoJUnitRunner.class)
public class HospitalControllerTest {

    @InjectMocks
    HospitalController hospitalController;

    @Test
    public void test_createHospital(){
        Hospital hospital=new Hospital("p1","x1","MH");
        Hospital result=hospitalController.createHospital(hospital);
        assertEquals(hospital.getId(),result.getId());
    }

    @Test
    public void test_getHospital(){
        Hospital hospital=new Hospital("p1","x1","MH");
        hospitalController.createHospital(hospital);
        Hospital result=hospitalController.getHospital("x1");
        assertEquals(hospital.getId(),result.getId());
    }

    @Test
    public void test_updateHospital(){
        Hospital hospital=new Hospital("p1","x1","MH");
        hospitalController.createHospital(hospital);
        Hospital result=hospitalController.updateHospital("x1","UPDATED");
        assertEquals(hospital.getName(),result.getName());
    }

    @Test
    public void test_deleteHospital(){
        Hospital hospital=new Hospital("p1","x1","MH");
        hospitalController.createHospital(hospital);
        hospitalController.deleteHospital("x1");
        assertNull(hospitalController.getHospital("x1"));
    }
}
