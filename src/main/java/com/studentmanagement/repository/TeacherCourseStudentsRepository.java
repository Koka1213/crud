package com.studentmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentmanagement.model.Admins;
import com.studentmanagement.model.Students;
import com.studentmanagement.model.TeacherCourseStudentAssignments;
import com.studentmanagement.model.TeacherCourseStudents;
import com.studentmanagement.model.TeacherCourses;

@Repository
public interface TeacherCourseStudentsRepository extends JpaRepository<TeacherCourseStudents, Integer> {
	TeacherCourseStudents findById(int id);
	List<TeacherCourseStudents> findByTeacherCourses(TeacherCourses tc);
	TeacherCourseStudents findByStudents(Students st);
	//boolean existsByStudentsAndTeacherCourses(Students stu, TeacherCourses tc);
	List<TeacherCourseStudents> findAllByStudents(Students stu);
}
