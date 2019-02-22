package com.demo.spring;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.demo.spring.entity.Emp;

@Repository
public interface EmpMongoRepository extends MongoRepository<Emp, Integer> {
	

}
