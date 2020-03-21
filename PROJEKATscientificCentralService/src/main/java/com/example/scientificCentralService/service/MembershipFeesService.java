package com.example.scientificCentralService.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.scientificCentralService.domain.MembershipFees;
import com.example.scientificCentralService.repository.MembershipFeesRepository;


@Service
public class MembershipFeesService {
	
	@Autowired
	MembershipFeesRepository mfr;

	public List<MembershipFees> findAll() {
		// TODO Auto-generated method stub
		return mfr.findAll();
	}

	public MembershipFees findOneById(long parseLong) {
		// TODO Auto-generated method stub
		return mfr.findOneById(parseLong);
	}

}
