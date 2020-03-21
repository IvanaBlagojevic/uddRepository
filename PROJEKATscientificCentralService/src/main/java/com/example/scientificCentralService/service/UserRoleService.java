package com.example.scientificCentralService.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.scientificCentralService.domain.UserRole;
import com.example.scientificCentralService.domain.UserRoleName;
import com.example.scientificCentralService.repository.UserRoleRepository;

@Service
public class UserRoleService {

	@Autowired
	private UserRoleRepository roleRep;
	
	public UserRole findRoleByName(UserRoleName name){
		
		return roleRep.findRoleByName(name);
	}

	public void save(UserRole role) {
		// TODO Auto-generated method stub
		roleRep.save(role);
	}
}
