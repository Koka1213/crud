package com.studentmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentmanagement.model.Admins;
import com.studentmanagement.model.Students;
import com.studentmanagement.model.TeacherCourseStudentAssignments;
import com.studentmanagement.model.TeacherCourses;

@Repository
public interface TeacherCourseStudentAssignmentsRepository extends JpaRepository<TeacherCourseStudentAssignments, Integer> {

}
