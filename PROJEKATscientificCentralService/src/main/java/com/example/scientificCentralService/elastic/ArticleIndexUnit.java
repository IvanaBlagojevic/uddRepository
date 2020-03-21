package com.example.scientificCentralService.elastic;

import javax.persistence.Id;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import com.example.scientificCentralService.dto.ArticleDTO;

@Document(indexName="articleindexnova", type="articlenova", shards = 1, replicas = 0)
public class ArticleIndexUnit {
	
	@Id
	private Long id;
	
	@Field(type = FieldType.Text, store = true, analyzer="serbian")
	private String heading;
	
	@Field(type = FieldType.Text, store = true, analyzer="serbian")
	private String keyterms;
	
	@Field(type = FieldType.Text, store = true, analyzer="serbian")
	private String abs;
	
	@Field(type = FieldType.Text, store = true, analyzer="serbian")
	private String mainSC;
	
	@Field(type = FieldType.Text, store = true, analyzer="serbian")
	private String magazine;
	
	//@Field(type = FieldType.Text, analyzer="serbian")
	@Field(type = FieldType.Text, store = true, analyzer="serbian")
	private String content;

	@Field(type = FieldType.Text, store = true, analyzer="serbian")
	private String author;
	
	@Field(type = FieldType.Text, store = true, analyzer="serbian")
	private String coauthor;
	
	@Field(type = FieldType.Boolean, store = true)
	private boolean openAccess;
	
	@Field(type = FieldType.Boolean, store = true)
	private boolean approved;
	
	public ArticleIndexUnit() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public ArticleIndexUnit(ArticleDTO a) {
		// TODO Auto-generated constructor stub
		this.id = a.getId();
		this.heading = a.getHeading();
		this.abs = a.getAbs();
	}
	
	public ArticleIndexUnit(Long id, String heading, String keyterms, String abs, String mainSC, String magazine,
			String content, String author, String coauthor, boolean openAccess, boolean approved) {
		super();
		this.id = id;
		this.heading = heading;
		this.keyterms = keyterms;
		this.abs = abs;
		this.mainSC = mainSC;
		this.magazine = magazine;
		this.content = content;
		this.author = author;
		this.coauthor = coauthor;
		this.openAccess = openAccess;
		this.approved = approved;
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

	public String getAbs() {
		return abs;
	}

	public void setAbs(String abs) {
		this.abs = abs;
	}

	

	public String getKeyterms() {
		return keyterms;
	}



	public void setKeyterms(String keyterms) {
		this.keyterms = keyterms;
	}



	public String getMainSC() {
		return mainSC;
	}



	public void setMainSC(String mainSC) {
		this.mainSC = mainSC;
	}



	public String getAuthor() {
		return author;
	}



	public void setAuthor(String author) {
		this.author = author;
	}



	public String getCoauthor() {
		return coauthor;
	}



	public void setCoauthor(String coauthor) {
		this.coauthor = coauthor;
	}

	

	public boolean isOpenAccess() {
		return openAccess;
	}



	public void setOpenAccess(boolean openAccess) {
		this.openAccess = openAccess;
	}



	public String getMagazine() {
		return magazine;
	}

	public void setMagazine(String magazine) {
		this.magazine = magazine;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}



	public boolean isApproved() {
		return approved;
	}



	public void setApproved(boolean approved) {
		this.approved = approved;
	}
	
	
	

}
