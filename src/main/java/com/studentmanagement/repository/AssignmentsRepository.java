package com.studentmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.studentmanagement.model.Admins;
import com.studentmanagement.model.Assignments;
import com.studentmanagement.model.TeacherCourses;

@Repository
public interface AssignmentsRepository extends JpaRepository<Assignments, Integer> {
	List<Assignments> findAllByTeacherCourses(TeacherCourses tc);
	long count();
}
