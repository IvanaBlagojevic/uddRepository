package com.example.scientificCentralService.domain;


import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;


@Entity
@DiscriminatorValue("R")
public class Reviewer extends UserModel{
	
	//potvrda admina
	@Column()
	private boolean isConfirmedReviewer;
	
	//kojim sve casopisima recezent pripada
	//@ManyToMany
	//private List<Magazine> reviwerInMagazines;

	public Reviewer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Reviewer(String name, String surname, String city, String state, String title, String email, String username,
			String password, String uniqueID, boolean isActive, boolean isAuthor, boolean isReviewer,Set<ScientificField> fields, List<Magazine> reviwerInMagazines, Set<UserRole> role
			, List<Review> reviews, Double latitude, Double longitude) {
		super(name, surname, city, state, title, email, username, password, uniqueID, isActive, isAuthor, isReviewer, fields, role,reviews, latitude, longitude);
		// TODO Auto-generated constructor stub
		//this.reviwerInMagazines = reviwerInMagazines;
		this.isConfirmedReviewer = false;
	}

	/*public List<Magazine> getReviwerInMagazines() {
		return reviwerInMagazines;
	}

	public void setReviwerInMagazines(List<Magazine> reviwerInMagazines) {
		this.reviwerInMagazines = reviwerInMagazines;
	}*/

	public boolean isConfirmedReviewer() {
		return isConfirmedReviewer;
	}

	public void setConfirmedReviewer(boolean isConfirmedReviewer) {
		this.isConfirmedReviewer = isConfirmedReviewer;
	}

	

}
