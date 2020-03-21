package com.example.scientificCentralService.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.scientificCentralService.domain.MembershipFees;



@Repository
public interface MembershipFeesRepository extends JpaRepository<MembershipFees, Long> {

	MembershipFees findOneById(long parseLong);

}
