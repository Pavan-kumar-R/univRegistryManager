package com.university.registryManager.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="course", schema="univ_admin")
public class CourseEntity {

	public CourseEntity(){}
	
	public CourseEntity(int id, String name, int department_id, int credits){
		this.id=id;
		this.name=name;
		this.department_id=department_id;
		this.credits=credits;
	}
	
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="department_id")
	private int department_id;
	
	@Column(name="credits")
	private int credits;

	@Override
	public String toString() {
		return "CourseEntity [id=" + id + ", name=" + name + ", department_id=" + department_id + ", credits=" + credits
				+ "]";
	}
	
}
