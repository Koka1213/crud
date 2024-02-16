package com.studentmanagement.dto;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class TeacherCoursesDto {

	private int id;
	
	@NotEmpty(message = "Start Date is required")
	private String startDate;
	
	@NotEmpty(message = "End Date is required")
	private String endDate;
	
	@NotEmpty(message = "TeacherCourses is required")
	private String name;
	
	@NotNull(message = "Teacher  is required")
	private int teacherId;
	
	@NotNull(message = "Course is required")
	private int courseId;
	
	
	public TeacherCoursesDto() {
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
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

}
