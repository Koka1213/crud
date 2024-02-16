package com.studentmanagement.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table( name = "teacherCourseStudents")
public class TeacherCourseStudents {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String enrollDate;
	
	private int status;
	
	
	@ManyToOne
	@JoinColumn(name = "students_id")
	private Students students;
	
	@ManyToOne
	@JoinColumn(name = "teacherCourses_id")
	private TeacherCourses teacherCourses;
	
	
	@OneToMany(mappedBy = "teacherCourseStudents" , cascade =CascadeType.ALL)
	private List<TeacherCourseStudentAssignments> teacherCourseStudentAssignments;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getEnrollDate() {
		return enrollDate;
	}


	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public Students getStudents() {
		return students;
	}


	public void setStudents(Students students) {
		this.students = students;
	}


	public TeacherCourses getTeacherCourses() {
		return teacherCourses;
	}


	public void setTeacherCourses(TeacherCourses teacherCourses) {
		this.teacherCourses = teacherCourses;
	}


	public List<TeacherCourseStudentAssignments> getTeacherCourseStudentAssignments() {
		return teacherCourseStudentAssignments;
	}


	public void setTeacherCourseStudentAssignments(List<TeacherCourseStudentAssignments> teacherCourseStudentAssignments) {
		this.teacherCourseStudentAssignments = teacherCourseStudentAssignments;
	}

	
	
}
