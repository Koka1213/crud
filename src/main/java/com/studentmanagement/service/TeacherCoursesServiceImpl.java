package com.studentmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentmanagement.dto.TeacherCoursesDto;
import com.studentmanagement.model.TeacherCourses;
import com.studentmanagement.model.Teachers;
import com.studentmanagement.repository.TeacherCoursesRepository;

@Service
public class TeacherCoursesServiceImpl implements TeacherCoursesService {
	@Autowired
	TeacherCoursesRepository tcRepository;
	
	@Autowired
	TeachersService teachersService;
	
	@Autowired
	CoursesService coursesService;
	
	@Override
	public TeacherCourses save(TeacherCoursesDto tcDto) {
		TeacherCourses  tc=new TeacherCourses();
		tc.setName(tcDto.getName());
		tc.setTeachers(teachersService.getById(tcDto.getTeacherId()));
		tc.setCourses(coursesService.getById(tcDto.getCourseId()));
		tc.setStartDate(tcDto.getStartDate());
		tc.setEndDate(tcDto.getEndDate());
		return tcRepository.save(tc);
	}

	@Override
	public List<TeacherCourses> getAll() {
		return tcRepository.findAll();
	}
	
	@Override
	public TeacherCourses getById(int id) {
		return tcRepository.findById(id);
	}

	@Override
	public List<TeacherCourses> getByTeachers(Teachers t) {
		return tcRepository.findByTeachers(t);
	}
	@Override
	public long countTeacherCourse() {
		return tcRepository.count();
	}

	
}
