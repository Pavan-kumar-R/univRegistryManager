package com.university.registryManager.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

public interface SearchProfController {

	public ResponseEntity<List<Map<String, Object>>> searchProfessorDetails();
	
}
