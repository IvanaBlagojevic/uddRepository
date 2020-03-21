package com.example.scientificCentralService.service;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ContentService {
	
	private String files = "D:\\MASTER\\UDD\\PROJEKATscientificCentralService\\files\\";
	
	public String getContent(String url, String type) throws IOException {
		ClassLoader classLoader = getClass().getClassLoader();
		PDFTextStripper pdfStripper = null;
        PDDocument pdDoc = null;
        COSDocument cosDoc = null;
        //String test  = files+heading+".pdf";
        System.out.println("TEST " + url);
        Path path = Paths.get(url).normalize();
        
        String parsedContent = "";
		try {
			Resource resource = new UrlResource(path.toUri());
			File file = resource.getFile();
			RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
            PDFParser parser = new PDFParser(randomAccessFile);
            parser.parse();
            cosDoc = parser.getDocument();
            pdfStripper = new PDFTextStripper();
            pdDoc = new PDDocument(cosDoc);
            pdfStripper.setStartPage(1);
            if (type.equals("article")) {
            	pdfStripper.setEndPage(5);
            }else {
            	pdfStripper.setEndPage(pdDoc.getNumberOfPages());
            }  
            parsedContent = pdfStripper.getText(pdDoc);
            pdDoc.close();
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return parsedContent;
	}
	
	public String saveFile(MultipartFile file) throws IOException {
		byte[] bytes = file.getBytes();
		Path path = Paths.get(files + file.getOriginalFilename());
		System.out.println(path.toAbsolutePath());
		Files.write(path, bytes);
		return path.toAbsolutePath().toString();
	}
	
	public Resource loadFile(String fileName) {
        try {
        	Path path = Paths.get(files + fileName).normalize();
     		System.out.println(path.toAbsolutePath());
     		
     		System.out.println("putanja loadFile" + path);
     		Resource resource = new UrlResource(path.toUri());
        	
        		path = Paths.get(files + fileName+".pdf").normalize();
        	

            Resource resource2 = new UrlResource(path.toUri());
            
            System.out.println("putanja2 loadFile" + path);
            if(resource.exists()) {
            	System.out.println(" RESOURCE " + resource);
                return resource;
            }
            
            if(resource2.exists()) {
            	System.out.println(" RESOURCE2 " + resource2);
                return resource2;
            }
            
        } catch (MalformedURLException ex) {
           
        	System.out.println("File does not exists!");
        	
        }
        
        return null;
    }

}
