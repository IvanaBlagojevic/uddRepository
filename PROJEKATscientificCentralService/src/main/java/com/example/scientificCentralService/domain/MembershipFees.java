package com.example.scientificCentralService.domain;




import java.util.List;

import javax.persistence.*;

@Entity
public class MembershipFees {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	//@ManyToMany(mappedBy="membership")
	//private List<Magazine> magazine;

	public MembershipFees() {
		super();
		// TODO Auto-generated constructor stub
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

	/*public List<Magazine> getMagazine() {
		return magazine;
	}

	public void setMagazine(List<Magazine> magazine) {
		this.magazine = magazine;
	}*/
	
	
}
