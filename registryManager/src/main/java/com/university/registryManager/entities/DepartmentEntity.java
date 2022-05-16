package com.university.registryManager.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="department", schema="univ_admin")
public class DepartmentEntity {
	
	@Id
	@Column(name="id", nullable = false)
	private int id;
	
	@Column(name="name")
	private String name;
	
	public DepartmentEntity(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public DepartmentEntity(){
		
	}

	@Override
	public String toString() {
		return "DepartmentEntity [id=" + id + ", name=" + name + "]";
	}

	
	
}
