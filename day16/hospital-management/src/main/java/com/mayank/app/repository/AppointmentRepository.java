package com.mayank.app.repository;


import com.mayank.app.model.Appointment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AppointmentRepository extends MongoRepository<Appointment,String> {

    public List<Appointment> getByName(String doctorName);
    public Appointment save(Appointment appointment);

}
