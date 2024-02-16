package com.studentmanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.studentmanagement.dto.AssignmentsDto;
import com.studentmanagement.model.Assignments;
import com.studentmanagement.model.TeacherCourses;

@Service
public interface AssignmentsService {
	void create(AssignmentsDto dto);
   List<Assignments> getAllByTeacherCourses(TeacherCourses tc);

	long countAssignment();
}
