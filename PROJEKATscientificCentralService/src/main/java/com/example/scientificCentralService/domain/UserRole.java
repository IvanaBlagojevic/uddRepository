package com.example.scientificCentralService.domain;





import java.util.List;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.NaturalId;

@Entity
public class UserRole {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
    @NaturalId
    @Column(length = 60, name="name")
	private UserRoleName name;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="role_permissions", 
				joinColumns = @JoinColumn(name="role_id", referencedColumnName = "id"),
				inverseJoinColumns = @JoinColumn(name = "permission_id", referencedColumnName = "id"))
	private Set<Permission> permissions;
	
	//@ManyToMany
//	private List<UserModel> users;

	public UserRole() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserRole(Long id, UserRoleName name, Set<Permission> permissions) {
		super();
		this.id = id;
		this.name = name;
		this.permissions = permissions;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserRoleName getName() {
		return name;
	}

	public void setName(UserRoleName name) {
		this.name = name;
	}

	public Set<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(Set<Permission> permissions) {
		this.permissions = permissions;
	}

	/*public List<UserModel> getUsers() {
		return this.users;
	}

	public void setUsers(List<UserModel> users) {
		this.users = users;
	}*/
	
	

}
