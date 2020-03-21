package com.example.scientificCentralService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.scientificCentralService.domain.Review;
import com.example.scientificCentralService.repository.ReviewRepository;

@Service
public class ReviewService {

	@Autowired
	ReviewRepository rr;

	public List<Review> findAllByIdReviewer(Long id) {
		// TODO Auto-generated method stub
		return rr.findAllByReviewerId(id);
	}
	
}
