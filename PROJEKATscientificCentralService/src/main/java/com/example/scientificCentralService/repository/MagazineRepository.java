package com.example.scientificCentralService.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.scientificCentralService.domain.Magazine;


@Repository
public interface MagazineRepository extends JpaRepository<Magazine, Long> {

	Magazine findTopByOrderByIdDesc();

	Magazine findOneByIssn(String fieldValue);

}
