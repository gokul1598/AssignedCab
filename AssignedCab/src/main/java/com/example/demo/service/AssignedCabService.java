package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.entity.DestinationBO;
import com.example.demo.entity.SourceBO;
import com.example.demo.entity.TripCabInfo;
import com.example.demo.repo.AssignedCabRepository;
import com.example.demo.repo.DestinationRepository;
import com.example.demo.repo.SourceRepository;


@Service(value ="AssignedCabService")
public class AssignedCabService {
	
	@Autowired
    private AssignedCabRepository repo;
	@Autowired
    SourceRepository reposrc;
	@Autowired
	DestinationRepository repos;
	
	public TripCabInfo save(TripCabInfo info) {
		//info.setCabid(repo.count() +1);
		int count = (int) repo.count()+1;
		info.setCabid(count);
      return this.repo.save(info);
	}

	public List<TripCabInfo> findAll() {
		System.out.println(repo.count());
		return this.repo.findAll();
	}

	public Long getCount() {
		return this.repo.count();
	}

	public List<SourceBO> findSource() {
		
		return this.reposrc.findAll();
	}

	public List<DestinationBO> findByDestination() {
		
		return this.repos.findAll();
	}
//------------------------------------------Testing Purpose-------------------------------------------------
	public SourceBO save(SourceBO source) {
		
		return this.reposrc.save(source);
	}

	public DestinationBO save(DestinationBO des) {
		des.setId(repos.count() +1);
		return this.repos.save(des);
	}

	public List<TripCabInfo> findByCabNumber(String cabNumber) {
		return this.repo.findByCabNumber(cabNumber);
	}

	public List<TripCabInfo> findByDestination(String destination) {
		return this.repo.findByDestination(destination);
	}

	public List<TripCabInfo> findByDriverName(String driverName) {
	
		return this.repo.findByDriverName(driverName);
	}

	public List<TripCabInfo> findByFilter(TripCabInfo book1) {
		
		return this.repo.findAll(Example.of(book1));
	}

	public Page<TripCabInfo> findAll(PageRequest paging) {
		
		return this.repo.findAll(paging);
	}





	
	
}
