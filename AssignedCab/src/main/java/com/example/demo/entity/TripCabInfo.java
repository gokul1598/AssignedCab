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
@Document(collection="TripcabInfo1")
public class TripCabInfo {
  @Id
  private  int cabid;
  private String cabNumber;
   long driverId;
//  private String driverName;
//  private long driverNumber;
  private String source;
  private String destination;
  private LocalTime timeSlot;
  private LocalDate date;
  private String status;
   private int totalSeats;
   private int remainingSeats;
   private int allocatedSeats;
   private LocalTime startTime;
   private LocalTime endTime;
   private String createdBy;
   private LocalDate createdDate;
   private LocalDate modifyDate;
   private String modifyBy;
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
public TripCabInfo(int cabid, String cabNumber, long driverId, String source, String destination, LocalTime timeSlot,
		LocalDate date, String status) {
	super();
	this.cabid = cabid;
	this.cabNumber = cabNumber;
	this.driverId = driverId;
	this.source = source;
	this.destination = destination;
	this.timeSlot = timeSlot;
	this.date = date;
	this.status = status;
}

}

  
  

