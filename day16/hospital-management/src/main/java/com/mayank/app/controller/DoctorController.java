package com.mayank.app.controller;

import com.mayank.app.model.Appointment;
import com.mayank.app.repository.AppointmentRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value ="/doctor")
public class DoctorController {

    @Autowired
    AppointmentRepository appointmentRepository;

    @GetMapping("/doctorappointment")
    public List<Appointment> getAppointments(@RequestParam String doctorName){
        return appointmentRepository.getByName(doctorName);
    }
    @PostMapping("/save")
    public Appointment saveAppointment(@RequestBody Appointment appointment){
        Appointment appointment1=appointmentRepository.save(appointment);
        log.info("-------- "+appointment1);
        return appointment1;
    }
}
