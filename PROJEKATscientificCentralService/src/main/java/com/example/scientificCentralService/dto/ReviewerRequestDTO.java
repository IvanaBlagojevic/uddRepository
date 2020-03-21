package com.example.scientificCentralService.dto;

import java.util.ArrayList;

public class ReviewerRequestDTO {

	ArrayList<String> fields;
	boolean moreLikeThis;
	boolean inDomain;
	

	public ReviewerRequestDTO() {
		// TODO Auto-generated constructor stub
	}

	
	

	public ReviewerRequestDTO(ArrayList<String> fields, boolean moreLikeThis, boolean inDomain) {
		super();
		this.fields = fields;
		this.moreLikeThis = moreLikeThis;
		this.inDomain = inDomain;
	}




	public ArrayList<String> getFields() {
		return fields;
	}


	public void setFields(ArrayList<String> fields) {
		this.fields = fields;
	}


	public boolean isMoreLikeThis() {
		return moreLikeThis;
	}


	public void setMoreLikeThis(boolean moreLikeThis) {
		this.moreLikeThis = moreLikeThis;
	}


	public boolean isInDomain() {
		return inDomain;
	}


	public void setInDomain(boolean inDomain) {
		this.inDomain = inDomain;
	}

	

	
	
}
