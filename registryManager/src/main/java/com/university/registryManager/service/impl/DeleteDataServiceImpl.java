package com.university.registryManager.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.university.registryManager.constants.CRDDataConstants;
import com.university.registryManager.repository.CourseRepository;
import com.university.registryManager.repository.DepartmentRepository;
import com.university.registryManager.repository.ProfessorRepository;
import com.university.registryManager.repository.ScheduleRepository;
import com.university.registryManager.service.DeleteDataService;

@Service
public class DeleteDataServiceImpl implements DeleteDataService {

	private static final Logger logger = LogManager.getLogger(DeleteDataServiceImpl.class);
	
	@Autowired
	RepoGenFactory repoGenFactory;
	
	@Override
	public void deleteTablesData(List<String> tableNames) {

		logger.info("Inside deleteTablesData -- " + tableNames);
		
		for (String tableName : tableNames) {
			if(CRDDataConstants.PROFESSOR.equalsIgnoreCase(tableName)){
				ProfessorRepository profRepo = (ProfessorRepository)repoGenFactory.getEntityRepo(tableName);
				if(profRepo.count() > 0)
					profRepo.deleteAll();
			}else if(CRDDataConstants.DEPARTMENT.equalsIgnoreCase(tableName)){
				DepartmentRepository depRepo = (DepartmentRepository)repoGenFactory.getEntityRepo(tableName);
				if(depRepo.count() > 0)
					depRepo.deleteAll();
			}else if(CRDDataConstants.COURSE.equalsIgnoreCase(tableName)){
				CourseRepository courseRepo = (CourseRepository)repoGenFactory.getEntityRepo(tableName);
				if(courseRepo.count() > 0)
					courseRepo.deleteAll();
			}else if(CRDDataConstants.SCHEDULE.equalsIgnoreCase(tableName)){
				ScheduleRepository schedRepo = (ScheduleRepository)repoGenFactory.getEntityRepo(tableName);
				if(schedRepo.count() > 0)
					schedRepo.deleteAll();
			}
		}
		
	}
	
}
