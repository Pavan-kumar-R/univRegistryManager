package com.university.registryManager.util;

import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

public class CRDUtil {

	
	public boolean checkIfNullOrEmpty(List<String> inputList){
		
		Predicate<Collection> p = coll -> coll.isEmpty() || null == coll;
		return p.test(inputList);
		
	}
	
}
