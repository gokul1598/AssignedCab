package com.example.demo.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TripDetails {
	
	  private  int cabid;
	  private String cabNumber;
	   DriverInfo driver;
	  private String source;
	  private String destination;
	  private LocalTime timeSlot;
	  private LocalDate date;
	  private String status;
}
