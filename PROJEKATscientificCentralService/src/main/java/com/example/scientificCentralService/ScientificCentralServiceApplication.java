package com.example.scientificCentralService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//@EntityScan("com.example.scientificCentralService.domain")
//@Configuration
//@EnableWebMvc
@SpringBootApplication
public class ScientificCentralServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScientificCentralServiceApplication.class, args);
	}

}
