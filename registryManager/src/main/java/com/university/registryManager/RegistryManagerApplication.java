package com.university.registryManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RegistryManagerApplication {

	private static final Logger LOGGER = LogManager.getLogger(RegistryManagerApplication.class);
	
	public static void main(String[] args) {
		
		SpringApplication.run(RegistryManagerApplication.class, args);
		
		LOGGER.info("Application started -- ");
		
	}

}
