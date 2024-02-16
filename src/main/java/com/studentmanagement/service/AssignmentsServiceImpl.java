package com.studentmanagement.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentmanagement.dto.AssignmentsDto;
import com.studentmanagement.model.Assignments;
import com.studentmanagement.model.TeacherCourses;
import com.studentmanagement.repository.AssignmentsRepository;

@Service
public class AssignmentsServiceImpl implements AssignmentsService{
	@Autowired
	AssignmentsRepository repo ;
	
	@Autowired
	TeacherCoursesService teacherCoursesService;

	@Override
	public void create(AssignmentsDto dto) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String formattedDate = sdf.format(date);
		Assignments entity=new Assignments();
		entity.setTeacherCourses(teacherCoursesService.getById(dto.getTeacherCoursesId()));
		entity.setDescription(dto.getDescription());
		entity.setDueDate(dto.getDueDate());
		entity.setTotalPoint(dto.getTotalPoint());
		entity.setInstruction(dto.getInstruction());
		entity.setDateAssigned(formattedDate);
		entity.setTitle(dto.getTitle());
		repo.save(entity);
	}

	@Override
	public List<Assignments> getAllByTeacherCourses(TeacherCourses tc) {
		return repo.findAllByTeacherCourses(tc);
	}

	@Override
	public long countAssignment() {
		return repo.count();
	}
//	@Override
//	public List<Assignments> getAllByStudentsId(int id) {
//		return repo.findAssignmentsByStudentId(id);
//	}

}
