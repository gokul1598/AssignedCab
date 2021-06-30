package com.example.demo.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.stereotype.Repository;

import com.example.demo.entity.SourceBO;
import com.example.demo.entity.TripCabInfo;

public interface AssignedCabRepository extends MongoRepository<TripCabInfo ,Integer> {

	List<TripCabInfo> findByCabNumber(String cabNumber);

	List<TripCabInfo> findByDestination(String destination);

	//List<TripCabInfo> findByDriverName(String driverName);

	

	



	
   
	

}
