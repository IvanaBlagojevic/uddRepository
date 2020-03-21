package com.example.scientificCentralService.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.scientificCentralService.domain.Article;
import com.example.scientificCentralService.domain.Coauthor;



@Repository
public interface CoauthorRepository extends JpaRepository<Coauthor, Long> {

	List<Coauthor> findAllByArticle(Article id);

}
