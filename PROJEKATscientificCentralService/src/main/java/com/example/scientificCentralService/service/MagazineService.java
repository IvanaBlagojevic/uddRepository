package com.example.scientificCentralService.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.scientificCentralService.domain.Magazine;
import com.example.scientificCentralService.repository.MagazineRepository;


@Service
public class MagazineService {
	
	@Autowired
	MagazineRepository mr;

	public List<Magazine> findAll() {
		// TODO Auto-generated method stub
		return mr.findAll();
	}

	public void save(Magazine m) {
		// TODO Auto-generated method stub
		mr.save(m);
	}

	public Magazine findTopByOrderByIdDesc() {
		// TODO Auto-generated method stub
		return mr.findTopByOrderByIdDesc();
	}

	public Magazine findOneByIssn(String fieldValue) {
		// TODO Auto-generated method stub
		return mr.findOneByIssn(fieldValue);
	}

}
