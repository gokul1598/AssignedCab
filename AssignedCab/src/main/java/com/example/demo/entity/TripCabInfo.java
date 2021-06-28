package com.example.demo.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="TripcabInfo")
public class TripCabInfo {
  @Id
  private  int cabid;
  private String cabNumber;
  private String driverName;
  private long driverNumber;
  private String source;
  private String destination;
  private LocalTime timeSlot;
  private LocalDate date;
 
//public TripCabInfo(String cabNumber, String driverName, long driverNumber, String source, String destination,
//		String timeSlot) {
//	super();
//	this.cabNumber = cabNumber;
//	this.driverName = driverName;
//	this.driverNumber = driverNumber;
//	this.source = source;
//	this.destination = destination;
//	this.timeSlot = timeSlot;
//}

}

  
  

