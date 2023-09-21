package com.mayank.app.repository;


import com.mayank.app.model.Appointment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AppointmentRepository extends MongoRepository<Appointment,String> {

}
