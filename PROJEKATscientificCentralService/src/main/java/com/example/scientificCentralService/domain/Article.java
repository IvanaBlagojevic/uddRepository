package com.example.scientificCentralService.domain;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.example.scientificCentralService.dto.ArticleDTO;



@Entity
public class Article {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String heading;
	
	@Column()
	private boolean approved;
	
	//dobija se nakon objave rada
	private String doi;
	
	@ElementCollection
	private List<String> comments;
	
	//koautori
	
	@Column(nullable = false)
	private String keyTerms;
	
	@Column(nullable = false)
	private String abs;
	
	@ManyToOne
	private ScientificField main;
	
	@ManyToOne
	private Magazine magazine;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private UserModel author;
	
	@OneToMany(fetch = FetchType.LAZY) //recenzije
	private List<Review> reviews;
	
	//gde je sacuvano
	@Column(nullable = false)
	private String url;

	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Article(String heading, boolean approved, String doi, List<String> comments, String keyTerms, String abs,
			ScientificField main, Magazine magazine, UserModel author, List<Review> reviews, String url) {
		super();
		this.heading = heading;
		this.approved = approved;
		this.doi = doi;
		this.comments = comments;
		this.keyTerms = keyTerms;
		this.abs = abs;
		this.main = main;
		this.magazine = magazine;
		this.author = author;
		this.reviews = reviews;
		this.url = url;
	}




	public Article(ArticleDTO dto) {
		// TODO Auto-generated constructor stub
		this.heading=dto.getHeading();
		this.abs=dto.getAbs();
		//this.keyTerms = dto.
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHeading() {
		return heading;
	}

	public void setHeading(String heading) {
		this.heading = heading;
	}

	/*public List<String> getKeyTerms() {
		return keyTerms;
	}

	public void setKeyTerms(List<String> keyTerms) {
		this.keyTerms = keyTerms;
	}*/

	public String getAbs() {
		return abs;
	}

	public void setAbs(String abs) {
		this.abs = abs;
	}

	public ScientificField getMain() {
		return main;
	}

	public void setMain(ScientificField main) {
		this.main = main;
	}

	public Magazine getMagazine() {
		return magazine;
	}

	public void setMagazine(Magazine magazine) {
		this.magazine = magazine;
	}

	public UserModel getAuthor() {
		return author;
	}

	public void setAuthor(UserModel author) {
		this.author = author;
	}

	
	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	public String getKeyTerms() {
		return keyTerms;
	}

	public void setKeyTerms(String keyTerms) {
		this.keyTerms = keyTerms;
	}

	public List<String> getComments() {
		return comments;
	}

	public void setComments(List<String> comments) {
		this.comments = comments;
	}

	public String getDoi() {
		return doi;
	}

	public void setDoi(String doi) {
		this.doi = doi;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
	

}
