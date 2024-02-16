package com.studentmanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.studentmanagement.dto.TeacherCourseStudentsDto;
import com.studentmanagement.model.Students;
import com.studentmanagement.model.TeacherCourseStudents;
import com.studentmanagement.model.TeacherCourses;

@Service
public interface TeacherCourseStudentsService {
	List<TeacherCourseStudents> getAll();
	void create(TeacherCourseStudentsDto teacherCourseStudentsDto);
	TeacherCourseStudents getById(int id);
	void edit(int id,TeacherCourseStudentsDto teacherCourseStudentsDto);
	void deleteByID(int id);
	List<TeacherCourseStudents>findByTeacherCourses(TeacherCourses tc);
	void changeStatus(int id);
	TeacherCourseStudents findByStudents(Students st);
	List<TeacherCourseStudents>findAllByStudents(Students stu);
}
