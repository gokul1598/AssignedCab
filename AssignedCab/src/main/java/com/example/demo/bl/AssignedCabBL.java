package com.example.demo.bl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entity.DestinationBO;
import com.example.demo.entity.DriverInfo;
import com.example.demo.entity.SourceBO;
import com.example.demo.entity.TripCabInfo;
import com.example.demo.service.AssignedCabService;

@Component
public class AssignedCabBL {
	@Autowired
	AssignedCabService service;

	public TripCabInfo save(TripCabInfo info) {

		return this.service.save(info);
	}

	public List<TripCabInfo> findAll() {

		return this.service.findAll();
	}

	public List<SourceBO> findSource() {

		return this.service.findSource();
	}

	public List<DestinationBO> findDestination() {

		return this.service.findByDestination();
	}

	public Long getCount() {

		return this.service.getCount();
	}

//-----------------------------------------Testing Purpose-----------------------------------------------------------
	public SourceBO save(SourceBO source) {

		return this.service.save(source);
	}

	public DestinationBO save(DestinationBO des) {

		return this.service.save(des);
	}

	public List<TripCabInfo> findByCabNumber(String cabNumber) {

		return this.service.findByCabNumber(cabNumber);
	}

	public List<TripCabInfo> findByDestination(String destination) {

		return this.service.findByDestination(destination);
	}

//	public List<TripCabInfo> findByDriverName(String driverName) {
//
//		return this.service.findByDriverName(driverName);
//	}

	public DriverInfo save(DriverInfo driver) {
		
		return this.service.save(driver);
	}

}
