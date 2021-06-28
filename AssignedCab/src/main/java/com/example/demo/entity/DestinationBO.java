package com.example.demo.entity;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="Destination")
public class DestinationBO {
 private long id;
 private String destination;
 private List<TimeSlotBO> slot;
 private List<DropPointBO> dropPoints;
 
// private TimeSlotBO List<TimeSlotBO>;
public DestinationBO(String destination) {
	super();
	this.destination = destination;
}
 
 
}
