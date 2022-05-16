package com.university.registryManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.university.registryManager.entities.SearchProfEntity;

@Repository
public interface SearchProfRepository extends JpaRepository<SearchProfEntity, Integer> {
	
}
