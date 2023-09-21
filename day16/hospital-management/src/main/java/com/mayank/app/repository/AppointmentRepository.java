package com.mayank.app.repository;

import com.mayank.app.model.Appointment;
import org.springframework.stereotype.Repository;
//import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface AppointmentRepository extends MongoRepository<Appointment, String>{
}
