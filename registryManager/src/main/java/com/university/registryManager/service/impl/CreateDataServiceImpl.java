package com.university.registryManager.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.university.registryManager.constants.CRDDataConstants;
import com.university.registryManager.entities.CourseEntity;
import com.university.registryManager.entities.DepartmentEntity;
import com.university.registryManager.entities.ProfessorEntity;
import com.university.registryManager.entities.ScheduleEntity;
import com.university.registryManager.repository.CourseRepository;
import com.university.registryManager.repository.DepartmentRepository;
import com.university.registryManager.repository.ProfessorRepository;
import com.university.registryManager.repository.ScheduleRepository;
import com.university.registryManager.service.CreateDataService;

@Service
public class CreateDataServiceImpl implements CreateDataService {

//	@Autowired
//	ProfessorRepository profRepo;
//	
//	@Autowired
//	DepartmentRepository depRepo;
//	
//	@Autowired
//	CourseRepository courseRepo;
//	
//	@Autowired
//	ScheduleRepository schedRepo;
	
	@Autowired
	RepoGenFactory repoGeneratorFactory;
	
	private static final Logger logger = LogManager.getLogger(CreateDataServiceImpl.class);
	
	@Override
	public void populateExampleData(List<String> tableNames){
		
		logger.info("Inside populateExampleData -- " + tableNames);
		
		for (String tableName : tableNames) {
			if(CRDDataConstants.PROFESSOR.equalsIgnoreCase(tableName)){
				populateProfData(repoGeneratorFactory.getEntityRepo(tableName));
			}else if(CRDDataConstants.DEPARTMENT.equalsIgnoreCase(tableName)){
				populateDepData(repoGeneratorFactory.getEntityRepo(tableName));
			}else if(CRDDataConstants.COURSE.equalsIgnoreCase(tableName)){
				populateCourseData(repoGeneratorFactory.getEntityRepo(tableName));
			}else if(CRDDataConstants.SCHEDULE.equalsIgnoreCase(tableName)){
				populateSchedData(repoGeneratorFactory.getEntityRepo(tableName));
			}
		}
		
	}
	
	private void populateProfData(Object obj){
		
		logger.info("Inside populateProfData -- " );
		ProfessorRepository profRepo = (ProfessorRepository)obj;
		
		List<ProfessorEntity> profList = new ArrayList<>();
		profList.add(new ProfessorEntity(1, "John Doe", 5));
		profList.add(new ProfessorEntity(8, "Camden Lin", 1));
		profList.add(new ProfessorEntity(9, "Daniel Hicks", 5));
		profList.add(new ProfessorEntity(2, "Frida Mcintosh", 2));
		profList.add(new ProfessorEntity(10, "Timothy Hickman", 4));
		profList.add(new ProfessorEntity(3, "Grace Avery", 1));
		profList.add(new ProfessorEntity(4, "Ada Osborne", 3));
		profList.add(new ProfessorEntity(7, "Sarahi Barry", 2));
		profList.add(new ProfessorEntity(5, "Rowan Graves", 1));
		profList.add(new ProfessorEntity(6, "Selena Owen", 5));
		
		profRepo.saveAll(profList);
	}
	
	private void populateDepData(Object obj){
		
		logger.info("Inside populateDepData -- " );
		DepartmentRepository depRepo = (DepartmentRepository)obj;
		
		List<DepartmentEntity> depList = new ArrayList<>();
		depList.add(new DepartmentEntity(3, "Biological Sciences"));
		depList.add(new DepartmentEntity(5, "Technology"));
		depList.add(new DepartmentEntity(6, "Humanities & Social Sciences"));
		depList.add(new DepartmentEntity(2, "Clinical Medicine"));
		depList.add(new DepartmentEntity(4, "Arts and Humanities"));
		depList.add(new DepartmentEntity(1, "Physical Sciences"));
		
		depRepo.saveAll(depList);
	}
	
	private void populateCourseData(Object obj){
		
		logger.info("Inside populateCourseData -- " );
		CourseRepository courseRepo = (CourseRepository)obj;
		
		List<CourseEntity> courseList = new ArrayList<>();
		courseList.add(new CourseEntity(9, "Clinical Biochemistry", 2, 3));
		courseList.add(new CourseEntity(4, "Astronomy", 1, 6));
		courseList.add(new CourseEntity(10, "Clinical Neuroscience", 2, 5));
		courseList.add(new CourseEntity(1, "Pure Mathematics and Mathematical Statistics", 1, 3));
		courseList.add(new CourseEntity(6, "Geography", 1, 7));
		courseList.add(new CourseEntity(8, "Chemistry", 1, 1));
		courseList.add(new CourseEntity(5, "Physics", 1, 8));
		courseList.add(new CourseEntity(3, "Earth Science", 1, 7));
		courseList.add(new CourseEntity(7, "Materials Science and Metallurgy", 1, 5));
		courseList.add(new CourseEntity(2, "Applied Mathematics and Theoretical Physics", 1, 5));
		
		courseRepo.saveAll(courseList);
	}

	private void populateSchedData(Object obj){
		
		logger.info("Inside populateSchedData -- " );
		ScheduleRepository schedRepo = (ScheduleRepository)obj;
		
		if(!(schedRepo.count() > 0)){
			List<ScheduleEntity> schedList = new ArrayList<>();
			schedList.add(new ScheduleEntity(5, 3, 6, 2012));
			schedList.add(new ScheduleEntity(7, 3, 1, 2013));
			schedList.add(new ScheduleEntity(5, 7, 6, 2010));
			schedList.add(new ScheduleEntity(2, 10, 2, 2004));
			schedList.add(new ScheduleEntity(5, 1, 1, 2011));
			schedList.add(new ScheduleEntity(2, 9, 4, 2005));
			schedList.add(new ScheduleEntity(7, 10, 6, 2009));
			schedList.add(new ScheduleEntity(5, 6, 4, 2007));
			schedList.add(new ScheduleEntity(7, 9, 1, 2014));
			schedList.add(new ScheduleEntity(9, 9, 5, 2011));
		
			schedRepo.saveAll(schedList);
		}
		
	}
}
