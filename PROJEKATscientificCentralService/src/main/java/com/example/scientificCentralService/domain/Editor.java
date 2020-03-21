package com.example.scientificCentralService.domain;


import java.util.List;
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("E")
public class Editor extends UserModel{
	
	//ako je glavni ili NO urednik, onda je i reviewer ali samo u tom casopisu
	@OneToOne
	private Magazine chiefInMagazine;
	
	@ManyToOne
	private Magazine editorSCInMagazine;
	
	

	public Editor() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Editor(String name, String surname, String city, String state, String title, String email, String username,
			String password, String uniqueID, boolean isActive, boolean isAuthor, boolean isReviewer,Set<ScientificField> fields, Magazine chiefInMagazine, Magazine editorSCInMagazine, Set<UserRole> role
			, List<Review> reviews, Double longitude, Double latitude) {
		super(name, surname, city, state, title, email, username, password, uniqueID, isActive, isAuthor, isReviewer, fields, role, reviews, longitude, latitude);
		// TODO Auto-generated constructor stub
		this.chiefInMagazine = chiefInMagazine;
		this.editorSCInMagazine = editorSCInMagazine;
	}

	public Magazine getChiefInMagazine() {
		return chiefInMagazine;
	}

	public void setChiefInMagazine(Magazine chiefInMagazine) {
		this.chiefInMagazine = chiefInMagazine;
	}

	public Magazine getEditorSCInMagazine() {
		return editorSCInMagazine;
	}

	public void setEditorSCInMagazine(Magazine editorSCInMagazine) {
		this.editorSCInMagazine = editorSCInMagazine;
	}
	
	

}
