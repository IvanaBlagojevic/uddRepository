package com.example.scientificCentralService.domain;



import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.NaturalId;

@Entity
public class Magazine {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@NaturalId
	@Column(nullable = false, unique = true)
	private String issn;
	
	@Column()
	private boolean isActive;
	
	@Column()
	private boolean openAccess;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	@JoinTable(name="magazine_scientific_field",
	joinColumns = @JoinColumn(name="magazine_id", referencedColumnName="id"),
	inverseJoinColumns = @JoinColumn(name="scientific_field_id", referencedColumnName="id"))
	private List<ScientificField> scientificFields;
	
	@OneToOne(mappedBy="chiefInMagazine")
	private Editor chiefEditor;
	
	@OneToMany(mappedBy = "editorSCInMagazine")
	private List<Editor> editorsSC;
	
	@ManyToMany
	@JoinTable(name="magazine_reviewers",
	joinColumns = @JoinColumn(name="magazine_id", referencedColumnName="id"),
	inverseJoinColumns = @JoinColumn(name="user_id", referencedColumnName="id"))
	private List<Reviewer> reviewers;
	
	@ManyToMany
	@JoinTable(name="magazine_membership",
	joinColumns = @JoinColumn(name="magazine_id", referencedColumnName="id"),
	inverseJoinColumns = @JoinColumn(name="membershipFees_id", referencedColumnName="id"))
	private List<MembershipFees> membership;
	
	@OneToMany(mappedBy = "magazine")
	private List<Article> articles;
	
	
	public Magazine() {
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

	public String getIssn() {
		return issn;
	}

	public void setIssn(String issn) {
		this.issn = issn;
	}

	public List<ScientificField> getScientificFields() {
		return scientificFields;
	}

	public void setScientificFields(List<ScientificField> scientificFields) {
		this.scientificFields = scientificFields;
	}

	public UserModel getChiefEditor() {
		return chiefEditor;
	}

	public void setChiefEditor(Editor chiefEditor) {
		this.chiefEditor = chiefEditor;
	}

	public List<Editor> getEditorsSC() {
		return editorsSC;
	}

	public void setEditorsSC(List<Editor> editorsSC) {
		this.editorsSC = editorsSC;
	}

	public List<Reviewer> getReviewers() {
		return reviewers;
	}

	public void setReviewers(List<Reviewer> reviewers) {
		this.reviewers = reviewers;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public List<MembershipFees> getMembership() {
		return membership;
	}

	public void setMembership(List<MembershipFees> membership) {
		this.membership = membership;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean isOpenAccess() {
		return openAccess;
	}

	public void setOpenAccess(boolean openAccess) {
		this.openAccess = openAccess;
	}

	
	
	

}
