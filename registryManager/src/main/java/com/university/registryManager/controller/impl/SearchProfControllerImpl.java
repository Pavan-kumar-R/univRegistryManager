package com.university.registryManager.controller.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.university.registryManager.controller.SearchProfController;
import com.university.registryManager.service.SearchProfService;

@Controller
public class SearchProfControllerImpl implements SearchProfController {

	@Autowired
	SearchProfService service;
	
	@Override
	@GetMapping(value="/registryManager/search", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Map<String, Object>>> searchProfessorDetails() {

		List<Map<String, Object>> respList = service.getProfDetails();;
			
		return new ResponseEntity<>(respList, HttpStatus.OK);
		
	}
	
}
