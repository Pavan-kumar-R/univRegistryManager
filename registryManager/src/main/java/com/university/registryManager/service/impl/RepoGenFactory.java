package com.university.registryManager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.university.registryManager.constants.CRDDataConstants;
import com.university.registryManager.repository.CourseRepository;
import com.university.registryManager.repository.DepartmentRepository;
import com.university.registryManager.repository.ProfessorRepository;
import com.university.registryManager.repository.ScheduleRepository;

/*
 * This class is implemented based on Factory design pattern. It returns the necessary Entity's JpaRepository.
 */
@Component
public class RepoGenFactory {
	
	@Autowired
	ProfessorRepository profRepo;
	
	@Autowired
	DepartmentRepository depRepo;
	
	@Autowired
	CourseRepository courseRepo;
	
	@Autowired
	ScheduleRepository schedRepo;
	
	public Object getEntityRepo(String tableName){
		
		if(CRDDataConstants.PROFESSOR.equalsIgnoreCase(tableName)){
			return profRepo;
		}else if(CRDDataConstants.DEPARTMENT.equalsIgnoreCase(tableName)){
			return depRepo;
		}else if(CRDDataConstants.COURSE.equalsIgnoreCase(tableName)){
			return courseRepo;
		}else if(CRDDataConstants.SCHEDULE.equalsIgnoreCase(tableName)){
			return schedRepo;
		}else{
			return null;
		}
		
	}
	

}
