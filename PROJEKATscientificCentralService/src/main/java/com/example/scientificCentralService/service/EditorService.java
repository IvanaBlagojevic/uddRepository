package com.example.scientificCentralService.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.scientificCentralService.domain.Editor;
import com.example.scientificCentralService.repository.EditorRepository;


@Service
public class EditorService {

	@Autowired
	EditorRepository er;

	public List<Editor> findAll() {
		// TODO Auto-generated method stub
		return er.findAll();
	}

	public Editor findOneByEmail(String s) {
		// TODO Auto-generated method stub
		return er.findOneByEmail(s);
	}

	public Editor findOneByUsername(String whoCreateMagazine) {
		// TODO Auto-generated method stub
		return er.findOneByUsername(whoCreateMagazine);
	}
}
