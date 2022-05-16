package com.university.registryManager.controller;

import java.util.List;

/*
 * This interface declares functions for all the REST End points used to CREATE/READ/DELETE Example Data
 */
public interface CRDDataController {
	
	void createExampleData(List<String> tableNames);
	
	void readData(List<String> tableNames);
	
	void deleteData(List<String> tableNames);
	
}
