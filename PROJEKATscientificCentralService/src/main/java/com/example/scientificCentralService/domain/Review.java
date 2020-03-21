package com.example.scientificCentralService.domain;

import javax.persistence.*;

@Entity
public class Review {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//da izvrsi recenziju moze i urednik
	@ManyToOne(fetch = FetchType.EAGER)
	private UserModel reviewer;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Article article;
	
	

	public Review() {
		// TODO Auto-generated constructor stub
	}

	public Review(Long id, UserModel reviewer, Article article) {
		super();
		this.id = id;
		this.reviewer = reviewer;
		this.article = article;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserModel getReviewer() {
		return reviewer;
	}

	public void setReviewer(UserModel reviewer) {
		this.reviewer = reviewer;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}
	
	

}
