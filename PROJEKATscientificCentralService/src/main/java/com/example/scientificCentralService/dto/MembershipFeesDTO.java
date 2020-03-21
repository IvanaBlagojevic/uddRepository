package com.example.scientificCentralService.dto;



public class MembershipFeesDTO {
	
	private Long id;
	private String name;

	public MembershipFeesDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public MembershipFeesDTO(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
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
	
	

}
