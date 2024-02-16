package com.studentmanagement.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

public class AssignmentsDto {

	
	   @NotBlank(message = "Description is required")
	    private String description;

	    @NotBlank(message = "Due date is required")
	    private String dueDate;

	    @NotNull(message = "Total point is required")
	    @Positive(message = "Total point must be a positive  value")
	     private int totalPoint;

	    @NotBlank(message = "Instruction is required")
	    private String instruction;

	    @NotBlank(message = "Date assigned is required")
	    private String dateAssigned;

	    private int teacherCoursesId;
	    
	    private String title;
	    
	    

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
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

		public int getTeacherCoursesId() {
			return teacherCoursesId;
		}

		public void setTeacherCoursesId(int teacherCoursesId) {
			this.teacherCoursesId = teacherCoursesId;
		}
	    
	    
	    
}
