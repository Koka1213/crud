package com.studentmanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.studentmanagement.dto.TeacherCoursesDto;
import com.studentmanagement.model.TeacherCourses;
import com.studentmanagement.model.Teachers;

@Service
public interface TeacherCoursesService {
	TeacherCourses save(TeacherCoursesDto tcDto);
	List <TeacherCourses> getAll();
	TeacherCourses getById(int id);
	List<TeacherCourses> getByTeachers(Teachers t);
	long countTeacherCourse();
}
