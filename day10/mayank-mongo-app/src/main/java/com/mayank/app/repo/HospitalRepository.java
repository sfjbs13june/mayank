package com.mayank.app.repo;

import com.mayank.app.model.Hospital;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalRepository extends MongoRepository<Hospital, String>{


	//public Hospital findByHospitalName(String name);
	public Hospital findByHospitalId(String name);
	public Hospital deleteByHospitalId(String id);
	public Hospital saveHospital(Hospital hospital);

}
