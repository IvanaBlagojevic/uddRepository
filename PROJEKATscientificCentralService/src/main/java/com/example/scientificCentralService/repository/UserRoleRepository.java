package com.example.scientificCentralService.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.scientificCentralService.domain.UserRole;
import com.example.scientificCentralService.domain.UserRoleName;



@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

	@Query(value="select s from UserRole s where s.name = ?1")
	UserRole findRoleByName(UserRoleName name);
}
