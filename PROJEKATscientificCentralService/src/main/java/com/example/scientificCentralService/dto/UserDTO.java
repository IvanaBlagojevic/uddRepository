package com.example.scientificCentralService.dto;


import java.io.Serializable;
import java.util.Set;

import com.example.scientificCentralService.domain.UserModel;
import com.example.scientificCentralService.domain.UserRole;



public class UserDTO implements Serializable{
	
	private Long id;
	
	private String name;
	
	private String surname;
	
	private String city;
	
	private String state;
	
	private String title;
	
	private String email;
	
	private boolean isAuthor;
	
	private boolean isReviewer;
	
	private String username;
	
	private String password;
	
	private Set<UserRole> roles;
	
	private MagazineDTO magazine;
	
	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDTO(Long id,String name, String surname, String city, String state, String title, String email, boolean isAuthor,
			boolean isReviewer, String username, String password) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.city = city;
		this.state = state;
		this.title = title;
		this.email = email;
		this.isAuthor = isAuthor;
		this.isReviewer = isReviewer;
		this.username = username;
		this.password = password;
	}
	
	public UserDTO(String name, String email) {
		this.name = name;
		this.email = email;
	}

	public UserDTO(UserModel userModel) {
		// TODO Auto-generated constructor stub
		this.name = userModel.getName();
		this.surname = userModel.getSurname();
		this.city = userModel.getCity();
		this.state = userModel.getState();
		this.title = userModel.getTitle();
		this.email = userModel.getEmail();
		this.isAuthor = userModel.isAuthor();
		this.isReviewer = userModel.isReviewer();
		this.username = userModel.getUsername();
		this.roles = userModel.getRoles();
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

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isAuthor() {
		return isAuthor;
	}

	public void setAuthor(boolean isAuthor) {
		this.isAuthor = isAuthor;
	}

	public boolean isReviewer() {
		return isReviewer;
	}

	public void setReviewer(boolean isReviewer) {
		this.isReviewer = isReviewer;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<UserRole> getRoles() {
		return roles;
	}

	public void setRoles(Set<UserRole> roles) {
		this.roles = roles;
	}

	public MagazineDTO getMagazine() {
		return magazine;
	}

	public void setMagazine(MagazineDTO magazine) {
		this.magazine = magazine;
	}
	
	

}
