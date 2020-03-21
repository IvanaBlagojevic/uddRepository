package com.example.scientificCentralService.domain;


import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Coauthor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String surname;
	
	@Column(nullable = false)
	private String city;
	
	@Column(nullable = false)
	private String state;
	
	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false)
	private Long idAuthor; // koji ga je dodao
	
	@ManyToMany
	private List<Article> article; //za koji ga je dodao autor
	
	//za geodistance
	@NotNull
	@Column(nullable = false)
	private Double latitude;

	@NotNull
	@Column(nullable = false)
	private Double longitude;

	public Coauthor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Coauthor(String name, String surname, String city, String state, String email, Long idAuthor,
			List<Article> article, @NotNull Double latitude, @NotNull Double longitude) {
		super();
		this.name = name;
		this.surname = surname;
		this.city = city;
		this.state = state;
		this.email = email;
		this.idAuthor = idAuthor;
		this.article = article;
		this.latitude = latitude;
		this.longitude = longitude;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getIdAuthor() {
		return idAuthor;
	}

	public void setIdAuthor(Long idAuthor) {
		this.idAuthor = idAuthor;
	}

	public List<Article> getArticle() {
		return article;
	}

	public void setArticle(List<Article> article) {
		this.article = article;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

}
