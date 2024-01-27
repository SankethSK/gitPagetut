package com.example.sample;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface personRepo extends MongoRepository<Person,String>{
	
}

