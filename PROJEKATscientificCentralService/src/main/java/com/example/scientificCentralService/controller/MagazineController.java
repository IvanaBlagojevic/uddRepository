package com.example.scientificCentralService.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.scientificCentralService.domain.Magazine;
import com.example.scientificCentralService.dto.MagazineDTO;
import com.example.scientificCentralService.service.MagazineService;

@RestController
@RequestMapping("/magazine")
@CrossOrigin(origins = "http://localhost:4200")
public class MagazineController {
	
	@Autowired
	private MagazineService ms;
	
	@GetMapping(path = "/all", produces = "application/json")
    public @ResponseBody List<MagazineDTO> getAll() {
		List<Magazine> list = ms.findAll();
		List<MagazineDTO> listDTO = new ArrayList<MagazineDTO>();
		for (Magazine s : list) {
			listDTO.add(new MagazineDTO(s));
		}
		return listDTO;
    }
}
