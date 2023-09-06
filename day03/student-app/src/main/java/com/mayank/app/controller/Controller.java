package com.mayank.app.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/getstudent")
    public String getDetails() {
        return "Student1";
    }
    @PutMapping("/updatestudent")
    public String updateDetails() {
        return "Updeted student1";
    }
    @DeleteMapping("/deletestudent")
    public String deleteDetails() {
        return "deleted Student1";
    }
}
