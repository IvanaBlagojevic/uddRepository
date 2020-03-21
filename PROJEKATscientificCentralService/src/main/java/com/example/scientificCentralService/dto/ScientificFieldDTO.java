package com.example.scientificCentralService.dto;




public class ScientificFieldDTO {
	
	private String name;
	
	private String number;
	
	

	public ScientificFieldDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ScientificFieldDTO(String name, String number) {
		super();
		this.name = name;
		this.number = number;
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
	
	

}
