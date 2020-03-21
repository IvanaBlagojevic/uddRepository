package com.example.scientificCentralService.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.scientificCentralService.domain.ScientificField;



@Repository
public interface ScientificFieldRepository extends JpaRepository<ScientificField, Long>{

	ScientificField findOneByNumber(String s);

}
