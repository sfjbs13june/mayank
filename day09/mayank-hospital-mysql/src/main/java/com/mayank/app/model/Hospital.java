package com.mayank.app.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;

@Setter
@Getter
@ToString
@Entity
public class Hospital {
    private String id;
    private String name;

    private String address;

    public Hospital(String name, String id, String address){
        this.name = name;
        this.id = id;
        this.address = address;

    }
}
