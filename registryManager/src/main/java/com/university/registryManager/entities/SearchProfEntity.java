package com.university.registryManager.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;
import org.hibernate.annotations.Synchronize;

/*@Entity
@NamedNativeQuery(
		name = "search_prof_cour_query",
		query = "select prof.name as prof_name, cour.name as course_name from univ_admin.professor prof, univ_admin.course cour, univ_admin.schedule sched "
				+ "where prof.id = sched.professor_id and cour.id = sched.course_id",
		resultSetMapping = "search_prof_cour_dto")
@SqlResultSetMapping(
		name="search_prof_cour_dto",
		classes = @ConstructorResult(
				targetClass = ProfCourseDTO.class,
				columns = {
						@ColumnResult(name="prof_name", type = String.class),
						@ColumnResult(name="course_name", type = String.class)
				}))*/


@Entity
@Subselect("select row_number() over() as id, prof.name as prof_name, cour.name as course_name from univ_admin.professor prof, univ_admin.course cour, univ_admin.schedule sched where prof.id = sched.professor_id and cour.id = sched.course_id ")
@Synchronize({"univ_admin.professor, univ_admin.course, univ_admin.schedule"})
@Immutable
public class SearchProfEntity {
	
	@Id
	private int id;
	private String profName;
	private String courseName;

	public String getProfName() {
		return profName;
	}

	public void setProfName(String profName) {
		this.profName = profName;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	public SearchProfEntity(int id, String profName, String courseName) {
		this.id = id;
		this.profName = profName;
		this.courseName = courseName;
	}
	
	public SearchProfEntity() {	}
	
	@Override
	public String toString() {
		return "ProfCourseDTO [profName=" + profName + ", courseName=" + courseName + "]";
	}
	
	
}
