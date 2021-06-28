package com.example.demo.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.entity.SourceBO;

public interface SourceRepository extends MongoRepository<SourceBO, Integer> {

	
	
}
