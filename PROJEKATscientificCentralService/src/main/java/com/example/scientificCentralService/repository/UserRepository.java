package com.example.scientificCentralService.repository;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.scientificCentralService.domain.UserModel;




@Repository
public interface UserRepository extends JpaRepository<UserModel, Long>{

	UserModel findOneByEmail(String fieldValue);

	List<UserModel> findAllByIsReviewer(boolean b);
	
	@Query(value="select s from UserModel s where s.email = ?1")
	Optional<UserModel> findUserByEmail(String email);

	UserModel findOneByUsername(String c);
	//@Query("from CausalLeave")
	//List<UserModel> findAllByDiscriminator(String string);

	@Query("from Editor")
	List<UserModel> findEditors();

	@Query("from Reviewer")
	List<UserModel> findReviewer();

}
