package com.studentmanagement.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table( name = "courses")
public class Courses {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private String description;
	private int durationHour;
	private int enrollmentLimit;
	private String prerequisites;
	
	
	@OneToMany(mappedBy = "courses" , cascade =CascadeType.ALL)
	private List<TeacherCourses> teacherCourses;


	public Courses(int id,String name, String description, int durationHour, int enrollmentLimit, String prerequisites
			) {
		this.id=id;
		this.name = name;
		this.description = description;
		this.durationHour = durationHour;
		this.enrollmentLimit = enrollmentLimit;
		this.prerequisites = prerequisites;
		
	}


	public Courses() {
		super();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getDurationHour() {
		return durationHour;
	}


	public void setDurationHour(int durationHour) {
		this.durationHour = durationHour;
	}


	public int getEnrollmentLimit() {
		return enrollmentLimit;
	}


	public void setEnrollmentLimit(int enrollmentLimit) {
		this.enrollmentLimit = enrollmentLimit;
	}


	public String getPrerequisites() {
		return prerequisites;
	}


	public void setPrerequisites(String prerequisites) {
		this.prerequisites = prerequisites;
	}


	public List<TeacherCourses> getTeacherCourses() {
		return teacherCourses;
	}


	public void setTeacherCourses(List<TeacherCourses> teacherCourses) {
		this.teacherCourses = teacherCourses;
	}
	
	
	

}
