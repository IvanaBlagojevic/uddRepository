package com.example.scientificCentralService.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.example.scientificCentralService.elastic.ReviewerIndexUnit;

public interface ReviewerIndexRepository extends ElasticsearchRepository<ReviewerIndexUnit, Long> {

}
