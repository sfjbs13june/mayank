package com.mayank.app.controller;

import com.mayank.app.model.Hospital;
import com.mayank.app.repo.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HospitalController {

  @Autowired
    HospitalRepository hospitalRepository;

    @PostMapping(value = {"/save/hospital"})
    public Hospital createHospital(@RequestBody Hospital hospital){
        hospitalRepository.saveHospital(hospital);
        return hospital;
    }
//    @PutMapping(value = {"/update/hospital"})
//    public Hospital updateHospital(@RequestParam("id") String id,@RequestParam("name") String name){
//        Hospital hospital=hospitalMap.get(id);
//        hospital.setName("UPD");
//        return hospital;
//    }

    @GetMapping(value = {"/get/hospital/{id}"})
    public Hospital getHospital(@RequestParam("id") String id){

        return hospitalRepository.findByHospitalId(id);
    }

    @DeleteMapping(value = {"/delete/hospital/{id}"})
    public Hospital deleteHospital(@RequestParam("id") String id){

        return hospitalRepository.deleteByHospitalId(id);
    }
}
