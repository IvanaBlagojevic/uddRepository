package com.example.scientificCentralService.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.scientificCentralService.domain.Article;


@Repository
public interface ArticleRepository extends JpaRepository<Article, Long>{

	Article findOneById(Long parseLong);

}
