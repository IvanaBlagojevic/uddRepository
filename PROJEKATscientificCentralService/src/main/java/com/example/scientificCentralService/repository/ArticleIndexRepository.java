package com.example.scientificCentralService.repository;


import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.elasticsearch.repository.support.ElasticsearchEntityInformation;
import org.springframework.data.elasticsearch.repository.support.ElasticsearchEntityInformationCreator;

import com.example.scientificCentralService.elastic.ArticleIndexUnit;


public interface ArticleIndexRepository extends ElasticsearchRepository<ArticleIndexUnit, Long> {



}
