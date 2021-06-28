package com.example.demo;

import org.springframework.boot.CommandLineRunner;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.entity.DestinationBO;
import com.example.demo.entity.DropPointBO;
import com.example.demo.entity.TimeSlotBO;
import com.example.demo.entity.TripCabInfo;
import com.example.demo.repo.AssignedCabRepository;
//import com.example.demo.entity.SourceBO;
import com.example.demo.repo.DestinationRepository;
//import com.example.demo.repo.SourceRepository;
//import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

//import com.example.demo.entity.TripCabInfo;
//import com.example.demo.repo.AssignedCabRepository;



@SpringBootApplication
//@EnableMongoRepositories(basePackageClasses = AssignedCabRepository.class)
public class AssignedCabApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssignedCabApplication.class, args);
	}
	@Bean
	public CommandLineRunner runner() {
		
		return new CommandLineRunner() {
		
			@Autowired
			DestinationRepository repos;
		     @Autowired
		     AssignedCabRepository repo;
			@Override
			public void run(String... args) throws Exception {
//			TripCabInfo info = new TripCabInfo(11, "TN09B6000","VARMA",978870309l,"BaylineInfo-city", "Padur", LocalTime.of(19,30, 00), LocalDate.now());
//                 this.repo.save(info);
//				DropPointBO drop1 = new DropPointBO(1, "MARINA-MALL");
//				 DropPointBO drop2 = new DropPointBO(2, "SPICOT");
//				 List<DropPointBO> dropPoints = new ArrayList<>();
//				 dropPoints.add(drop1);
//				 dropPoints.add(drop2);
//				
//				 TimeSlotBO slot1 = new TimeSlotBO(1, LocalTime.of(10,30, 00));
//				 TimeSlotBO slot2 = new TimeSlotBO(2, LocalTime.of(11,30, 00));
//				 TimeSlotBO slot3 = new TimeSlotBO(3, LocalTime.of(19,30, 00));
//				 TimeSlotBO slot4 = new TimeSlotBO(4, LocalTime.of(20,30, 00));
//				 List<TimeSlotBO> timeSlots = new ArrayList<>();
//				 timeSlots.add(slot1);
//				 timeSlots.add(slot2);
//				 timeSlots.add(slot3);
//				 timeSlots.add(slot4);
//				 System.out.println("timeslots list  -> "+timeSlots);
//				 DestinationBO destination = new DestinationBO(1, "Padur",timeSlots,dropPoints);
//				 this.repos.save(destination);
				


			
			
			}
		};
	}
}
