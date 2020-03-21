package com.example.scientificCentralService.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.scientificCentralService.domain.ScientificField;
import com.example.scientificCentralService.repository.ScientificFieldRepository;


@Service
public class ScientificFieldService {
	
	@Autowired
	ScientificFieldRepository scfr;

	public List<ScientificField> findAll() {
		// TODO Auto-generated method stub
		return scfr.findAll();
	}

	public ScientificField findOneByNumber(String s) {
		// TODO Auto-generated method stub
		return scfr.findOneByNumber(s);
	}

}
