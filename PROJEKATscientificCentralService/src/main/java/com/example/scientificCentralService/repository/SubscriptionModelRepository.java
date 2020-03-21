package com.example.scientificCentralService.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.scientificCentralService.domain.SubscriptionModel;



@Repository
public interface SubscriptionModelRepository extends JpaRepository<SubscriptionModel, Long>{

}
