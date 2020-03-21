package com.example.scientificCentralService.domain;



import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.NaturalId;

import com.example.scientificCentralService.dto.UserDTO;



@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "discriminator", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue(value = "U")
public class UserModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String surname;
	
	@Column(nullable = false)
	private String city;
	
	@Column(nullable = false)
	private String state;
	
	@Column(nullable = true)
	private String title;	//za urednika i recezenta
	
	@NaturalId
	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String username;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	private String uniqueID;
	
	//potvrda mejla
	@Column()
	private boolean isActive;
	
	@Column()
	private boolean isAuthor;
	
	@Column()
	private boolean isReviewer;
	
	@ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.ALL})
	@JoinTable(name="user_fields",
	joinColumns = @JoinColumn(name="user_id", referencedColumnName="id"),
	inverseJoinColumns = @JoinColumn(name="scientific_field_id", referencedColumnName="id"))
	private Set<ScientificField> fields;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	@JoinTable(name="user_roles",
	joinColumns = @JoinColumn(name="user_id", referencedColumnName="id"),
	inverseJoinColumns = @JoinColumn(name="userRole_id", referencedColumnName="id"))
	private Set<UserRole> roles;
	
	@OneToMany( fetch = FetchType.LAZY) //autor
	private List<Article> author;
	
	@OneToMany(fetch = FetchType.LAZY) //recenzije
	private List<Review> reviews;
	
	
	//za geodistance
	@NotNull
	@Column(nullable = false)
	private Double latitude;

	@NotNull
	@Column(nullable = false)
	private Double longitude;
	
	/*//placeni casopisi
	@Column
	@ManyToMany
	private Set<Magazine> payedMagazines;*/
	
	//pretplate
	@Column
	@ManyToMany
	private Set<SubscriptionModel> subMagazines;

	public UserModel() {
		super();
		// TODO Auto-generated constructor stub
	}


	public UserModel(String name, String surname, String city, String state, String title, String email,
			String username, String password, String uniqueID, boolean isActive, boolean isAuthor, boolean isReviewer,
			Set<ScientificField> fields, Set<UserRole> role, List<Review> r, Double longitude, Double latitude) {
		super();
		this.name = name;
		this.surname = surname;
		this.city = city;
		this.state = state;
		this.title = title;
		this.email = email;
		this.username = username;
		this.password = password;
		this.uniqueID = uniqueID;
		this.isActive = isActive;
		this.isAuthor = isAuthor;
		this.isReviewer = isReviewer;
		this.fields = fields;
		this.roles = role;
		this.reviews = r;
		this.longitude = longitude;
		this.latitude = latitude;
	}




	public UserModel(UserDTO dto) {
		name = dto.getName();
		surname = dto.getSurname();
		city = dto.getCity();
		state = dto.getState();
		title = dto.getTitle();
		email = dto.getEmail();
		isAuthor = false;
		isReviewer = dto.isReviewer();
		username = dto.getUsername();
		password = dto.getPassword();
		isActive = false;
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

	public boolean isReviewer() {
		return isReviewer;
	}

	public void setReviewer(boolean isReviewer) {
		this.isReviewer = isReviewer;
	}

	public String getUniqueID() {
		return uniqueID;
	}

	public void setUniqueID(String uniqueID) {
		this.uniqueID = uniqueID;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Set<ScientificField> getFields() {
		return this.fields;
	}

	public void setFields(Set<ScientificField> fields) {
		this.fields = fields;
	}

	public Set<UserRole> getRoles() {
		return this.roles;
	}

	public void setRoles(Set<UserRole> roles) {
		this.roles = roles;
	}


	public List<Article> getAuthor() {
		return author;
	}


	public void setAuthor(List<Article> author) {
		this.author = author;
	}


	public Set<SubscriptionModel> getSubMagazines() {
		return subMagazines;
	}


	public void setSubMagazines(Set<SubscriptionModel> subMagazines) {
		this.subMagazines = subMagazines;
	}


	public List<Review> getReviews() {
		return reviews;
	}


	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}


	public Double getLatitude() {
		return latitude;
	}


	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}


	public Double getLongitude() {
		return longitude;
	}


	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	
	
	
}
