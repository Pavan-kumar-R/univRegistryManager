package com.university.registryManager.service.impl;

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
import com.university.registryManager.service.ReadDataService;

@Service
public class ReadDataServiceImpl implements ReadDataService {

	private static final Logger logger = LogManager.getLogger(ReadDataServiceImpl.class);
	
	@Autowired
	RepoGenFactory repoGenFactory;
	
	@Override
	public void readTablesData(List<String> tableNamesTobeRead) {

		logger.info("Inside readTablesData -- " + tableNamesTobeRead);
		
		for (String tableName : tableNamesTobeRead) {
			if(CRDDataConstants.PROFESSOR.equalsIgnoreCase(tableName)){
				ProfessorRepository profRepo = (ProfessorRepository)repoGenFactory.getEntityRepo(tableName);
				if(profRepo.count() > 0){
					List<ProfessorEntity> profResultList = profRepo.findAll();
					logger.info(" Professor Table data " + profResultList);
				}else{
					logger.info(" ** No Data found in Professor Table ** ");
				}
			}else if(CRDDataConstants.DEPARTMENT.equalsIgnoreCase(tableName)){
				DepartmentRepository depRepo = (DepartmentRepository)repoGenFactory.getEntityRepo(tableName);
				if(depRepo.count() > 0){
					List<DepartmentEntity> depResultList = depRepo.findAll();
					logger.info(" Department Table data " + depResultList);
				}else{
					logger.info(" ** No Data found in Professor Table **  ");
				}
			}else if(CRDDataConstants.COURSE.equalsIgnoreCase(tableName)){
				CourseRepository courseRepo = (CourseRepository)repoGenFactory.getEntityRepo(tableName);
				if(courseRepo.count() > 0){
					List<CourseEntity> courseResultList = courseRepo.findAll();
					logger.info(" Course Table data " + courseResultList);
				}else{
					logger.info(" ** No Data found in Professor Table **  ");
				}
			}else if(CRDDataConstants.SCHEDULE.equalsIgnoreCase(tableName)){
				ScheduleRepository schedRepo = (ScheduleRepository)repoGenFactory.getEntityRepo(tableName);
				if(schedRepo.count() > 0){
					List<ScheduleEntity> schedResultList = schedRepo.findAll();
					logger.info(" Schedule Table data " + schedResultList);
				}else{
					logger.info(" ** No Data found in Professor Table **  ");
				}
			}
		}
		
	}

}
