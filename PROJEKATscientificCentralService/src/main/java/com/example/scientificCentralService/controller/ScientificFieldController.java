package com.example.scientificCentralService.controller;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.scientificCentralService.domain.ScientificField;
import com.example.scientificCentralService.dto.ScientificFieldDTO;
import com.example.scientificCentralService.service.ScientificFieldService;


@RestController
@RequestMapping("/scfield")
@CrossOrigin(origins = "http://localhost:4200")
public class ScientificFieldController {

	@Autowired
	ScientificFieldService scientificFieldService;
	
	@GetMapping(path = "/get", produces = "application/json")
    public @ResponseBody List<ScientificFieldDTO> get() {
		System.out.print("usao getField");
		List<ScientificFieldDTO> listDTO = new ArrayList<ScientificFieldDTO>();
		List<ScientificField> list = scientificFieldService.findAll();
		
		for(ScientificField fp : list) {
			ScientificFieldDTO dto = new ScientificFieldDTO(fp.getName(),fp.getNumber());
			listDTO.add(dto);
		}
		
        return listDTO;
    }

}
