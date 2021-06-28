package com.example.demo.entity;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimeSlotBO {
     
	 private long timeSlotId;
	 private LocalTime time;
	 
}
