package com.studentmanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.studentmanagement.dto.CoursesDto;
import com.studentmanagement.model.Courses;

@Service
public interface CoursesService {
	List<Courses> getAll(); 
	Courses getById(int id);
	void create(CoursesDto courseDto);
	void edit(int id,CoursesDto courseDto);
	void deleteByID(int id);

	long countCourses();

}
