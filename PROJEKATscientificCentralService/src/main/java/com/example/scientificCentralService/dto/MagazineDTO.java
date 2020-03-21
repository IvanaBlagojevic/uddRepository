package com.example.scientificCentralService.dto;

import java.io.Serializable;

import com.example.scientificCentralService.domain.Magazine;

public class MagazineDTO implements Serializable{
	
	private String name;
	
	private String issn;
	
	private boolean isActive;
	
	private boolean openAccess;
	
	public MagazineDTO(String name, String issn, boolean isActive, boolean openAccess) {
		super();
		this.name = name;
		this.issn = issn;
		this.isActive = isActive;
		this.openAccess = openAccess;
	}

	public MagazineDTO(Magazine m) {
		name = m.getName();
		issn = m.getIssn();
		isActive = m.isActive();
		openAccess = m.isOpenAccess();
	}
	
	public MagazineDTO() {
		super();
		// TODO Auto-generated constructor stub
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
