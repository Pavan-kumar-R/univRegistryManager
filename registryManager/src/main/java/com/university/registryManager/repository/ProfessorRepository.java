package com.university.registryManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.university.registryManager.entities.ProfessorEntity;

public interface ProfessorRepository extends JpaRepository<ProfessorEntity, Integer> {

}
