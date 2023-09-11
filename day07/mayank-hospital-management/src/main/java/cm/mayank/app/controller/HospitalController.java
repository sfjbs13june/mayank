package cm.mayank.app.controller;

import cm.mayank.app.model.Hospital;
import cm.mayank.app.model.Patient;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HospitalController {

    Map<String, Hospital> hospitalMap= new HashMap<String,Hospital>();

    @PostMapping(value = {"/save/hospital"})
    public Hospital createHospital(@RequestBody Hospital hospital){
        hospitalMap.put(hospital.getId(), hospital);
        return hospital;
    }
    @PutMapping(value = {"/update/hospital"})
    public Hospital updateHospital(@RequestParam("id") String id,@RequestParam("name") String name){
        Hospital hospital=hospitalMap.get(id);
        hospital.setName("UPD");
        return hospital;
    }

    @GetMapping(value = {"/get/hospital/{id}"})
    public Hospital getHospital(@RequestParam("id") String id){
        return hospitalMap.get(id);
    }

    @DeleteMapping(value = {"/delete/hospital/{id}"})
    public Hospital deleteHospital(@RequestParam("id") String id){
        return hospitalMap.remove(id);
    }
}
