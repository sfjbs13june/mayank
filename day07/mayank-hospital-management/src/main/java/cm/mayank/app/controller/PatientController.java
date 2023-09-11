package cm.mayank.app.controller;

import cm.mayank.app.model.Patient;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class PatientController {

    Map<String,Patient> patientMap= new HashMap<String,Patient>();

    @PostMapping(value = {"/save/patient"})
    public Patient createPatient(@RequestBody Patient patient){
        patientMap.put(patient.getId(), patient);
        return patient;
    }
    @PutMapping(value = {"/update/patient"})
    public Patient updatePatient(@RequestParam("id") String id,@RequestParam("hospital") String hospital){
        Patient patient=patientMap.get(id);
        patient.setHospital(hospital);
        return patient;
    }

    @GetMapping(value = {"/get/patient/{id}"})
    public Patient getPatient(@RequestParam("id") String id){
        return patientMap.get(id);
    }

    @DeleteMapping(value = {"/delete/patient/{id}"})
    public Patient deletePatient(@RequestParam("id") String id){
        return patientMap.remove(id);
    }
}
