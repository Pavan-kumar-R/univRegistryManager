package com.university.registryManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.university.registryManager.entities.ScheduleEntity;

public interface ScheduleRepository extends JpaRepository<ScheduleEntity, Integer> {

}
