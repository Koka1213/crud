package com.studentmanagement.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

public class TeacherCourseStudentsDto {

	@NotEmpty(message = "Enroll date is required")
	private String enrollDate;

	@Positive(message = "Status must be positive")
	private int status;

	@Positive(message = "Student ID must be positive")
	private int studentsId;

	@Positive(message = "Teacher course ID must be positive")
	private int teacherCoursesId;

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

	public int getStudentsId() {
		return studentsId;
	}

	public void setStudentsId(int studentsId) {
		this.studentsId = studentsId;
	}

	public int getTeacherCoursesId() {
		return teacherCoursesId;
	}

	public void setTeacherCoursesId(int teacherCoursesId) {
		this.teacherCoursesId = teacherCoursesId;
	}
	

}
