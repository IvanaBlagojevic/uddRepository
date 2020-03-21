package com.example.scientificCentralService.elastic;

import javax.persistence.Id;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.GeoPointField;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;

@Document(indexName="reviewerindex", type="reviewer", shards = 1, replicas = 0)
public class ReviewerIndexUnit {
	
	@Id
	private Long id;
	
	@Field(type = FieldType.Long, store = true)
	private Long idReviewer;
	
	@Field(type = FieldType.Text, store = true, analyzer="serbian")
	private String name;
	
	@Field(type = FieldType.Text, store = true, analyzer="serbian")
	private String surname;
	
	@Field(type = FieldType.Text, store = true, analyzer="serbian")
	private String city;
	
	@Field(type = FieldType.Text, store = true, analyzer="serbian")
	private String state;
	
	@Field(type = FieldType.Text, store = true, analyzer="serbian")
	private String magazine;
	
	@Field(type = FieldType.Text, store = true, analyzer="serbian")
	private String scientificFields;

	@Field(type = FieldType.Text, store = true, analyzer="serbian")
	private String contentOfReview;
	
	//authora
	@GeoPointField
	private GeoPoint location;
	

	public ReviewerIndexUnit() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReviewerIndexUnit(Long idReviewer, String name, String surname, String city, String state,
			String magazine, String scientificFields, String contentOfReview, GeoPoint location) {
		super();
		this.idReviewer = idReviewer;
		this.name = name;
		this.surname = surname;
		this.city = city;
		this.state = state;
		this.magazine = magazine;
		this.scientificFields = scientificFields;
		this.contentOfReview = contentOfReview;
		this.location = location;
	}

	public ReviewerIndexUnit(String name, String surname, String city, String state) {
		this.name = name;
		this.surname = surname;
		this.city = city;
		this.state = state;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getMagazine() {
		return magazine;
	}

	public void setMagazine(String magazine) {
		this.magazine = magazine;
	}

	public String getScientificFields() {
		return scientificFields;
	}

	public void setScientificFields(String scientificFields) {
		this.scientificFields = scientificFields;
	}
	
	public Long getIdReviewer() {
		return idReviewer;
	}

	public void setIdReviewer(Long idReviewer) {
		this.idReviewer = idReviewer;
	}

	public String getContentOfReview() {
		return contentOfReview;
	}

	public void setContentOfReview(String contentOfReview) {
		this.contentOfReview = contentOfReview;
	}

	public GeoPoint getLocation() {
		return location;
	}

	public void setLocation(GeoPoint location) {
		this.location = location;
	}
	
	

}
