package com.example.scientificCentralService.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.scientificCentralService.domain.Editor;


@Repository
public interface EditorRepository extends JpaRepository<Editor, Long>{

	Editor findOneByEmail(String s);

	Editor findOneByUsername(String whoCreateMagazine);

}
