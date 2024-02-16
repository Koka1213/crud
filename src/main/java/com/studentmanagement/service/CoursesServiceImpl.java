package com.studentmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentmanagement.dto.CoursesDto;
import com.studentmanagement.model.Courses;
import com.studentmanagement.repository.CoursesRepository;

@Service
public class CoursesServiceImpl implements CoursesService {

	@Autowired
	CoursesRepository coursesRepository;

	@Override
	public List<Courses> getAll() {
		return coursesRepository.findAll();
	}

	@Override
	public Courses getById(int id) {
		return coursesRepository.findById(id);
	}
	

	@Override
	public void create(CoursesDto courseDto) {
		Courses courses = new Courses();
		courses.setName(courseDto.getName());
		courses.setDescription(courseDto.getDescription());
		courses.setDurationHour(courseDto.getDurationHour());
		courses.setEnrollmentLimit(courseDto.getEnrollmentLimit());
		courses.setPrerequisites(courseDto.getPrerequisites());
		
		coursesRepository.save(courses);
	}


	@Override
	public void edit(int id, CoursesDto courseDto) {
		Courses course = coursesRepository.findById(id);
		course.setName(courseDto.getName());
		course.setDescription(courseDto.getDescription());
		course.setDurationHour(courseDto.getDurationHour());
		course.setEnrollmentLimit(courseDto.getEnrollmentLimit());
		course.setPrerequisites(courseDto.getPrerequisites());
		
		coursesRepository.save(course);
	}

	@Override
	public void deleteByID(int id) {
		coursesRepository.deleteById(id);
	}
	@Override
	public long countCourses() {
		return coursesRepository.count();
	}
}
