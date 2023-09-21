package com.mayank.app.controller;

import com.mayank.app.model.Appointment;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @GetMapping("/myappointment")
    public List<Appointment> getMyAppointments(@RequestParam String patientName){

        return null;
    }

    @PostMapping("/save")
    public Appointment saveAppointment(@RequestBody Appointment appointment){

        return appointment;
    }
}
