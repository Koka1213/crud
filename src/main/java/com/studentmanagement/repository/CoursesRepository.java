package com.studentmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentmanagement.model.Admins;
import com.studentmanagement.model.Courses;
import com.studentmanagement.model.Teachers;

@Repository
public interface CoursesRepository extends JpaRepository<Courses, Integer> {
	Courses findById(int id);
	long count();
}
