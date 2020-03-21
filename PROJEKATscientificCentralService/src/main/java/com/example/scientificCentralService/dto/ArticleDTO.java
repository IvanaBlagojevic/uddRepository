package com.example.scientificCentralService.dto;

import javax.persistence.Column;

import com.example.scientificCentralService.domain.Article;

public class ArticleDTO {
	
	private Long id;
	
	private String heading;
	
	private String abs;
		
	private String keyTerms;
		
	private String mainSC;
	    
	private MagazineDTO magazinel;
	//private String content;
	private UserDTO author;
	
	private String coauthor;
	private boolean openAccess;


	public ArticleDTO(Article a) {
		super();
		// TODO Auto-generated constructor stub
		this.id = a.getId();
		this.heading = a.getHeading();
		this.abs = a.getAbs();
		this.keyTerms = a.getKeyTerms();
		this.mainSC = a.getMain().getName();
		this.magazinel = new MagazineDTO(a.getMagazine());
		this.author = new UserDTO(a.getAuthor());
		this.openAccess = a.getMagazine().isOpenAccess();
	}
	

	public ArticleDTO(Long id, String heading, String abs) {
		super();
		this.id = id;
		this.heading = heading;
		this.abs = abs;
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


	public String getKeyTerms() {
		return keyTerms;
	}


	public void setKeyTerms(String keyTerms) {
		this.keyTerms = keyTerms;
	}


	public String getMainSC() {
		return mainSC;
	}


	public void setMainSC(String mainSC) {
		this.mainSC = mainSC;
	}


	public MagazineDTO getMagazinel() {
		return magazinel;
	}


	public void setMagazinel(MagazineDTO magazinel) {
		this.magazinel = magazinel;
	}


	public UserDTO getAuthor() {
		return author;
	}


	public void setAuthor(UserDTO author) {
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

	
}
