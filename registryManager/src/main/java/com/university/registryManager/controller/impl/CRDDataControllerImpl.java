package com.university.registryManager.controller.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.university.registryManager.controller.CRDDataController;
import com.university.registryManager.service.CreateDataService;
import com.university.registryManager.service.DeleteDataService;
import com.university.registryManager.service.ReadDataService;
import com.university.registryManager.util.CRDUtil;

@Controller
public class CRDDataControllerImpl implements CRDDataController {
	
	private static final Logger logger = LogManager.getLogger(CRDDataControllerImpl.class);
	
	@Autowired
	CreateDataService createDataService;
	
	@Autowired
	DeleteDataService deleteDataService;
	
	@Autowired
	ReadDataService readDataService;
	
	CRDUtil util = new CRDUtil();

	/*
	 * (non-Javadoc)
	 * @see com.university.registryManager.controller.CRDDataController#createExampleData(java.util.List)
	 * This Controller function works as an entry point for populating table's data
	 */
	@Override
	@PostMapping(value="/manageRegistry/populateData", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void createExampleData(@RequestBody List<String> tableNames) {
		
		logger.info("Inside createExampleData logger -- to populate following tables data "  + tableNames);
		
		if(!util.checkIfNullOrEmpty(tableNames)){				//Used Lambda function and Predicate features of Java8
			createDataService.populateExampleData(tableNames);
		}else{
			logger.error("Please provide the Table names for which the data needs to be populated.");
		}
		
	}

	/*
	 * (non-Javadoc)
	 * @see com.university.registryManager.controller.CRDDataController#readData(java.util.List)
	 * This Controller function works as an entry point for reading table's data
	 */
	@Override
	@PostMapping(value="/manageRegistry/readData", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void readData(@RequestBody List<String> tableNames) {
		
		logger.info("Inside readData -- tableNames data to be retrieved -> " + tableNames);
		
		if(!util.checkIfNullOrEmpty(tableNames)){
			readDataService.readTablesData(tableNames);
		}else{
			logger.error("Please provide the Table names for which the data needs to be read.");
		}
		
	}

	/*
	 * (non-Javadoc)
	 * @see com.university.registryManager.controller.CRDDataController#deleteData(java.util.List)
	 * This Controller function works as an entry point for deleting table's data
	 */
	@Override
	@DeleteMapping(value="/manageRegistry/deleteData", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void deleteData(@RequestBody List<String> tableNames) {

		logger.info("Inside deleteData -- tableNames data to be deleted -> " + tableNames);
		
		if(!util.checkIfNullOrEmpty(tableNames)){
			deleteDataService.deleteTablesData(tableNames);
		}else{
			logger.error("Please provide the Table names for which the data needs to be deleted.");
		}
	}
	
}
