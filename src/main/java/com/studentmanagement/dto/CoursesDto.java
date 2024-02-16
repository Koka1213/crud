package com.studentmanagement.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;


public class CoursesDto {

	@NotEmpty(message = "Name is required")
	private String name;
	
	@NotEmpty(message = "Description is required")
	private String description;
	
	@Positive(message = "Duration hours must be a positive number")  
	private int durationHour;
	
	@Positive(message = "Enrollment limit must be a positive number")	
	private int enrollmentLimit;
	
	@NotEmpty(message = "Prerequisites is required")
	private String prerequisites;
	
	
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
}
