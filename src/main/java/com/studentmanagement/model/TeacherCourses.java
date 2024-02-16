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
@Table(name ="teacherCourses")
public class TeacherCourses {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String startDate;
	private String endDate;
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "teachers_id")
	private Teachers teachers;
	
	@ManyToOne
	@JoinColumn(name = "courses_id")
	private Courses courses;
	
	
	@OneToMany(mappedBy = "teacherCourses" , cascade =CascadeType.ALL)
	private List<TeacherCourseStudents> teacherCourseStudents;
	
	@OneToMany(mappedBy = "teacherCourses" , cascade =CascadeType.ALL)
	private List<Assignments> assignments;

	
	
	
	public TeacherCourses() {
		super();
	}

	public TeacherCourses(String startDate, String endDate, String name, Teachers teachers, Courses courses,
			List<TeacherCourseStudents> teacherCourseStudents, List<Assignments> assignments) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.name = name;
		this.teachers = teachers;
		this.courses = courses;
		this.teacherCourseStudents = teacherCourseStudents;
		this.assignments = assignments;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Teachers getTeachers() {
		return teachers;
	}

	public void setTeachers(Teachers teachers) {
		this.teachers = teachers;
	}

	public Courses getCourses() {
		return courses;
	}

	public void setCourses(Courses courses) {
		this.courses = courses;
	}

	public List<TeacherCourseStudents> getTeacherCourseStudents() {
		return teacherCourseStudents;
	}

	public void setTeacherCourseStudents(List<TeacherCourseStudents> teacherCourseStudents) {
		this.teacherCourseStudents = teacherCourseStudents;
	}

	public List<Assignments> getAssignments() {
		return assignments;
	}

	public void setAssignments(List<Assignments> assignments) {
		this.assignments = assignments;
	}

	

}
