package com.example.scientificCentralService.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.scientificCentralService.domain.Reviewer;
import com.example.scientificCentralService.repository.ReviewerRepository;


@Service
public class ReviewerService {
	
	@Autowired
	ReviewerRepository rr;

	public List<Reviewer> findAll() {
		// TODO Auto-generated method stub
		return rr.findAll();
	}

	public void save(Reviewer r) {
		// TODO Auto-generated method stub
		rr.save(r);
	}

	public Reviewer findOneByEmail(String s) {
		// TODO Auto-generated method stub
		return rr.findOneByEmail(s);
	}

}
