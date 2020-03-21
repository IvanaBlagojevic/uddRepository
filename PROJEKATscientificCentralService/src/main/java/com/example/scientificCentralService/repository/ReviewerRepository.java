package com.example.scientificCentralService.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.scientificCentralService.domain.Reviewer;



@Repository
public interface ReviewerRepository extends JpaRepository<Reviewer, Long> {

	Reviewer findOneByEmail(String s);

}
