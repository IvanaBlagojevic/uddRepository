package com.example.scientificCentralService.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.scientificCentralService.domain.Article;
import com.example.scientificCentralService.domain.Coauthor;
import com.example.scientificCentralService.repository.CoauthorRepository;


@Service
public class CoauthorServices {

	@Autowired
	CoauthorRepository car;

	public List<Coauthor> findAllByArticle(Article id) {
		// TODO Auto-generated method stub
		return car.findAllByArticle(id);
	}
	
	
}
