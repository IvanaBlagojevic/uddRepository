package com.example.scientificCentralService.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.scientificCentralService.domain.Article;
import com.example.scientificCentralService.repository.ArticleRepository;


@Service
public class ArticleService {
	
	@Autowired
	ArticleRepository ar;

	public Article save(Article article) {
		// TODO Auto-generated method stub
		return ar.save(article);
	}

	public Article findOneById(long parseLong) {
		// TODO Auto-generated method stub
		return ar.findOneById(parseLong);
	}

	public Article getOne(Long long1) {
		// TODO Auto-generated method stub
		return ar.getOne(long1);
	}

	public List<Article> findAll() {
		// TODO Auto-generated method stub
		return ar.findAll();
	}

}
