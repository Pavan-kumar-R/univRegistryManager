package com.university.registryManager.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="professor", schema="univ_admin")
public class ProfessorEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5171793209754940745L;

	@Id
	@Column(name="id", nullable = false)
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="department_id")
	private int department_id;
	
	public ProfessorEntity(int id, String name, int department_id) {
		this.id = id;
		this.name = name;
		this.department_id = department_id;
	}
	
	public ProfessorEntity(){
		
	}

	@Override
	public String toString() {
		return "ProfessorEntity [id=" + id + ", name=" + name + ", department_id=" + department_id + "]";
	}

}
