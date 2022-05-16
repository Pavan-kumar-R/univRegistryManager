package com.university.registryManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.university.registryManager.entities.CourseEntity;

public interface CourseRepository extends JpaRepository<CourseEntity, Integer> {

}
