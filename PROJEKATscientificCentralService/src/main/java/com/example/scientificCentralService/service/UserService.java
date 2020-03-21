package com.example.scientificCentralService.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.scientificCentralService.domain.UserModel;
import com.example.scientificCentralService.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository ur;

	public void save(UserModel um) {
		// TODO Auto-generated method stub
		ur.save(um);
	}

	public UserModel findOneByEmail(String fieldValue) {
		// TODO Auto-generated method stub
		return ur.findOneByEmail(fieldValue);
	}

	public List<UserModel> findAllByIs_Reviewer(boolean b) {
		// TODO Auto-generated method stub
		return ur.findAllByIsReviewer(b);
	}
	
	public Optional<UserModel> getByEmail(String email){
		
		return ur.findUserByEmail(email);
	}

	public UserModel findOneByUsername(String c) {
		// TODO Auto-generated method stub
		return ur.findOneByUsername(c);
	}

	public List<UserModel> findEditors(String string) {
		// TODO Auto-generated method stub
		return ur.findEditors();
	}

	public List<UserModel> findReviewer() {
		// TODO Auto-generated method stub
		return ur.findReviewer();
	}

	public UserModel getOne(Long idDTO) {
		// TODO Auto-generated method stub
		return ur.getOne(idDTO);
	}

	/*public List<UserModel> findAllByDiscriminator(String string) {
		// TODO Auto-generated method stub
		return ur.findAllByDiscriminator(string);
	}*/

}
