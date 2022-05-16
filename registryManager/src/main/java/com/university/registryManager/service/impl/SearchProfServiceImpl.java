package com.university.registryManager.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.university.registryManager.entities.SearchProfEntity;
import com.university.registryManager.repository.SearchProfRepository;
import com.university.registryManager.service.SearchProfService;

@Service
public class SearchProfServiceImpl implements SearchProfService {

	private static final Logger logger = LogManager.getLogger(SearchProfServiceImpl.class);
	
	@Autowired
	SearchProfRepository searchProfRepo;
	
	@Override
	public List<Map<String, Object>> getProfDetails() {
		
		logger.info("Inside getProfDetails -- ");
		List<SearchProfEntity> profCourEntityList = searchProfRepo.findAll();
		List<Map<String, Object>> profCourseList = new ArrayList<>();
		
		Function<String, List<String>> createListFun = str -> {
			List<String> newList = new ArrayList<String>();
			newList.add(str);
			return newList;
		};
		
		for (SearchProfEntity searchProfEntity : profCourEntityList) {
			
			if(profCourseList.isEmpty()){
				Map<String, Object> newMap = new HashMap<>();
				newMap.put("name", searchProfEntity.getProfName());
				newMap.put("courses", createListFun.apply(searchProfEntity.getCourseName()));
				profCourseList.add(newMap);
			}else{
				
				Iterator<Map<String, Object>> mapsItr = profCourseList.iterator();
				while(mapsItr.hasNext()){
					Map<String, Object> map = mapsItr.next();
					if(searchProfEntity.getProfName().equalsIgnoreCase((String)map.get("name"))){
						List<String> courseList = (List<String>)map.get("courses");
						courseList.add(searchProfEntity.getCourseName());
						map.put("courses", courseList);
						break;
					}else{
						Map<String, Object> newMap = new HashMap<>();
						newMap.put("name", searchProfEntity.getProfName());
						newMap.put("courses", createListFun.apply(searchProfEntity.getCourseName()));
						profCourseList.add(newMap);
						break;
					}
				}
				
				/*for (Map<String, Object> map : profCourseList) {
					if(map.containsKey(searchProfEntity.getProfName())){
						List<String> courseList = (List<String>)map.get("courses");
						courseList.add(searchProfEntity.getCourseName());
						map.put("courses", courseList);
						break;
					}else{
						Map<String, Object> newMap = new HashMap<>();
						newMap.put("name", searchProfEntity.getProfName());
						newMap.put("courses", createListFun.apply(searchProfEntity.getCourseName()));
						profCourseList.add(newMap);
					}
				}*/
			}
			
			
		}
		
		logger.info("profCourEntityList -- " + profCourEntityList);
		logger.info("profCourseList -- " + profCourseList);
		
		return profCourseList;
	}

	
}
