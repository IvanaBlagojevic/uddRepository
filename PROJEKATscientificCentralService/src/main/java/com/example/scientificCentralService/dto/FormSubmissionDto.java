package com.example.scientificCentralService.dto;



import java.io.Serializable;
import java.util.ArrayList;

public class FormSubmissionDto implements Serializable{
	
	String fieldId;
	String fieldValue;
	ArrayList<String> areas = new ArrayList<String>();
	
	
	public FormSubmissionDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FormSubmissionDto(String fieldId, String fieldValue) {
		super();
		this.fieldId = fieldId;
		this.fieldValue = fieldValue;
	}

	public ArrayList<String> getAreas() {
		return areas;
	}

	public void setAreas(ArrayList<String> areas) {
		this.areas = areas;
	}

	public String getFieldId() {
		return fieldId;
	}

	public void setFieldId(String fieldId) {
		this.fieldId = fieldId;
	}

	public String getFieldValue() {
		return fieldValue;
	}

	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}
	
	
}
