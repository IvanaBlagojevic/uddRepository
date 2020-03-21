package com.example.scientificCentralService.controller;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.scientificCentralService.domain.Article;
import com.example.scientificCentralService.domain.Coauthor;
import com.example.scientificCentralService.domain.Magazine;
import com.example.scientificCentralService.domain.Review;
import com.example.scientificCentralService.domain.Reviewer;
import com.example.scientificCentralService.domain.ScientificField;
import com.example.scientificCentralService.domain.UserModel;
import com.example.scientificCentralService.elastic.ArticleIndexUnit;
import com.example.scientificCentralService.elastic.ReviewerIndexUnit;
import com.example.scientificCentralService.repository.ReviewerIndexRepository;
import com.example.scientificCentralService.service.ContentService;
import com.example.scientificCentralService.service.ReviewService;
import com.example.scientificCentralService.service.ReviewerService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.JsonObject;

@RestController
@RequestMapping("/reviewer")
@CrossOrigin(origins = "http://localhost:4200")
public class ReviewerController {
	
	@Autowired
	ReviewerService rs;
	
	@Autowired
	ReviewService reviewService;
	
	@Autowired
	ReviewerIndexRepository rir;
	
	@Autowired
	ContentService cs;
	
	@GetMapping(value = "/indexAll", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> indexArticles() throws IOException{
		List<Reviewer> reviewers = rs.findAll();
		HashMap<Long, String> send = new HashMap<>();
		for (Reviewer a : reviewers) {
			String scFilds = "";
			for (ScientificField sc : a.getFields()) {
				scFilds+=sc.getNumber() + ", ";
			}
			//geo location
			RestTemplate temp = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
			Map<String, Object> map = new HashMap<String, Object>();
			HttpEntity<Map<String,Object>> request = new HttpEntity<>(map,headers);
			//ResponseEntity<String> response = temp.exchange("https://api.opencagedata.com/geocode/v1/google-v3-json?address=Novi+Sad&pretty=1&key=c822e60c8fdb453c944dd557942fb956",HttpMethod.GET,request,String.class);
			//System.out.println("RESPONSE  " + response.getBody());
			//System.out.println("CODE" + response.getStatusCode());
			/*JsonObject geometry = ((JsonObject) response).getAsJsonObject("geometry");
			System.out.println("GEOMETRY " + geometry);
			JsonObject location = geometry.getAsJsonObject("location");
			JsonObject jsonLat = location.getAsJsonObject("lat");
			JsonObject jsonLng = location.getAsJsonObject("lng");
			double lat = jsonLat.getAsDouble();
			double lng = jsonLng.getAsDouble();
			System.out.println("LAT" + lat + " LNG" + lng);*/
			
			
			List<Review> list = reviewService.findAllByIdReviewer(a.getId());
			for (Review r : list) {
				
				
				
				
					UserModel author = r.getArticle().getAuthor();
					send.put(a.getId(), a.getName());
					String content = cs.getContent(r.getArticle().getUrl(),"reviewer");
					
					
					ReviewerIndexUnit aiu = new ReviewerIndexUnit(a.getId(), a.getName(), a.getSurname(), a.getCity(), a.getState(), r.getArticle().getMagazine().getName(), scFilds, content, new GeoPoint(a.getLatitude(), a.getLongitude()));
					rir.save(aiu);
				
			}
			
			if (list.isEmpty() && !send.containsKey(a.getId())) {
				
				ReviewerIndexUnit aiu = new ReviewerIndexUnit(a.getId(), a.getName(), a.getSurname(), a.getCity(), a.getState(), "", scFilds, "", new GeoPoint(a.getLatitude(), a.getLongitude()));
				rir.save(aiu);
			}
			
		}
		return new ResponseEntity(null, HttpStatus.OK);
	}
	
	
	

}
