package com.university.registryManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.university.registryManager.entities.DepartmentEntity;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Integer> {

}
