package com.university.registryManager.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="schedule", schema="univ_admin")
public class ScheduleEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", nullable=false)
	private int id;
	
	@Column(name="professor_id")
	private int professor_id;
	
	@Column(name="course_id")
	private int course_id;
	
	@Column(name="semester")
	private int semester;
	
	@Column(name="year")
	private int year;
	
	public ScheduleEntity(){};
	
	public ScheduleEntity(int professor_id, int course_id, int semester, int year){
		this.professor_id = professor_id;
		this.course_id = course_id;
		this.semester = semester;
		this.year = year;
	}

	@Override
	public String toString() {
		return "ScheduleEntity [id=" + id + ", professor_id=" + professor_id + ", course_id=" + course_id
				+ ", semester=" + semester + ", year=" + year + "]";
	}
	
}
