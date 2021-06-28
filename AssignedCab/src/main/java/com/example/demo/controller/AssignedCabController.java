package com.example.demo.controller;

import java.util.stream.Collectors;
import java.time.LocalTime;
//import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.util.concurrent.CompletableToListenableFutureAdapter;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bl.AssignedCabBL;
import com.example.demo.entity.DestinationBO;
import com.example.demo.entity.SourceBO;
import com.example.demo.entity.TripCabInfo;
//import com.example.demo.repo.AssignedCabRepository;
//import com.example.demo.repo.DestinationRepository;
//import com.example.demo.repo.SourceRepository;
//import com.example.demo.service.AssignedCabService;

@RestController
@RequestMapping(path = "/api/v1")

public class AssignedCabController {
	@Autowired
	AssignedCabBL bl;
	@Autowired
	private MongoTemplate template;
//----------------------------------AssignedCab Method Starts--------------------------------------------------	

// FindAll method--->starts

	@GetMapping(path = "/assignedCab/cabs")
	public ResponseEntity<List<TripCabInfo>> findAll() {

		List<TripCabInfo> trip = this.bl.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(trip);
	}
//-------------------------------------------------------------------------------------------	

// To add source to dropDown ---> controller
	@PostMapping(path = "/source")
	public ResponseEntity<SourceBO> addSource(@RequestBody SourceBO source) {
		SourceBO src = this.bl.save(source);
		return ResponseEntity.status(HttpStatus.OK).body(src);
	}

	@GetMapping(path = "/sourcelist")
	public ResponseEntity<List<SourceBO>> getSource() {
		List<SourceBO> source = this.bl.findSource();
		return ResponseEntity.status(HttpStatus.OK).body(source);
	}
	// ----> source ---> end

//---------------------------------------------------------------------------------------  
//-->To add DestinationBo List to dropDown - starts

	@PostMapping(path = "/destination")
	public ResponseEntity<DestinationBO> addDestination(@RequestBody DestinationBO des) {

		DestinationBO desBo = this.bl.save(des);
		return ResponseEntity.status(HttpStatus.OK).body(desBo);
	}

	@GetMapping(path = "/destinationlist")
	public ResponseEntity<List<DestinationBO>> getDestination() {
		List<DestinationBO> dest = this.bl.findDestination();
		return ResponseEntity.status(HttpStatus.OK).body(dest);
	}
// ----- DestinationBo ends  

//---------------------------------------------------------------------------------------   

// Using MongoTemplate for (FilterRequest)  
	@GetMapping("/filter/{source}/{destination}/{timeSlot}/{skip}/{limit}")
	public ResponseEntity<List<TripCabInfo>> getByFilterRequest(@PathVariable("source") String source,
			@PathVariable("destination") String destination, @PathVariable("timeSlot") String timeSlot,
			@PathVariable("skip") long skip, @PathVariable("limit") int limit) {
		Query dynamicQuery = new Query();
		if (!(source.equals("0"))) {
			Criteria sourceCriteria = Criteria.where("source").is(source);
			dynamicQuery.addCriteria(sourceCriteria);
		}
		if (!(destination.equals("0"))) {
			Criteria destinationCriteria = Criteria.where("destination").is(destination);
			dynamicQuery.addCriteria(destinationCriteria);

		}
		dynamicQuery.limit(limit).skip(skip);
		List<TripCabInfo> result = template.find(dynamicQuery, TripCabInfo.class, "TripcabInfo");
		if (!(timeSlot.equals("0"))) {

			LocalTime lt = LocalTime.parse(timeSlot);
			List<TripCabInfo> timeFilter = result.stream().filter(e -> e.getTimeSlot().equals(lt))
					.collect(Collectors.toList());
			return ResponseEntity.status(HttpStatus.OK).body(timeFilter);
		}
		return ResponseEntity.status(HttpStatus.OK).body(result);

	}

//---------------------------------------------------------------------------------------   
// Scroll method with MongoTemplate to Fetch all AssignedCabs-------FindAll
	@GetMapping(path = "/scroll/{skip}/{limit}")
	public ResponseEntity<List<TripCabInfo>> getByScroll(@PathVariable("skip") long skip,
			@PathVariable("limit") int limit) {
		Query query = new Query();
		query.limit(limit).skip(skip);

		List<TripCabInfo> cabs = this.template.find(query, TripCabInfo.class, "TripcabInfo");
		return ResponseEntity.status(HttpStatus.OK).body(cabs);
	}

//---------------------------------------------------------------------------------------
// To get the data count
	@GetMapping(path = "/count")
	public ResponseEntity<Long> getCount() {
		Long count = this.bl.getCount();
		return ResponseEntity.status(HttpStatus.OK).body(count);
	}

//--------------------------------------------------------------------------------------
//Search Method
	@GetMapping(path = "/{searchValue}/{skip}/{limit}")
	public ResponseEntity<List<TripCabInfo>> textSearch1(@PathVariable(name = "searchValue") String text,
			@PathVariable("skip") long skip, @PathVariable("limit") int limit) {

		Query query = new Query();

		Criteria c1 = Criteria.where("driverName").regex(text, "i");
		Criteria c2 = Criteria.where("cabNumber").regex(text, "i");

		Criteria criteria = new Criteria();
		criteria.orOperator(c1, c2);
		query.addCriteria(criteria);
		query.skip(skip).limit(limit);
		List<TripCabInfo> search = template.find(query, TripCabInfo.class);
		return ResponseEntity.status(HttpStatus.OK).body(search);
	}
// Search----> ends.

//---------------------------------AssignedCab Methods End-------------------------------------------------------	

//----------------------------------FOR TESTING PURPOSE----------------------------------------

//find by cabNumber	
	@GetMapping(path = "/cab/{cabNumber}")
	public ResponseEntity<List<TripCabInfo>> getCabByCabNumber(@PathVariable("cabNumber") String cabNumber) {
		List<TripCabInfo> cabno = this.bl.findByCabNumber(cabNumber);
		return ResponseEntity.status(HttpStatus.OK).body(cabno);
	}

//find by Destination  
	@GetMapping(path = "/destination/{destination}")
	public ResponseEntity<List<TripCabInfo>> getCabByDestination(@PathVariable("destination") String destination) {
		List<TripCabInfo> des = this.bl.findByDestination(destination);
		return ResponseEntity.status(HttpStatus.OK).body(des);
	}

//find by driverName
	@GetMapping(path = "/drivername/{driverName}")
	public ResponseEntity<List<TripCabInfo>> getByDriverName(@PathVariable("driverName") String driverName) {
		List<TripCabInfo> drivername = this.bl.findByDriverName(driverName);
		return ResponseEntity.status(HttpStatus.OK).body(drivername);
	}

//---------------------------------------------------------------------------------------------------------------  
//for cab assigning cab		
	@PostMapping(path = "/assignedCab")
	public ResponseEntity<TripCabInfo> addCab(@RequestBody TripCabInfo info) {

		TripCabInfo cab = this.bl.save(info);
		return ResponseEntity.status(HttpStatus.CREATED).body(cab);

	}
//--------------------------------------------------------------------------------------------------------------

//-------------PAGINATION--pagination method by passing PageIndex and RowCount 

//	@GetMapping(path="/onscroll/{pageIndex}/{rowCount}") 
//		public Page<TripCabInfo> getByOnScroll(@PathVariable("pageIndex") int pageIndex,@PathVariable("rowCount")int rowCount){
//		PageRequest paging = PageRequest.of(pageIndex, rowCount); // pagerequest is IMP of Pagable
//		 Page<TripCabInfo> pagedResult = service.findAll(paging);
//		List<TripCabInfo> cab=this.service.findByOnScroll(pageIndex,rowCount);
//	     return cab;
//		 return pagedResult;
//	}

//---------------------------------------------------------------------------------------------------------------	
	// FilterRequest

//  @GetMapping(path="/filter")
//  public List<TripCabInfo> findByFilterRequest(@RequestBody TripCabInfo cab){
//	  // List<TripCabInfo> cabinfo=this.service.findByFilterRequest(cab);
//	   return this.service.findByFilterRequest(cab);
//			   
//  }

//----------------------------------------------------------------------------------------
//Filter without using MongoTemplate    
//  @PostMapping("/books/srch/filters")
//  public List<TripCabInfo> getByFilter(@RequestBody TripCabInfo book1)
//  {
//     
//      return this.bl.findByFilter(book1);
//  }	

}
