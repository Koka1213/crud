package com.studentmanagement.model;

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
@Table( name = "assignments")
public class Assignments {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String description;
	private String dueDate;
	private int totalPoint;
	private String instruction;
	private String dateAssigned;
	private String title;

	
	
	@ManyToOne
	@JoinColumn(name = "teacherCourses_id")
	private TeacherCourses teacherCourses;
	
	
	@OneToMany(mappedBy = "assignments" , cascade =CascadeType.ALL)
	private List<TeacherCourseStudentAssignments> teacherCourseStudentAssignments;

	public Assignments() {
		super();
	}


	public Assignments(String description, String dueDate, int totalPoint, String instruction, String dateAssigned,
			TeacherCourses teacherCourses, List<TeacherCourseStudentAssignments> teacherCourseStudentAssignments,String title) {
		super();
		this.description = description;
		this.dueDate = dueDate;
		this.totalPoint = totalPoint;
		this.instruction = instruction;
		this.dateAssigned = dateAssigned;
		this.teacherCourses = teacherCourses;
		this.teacherCourseStudentAssignments = teacherCourseStudentAssignments;
		this.title=title;

	}
	
	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getDueDate() {
		return dueDate;
	}


	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}


	public int getTotalPoint() {
		return totalPoint;
	}


	public void setTotalPoint(int totalPoint) {
		this.totalPoint = totalPoint;
	}


	public String getInstruction() {
		return instruction;
	}


	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}


	public String getDateAssigned() {
		return dateAssigned;
	}


	public void setDateAssigned(String dateAssigned) {
		this.dateAssigned = dateAssigned;
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
