
package com.au.aums.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.au.aums.model.dto.ClientDTO;
import com.au.aums.model.dto.DescriptionDTO;
import com.au.aums.model.dto.LocationDTO;
import com.au.aums.model.dto.SkillDTO;
import com.au.aums.service.TrendService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TrendsController {

	@Autowired
	TrendService trendService;

	
	@GetMapping(path = "/api/restriction/skill")
	public ResponseEntity<List<SkillDTO>> skills() {
		return new ResponseEntity<>(trendService.skill(), HttpStatus.OK);
	} 
	
	@GetMapping(path = "/api/restriction/client")
	public ResponseEntity<List<ClientDTO>> client() {
		List<ClientDTO> x=trendService.client();
		return new ResponseEntity<>(x, HttpStatus.OK);
	} 
	
	@GetMapping(path = "/api/restriction/location")
	public ResponseEntity<List<LocationDTO>> location() {
		return new ResponseEntity<>(trendService.location(), HttpStatus.OK);
	}
	
	@GetMapping(path = "/api/restriction/description")
	public ResponseEntity<List<DescriptionDTO>> description() {
		return new ResponseEntity<>(trendService.description(), HttpStatus.OK);
	}

}
