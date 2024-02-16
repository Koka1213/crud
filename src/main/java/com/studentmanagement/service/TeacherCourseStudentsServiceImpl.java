package com.studentmanagement.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentmanagement.dto.StudentsDto;
import com.studentmanagement.dto.TeacherCourseStudentsDto;
import com.studentmanagement.model.Students;
import com.studentmanagement.model.TeacherCourseStudents;
import com.studentmanagement.model.TeacherCourses;
import com.studentmanagement.repository.TeacherCourseStudentsRepository;

@Service
public class TeacherCourseStudentsServiceImpl implements TeacherCourseStudentsService {
	@Autowired
	private TeacherCourseStudentsRepository repo;
	
	@Autowired
	private TeacherCoursesService teacherCoursesService;
	
	@Autowired
	private StudentsService studentsService;

	@Override
	public List<TeacherCourseStudents> getAll() {
		return repo.findAll();
	}

	@Override
	public void create(TeacherCourseStudentsDto dto) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String formattedDate = sdf.format(date);
		TeacherCourseStudents tcs=new TeacherCourseStudents();
		tcs.setTeacherCourses(teacherCoursesService.getById(dto.getTeacherCoursesId()));
		tcs.setStudents(studentsService.getById(dto.getStudentsId()));
		tcs.setEnrollDate(formattedDate);
		tcs.setStatus(1);
		repo.save(tcs);
//		if (this.findByStudents(studentsService.getById(dto.getStudentsId())) != null 
//			    && !repo.existsByStudentsAndTeacherCourses(studentsService.getById(dto.getStudentsId()), teacherCoursesService.getById(dto.getTeacherCoursesId()))) {
//				System.out.println("Already Registered Students!!!!");
//			}else {
//			repo.save(tcs);
//		/}
	}

	@Override
	public TeacherCourseStudents getById(int id) {
		return repo.findById(id);
	}

	@Override
	public void edit(int id, TeacherCourseStudentsDto dto) {
			TeacherCourseStudents tcs = repo.findById(id);
			tcs.setStudents(studentsService.getById(dto.getStudentsId()));
			tcs.setTeacherCourses(teacherCoursesService.getById(dto.getTeacherCoursesId()));
			tcs.setEnrollDate(dto.getEnrollDate());
			tcs.setStatus(dto.getStatus());
			repo.save(tcs);
		}

	@Override
	public void deleteByID(int id) {
		repo.deleteById(id);
	}

	@Override
	public List<TeacherCourseStudents> findByTeacherCourses(TeacherCourses tc) {
		return repo.findByTeacherCourses(tc);
	}

	@Override
	public void changeStatus(int id) {
		TeacherCourseStudents tcs=repo.findById(id);
		System.out.println("Normal status "+tcs.getStatus());
		if(tcs.getStatus() == 1) {
			tcs.setStatus(0);
		}else{
			tcs.setStatus(1);
		}
		System.out.println("After status "+tcs.getStatus());
		repo.save(tcs);
	}

	@Override
	public TeacherCourseStudents findByStudents(Students st) {
		return repo.findByStudents(st);
	}

	@Override
	public List<TeacherCourseStudents> findAllByStudents(Students stu) {
		return repo.findAllByStudents(stu);
	}

}
