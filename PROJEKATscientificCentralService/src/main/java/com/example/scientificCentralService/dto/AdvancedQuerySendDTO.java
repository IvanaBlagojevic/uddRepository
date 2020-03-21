package com.example.scientificCentralService.dto;

public class AdvancedQuerySendDTO {

	private String operation;
	
	private String field;
	
	private String query;
	
	private boolean phrase;
	
	public AdvancedQuerySendDTO() {
	}

	public AdvancedQuerySendDTO(String operation, String field, String query, boolean phrase) {
		super();
		this.operation = operation;
		this.field = field;
		this.query = query;
		this.phrase = phrase;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public boolean isPhrase() {
		return phrase;
	}

	public void setPhrase(boolean phrase) {
		this.phrase = phrase;
	}

	
	
}
