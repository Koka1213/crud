package com.studentmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentmanagement.model.Admins;
import com.studentmanagement.model.Students;
import com.studentmanagement.model.TeacherCourses;
import com.studentmanagement.model.Teachers;

@Repository
public interface TeacherCoursesRepository extends JpaRepository<TeacherCourses, Integer> {
	TeacherCourses findById(int i);
	List<TeacherCourses> findByTeachers(Teachers tc);
	long count();	
}
