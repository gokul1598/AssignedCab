package com.example.demo.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.entity.DestinationBO;

public interface DestinationRepository extends MongoRepository<DestinationBO, Integer> {

}
