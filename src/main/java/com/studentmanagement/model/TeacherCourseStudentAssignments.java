package com.studentmanagement.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table( name = "teacherCourseStudentAssignments")
public class TeacherCourseStudentAssignments {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private Date submittedDate;
	private int grade;
	private String feedback;
	private int status;
	private String assignmentContent;
	
	@ManyToOne
	@JoinColumn(name = "assignments_id")
	private Assignments assignments;
	
	
	@ManyToOne
	@JoinColumn(name = "teacherCourseStudents_id")
	private TeacherCourseStudents teacherCourseStudents;


	public TeacherCourseStudentAssignments(int id, Date submittedDate, int grade, String feedback, int status,
			String assignmentContent, Assignments assignments, TeacherCourseStudents teacherCourseStudents) {
		super();
		this.id = id;
		this.submittedDate = submittedDate;
		this.grade = grade;
		this.feedback = feedback;
		this.status = status;
		this.assignmentContent = assignmentContent;
		this.assignments = assignments;
		this.teacherCourseStudents = teacherCourseStudents;
	}


	public TeacherCourseStudentAssignments(Date submittedDate, int grade, String feedback, int status,
			String assignmentContent, Assignments assignments, TeacherCourseStudents teacherCourseStudents) {
		super();
		this.submittedDate = submittedDate;
		this.grade = grade;
		this.feedback = feedback;
		this.status = status;
		this.assignmentContent = assignmentContent;
		this.assignments = assignments;
		this.teacherCourseStudents = teacherCourseStudents;
	}


	public TeacherCourseStudentAssignments() {
		super();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Date getSubmittedDate() {
		return submittedDate;
	}


	public void setSubmittedDate(Date submittedDate) {
		this.submittedDate = submittedDate;
	}


	public int getGrade() {
		return grade;
	}


	public void setGrade(int grade) {
		this.grade = grade;
	}


	public String getFeedback() {
		return feedback;
	}


	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public String getAssignmentContent() {
		return assignmentContent;
	}


	public void setAssignmentContent(String assignmentContent) {
		this.assignmentContent = assignmentContent;
	}


	public Assignments getAssignments() {
		return assignments;
	}


	public void setAssignments(Assignments assignments) {
		this.assignments = assignments;
	}


	public TeacherCourseStudents getTeacherCourseStudents() {
		return teacherCourseStudents;
	}


	public void setTeacherCourseStudents(TeacherCourseStudents teacherCourseStudents) {
		this.teacherCourseStudents = teacherCourseStudents;
	}
	
	

}
