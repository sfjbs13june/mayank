package com.mayank.app.repo;


import com.mayank.app.model.Hospital;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<Hospital, Integer> {
}

