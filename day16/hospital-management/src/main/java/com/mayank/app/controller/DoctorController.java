package com.mayank.app.controller;

import com.mayank.app.model.Appointment;
import com.mayank.app.repository.AppointmentRepository;
import com.mayank.app.repository.AppointmentRepository1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value ="/doctor")
public class DoctorController {

    @Autowired
    AppointmentRepository appointmentRepository;

    @GetMapping("/doctorappointment")
    public List<Appointment> getAppointments(@RequestParam String doctorName){

        return null;
    }
    @PostMapping("/save")
    public Appointment saveAppointment(@RequestBody Appointment appointment){

        return appointment;
    }
}
