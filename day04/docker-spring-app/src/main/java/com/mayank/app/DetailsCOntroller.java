package com.mayank.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DetailsCOntroller {

    @GetMapping("/name")
    public String getName(){
        return "Mayank";
    }

    @GetMapping("/age")
    public String getAge(){
        return "32";
    }

    @GetMapping("/address")
    public String getAddress(){
        return "Bangalore";
    }
}
