package com.example.scientificCentralService.controller;


import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.scientificCentralService.domain.Article;
import com.example.scientificCentralService.domain.Coauthor;
import com.example.scientificCentralService.dto.ArticleDTO;
import com.example.scientificCentralService.elastic.ArticleIndexUnit;
import com.example.scientificCentralService.repository.ArticleIndexRepository;
import com.example.scientificCentralService.service.ArticleService;
import com.example.scientificCentralService.service.CoauthorServices;
import com.example.scientificCentralService.service.ContentService;



@RestController
@RequestMapping("/elasticarticle")
@CrossOrigin(origins = "http://localhost:4200")
public class ArticleElasticController {
	
	@Autowired
	ArticleService as;
	
	@Autowired
	CoauthorServices cs;

	@Autowired
	ContentService contentService;
	
	@Autowired
	ArticleIndexRepository air;
	
	private String files = "D:\\MASTER\\UDD\\PROJEKATscientificCentralService\\files\\";
	
	@GetMapping(value = "/indexAll", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> indexArticles() throws IOException {
		List<Article> articles = as.findAll();
		for (Article a : articles) {
			String content = contentService.getContent(a.getUrl(), "article");
	      
			List<Coauthor> coauthors = cs.findAllByArticle(a);
			String names = "";
			for (Coauthor c : coauthors ) {
				names += c.getName() + " " +c.getSurname()+" ";
			}
			
			ArticleIndexUnit aiu = new ArticleIndexUnit(a.getId(), a.getHeading(), a.getKeyTerms(), a.getAbs(), a.getMain().getName(), a.getMagazine().getName(),
					content, a.getAuthor().getName() + " " + a.getAuthor().getSurname(), names, a.getMagazine().isOpenAccess(), a.isApproved());
			
			air.save(aiu);
			
		}
		return new ResponseEntity(null, HttpStatus.OK);
	}
	
	@GetMapping(value = "/download/{id}")
	public ResponseEntity<Resource> downloadFile(@PathVariable("id")String name, HttpServletRequest request) throws IOException {
		System.out.println("name "+name);
		Resource resource = contentService.loadFile(name);
        
        String contentType = null;
		try {
			contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath() + ".pdf");
		} catch (IOException ex) {
			System.out.println("Could not determine file type.");
		}

		if(contentType == null) {
			contentType = "application/octet-stream";
		}

		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(contentType))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .header(HttpHeaders.LOCATION, resource.getURI().toString())
				.body(resource);
	}
	
	@GetMapping(value = "/getOne/{id}")
	public ResponseEntity<ArticleDTO> getArticleById(@PathVariable("id")String id){
		System.out.println("id "+id);
		Long longId = Long.parseLong(id);
        
        Article a =  as.findOneById(longId);
		ArticleDTO back = new ArticleDTO(a);

		

		return new ResponseEntity(back, HttpStatus.OK); 
	}
	
	
	
	@RequestMapping(value = "/uploadPDF/", method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<?> uploadFile(@RequestParam("File") MultipartFile request) {
		System.out.print("pogodio pdf");
		String returnValue ="";
		try {
			returnValue = contentService.saveFile(request);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ResponseEntity<>(returnValue, HttpStatus.OK);

	}

}
