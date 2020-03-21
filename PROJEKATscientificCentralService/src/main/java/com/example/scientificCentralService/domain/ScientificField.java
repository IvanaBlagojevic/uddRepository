package com.example.scientificCentralService.domain;




import java.util.List;

import javax.persistence.*;


@Entity
public class ScientificField {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false, unique = true)
	private String number;
	
	//@ManyToMany(mappedBy = "scientificFields")
	//private List<Magazine> magazines;
	
	//@ManyToMany(mappedBy = "fields")
	//private List<UserModel> users;
	
	@OneToMany(mappedBy="main")
	private List<Article> articles;

	public ScientificField() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	/*public List<Magazine> getMagazines() {
		return magazines;
	}

	public void setMagazines(List<Magazine> magazines) {
		this.magazines = magazines;
	}

	public List<UserModel> getUsers() {
		return users;
	}

	public void setUsers(List<UserModel> users) {
		this.users = users;
	}*/

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	} 
	
	

}
