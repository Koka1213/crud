package com.studentmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.studentmanagement.dto.StudentsDto;
import com.studentmanagement.model.Courses;
import com.studentmanagement.model.Students;
import com.studentmanagement.model.TeacherCourseStudents;
import com.studentmanagement.model.TeacherCourses;
import com.studentmanagement.model.Teachers;
import com.studentmanagement.service.CoursesService;
import com.studentmanagement.service.StudentsService;
import com.studentmanagement.service.TeacherCourseStudentsService;
import com.studentmanagement.service.TeacherCoursesService;
import com.studentmanagement.dto.TeacherCourseStudentsDto;



@Controller
@RequestMapping("/teacherCourseStudents")
public class TeacherCourseStudentsController {
	
	
	@Autowired
	private TeacherCoursesService teacherCoursesService;
	
	@Autowired
	private StudentsService studentsService;
	
	@Autowired
	private TeacherCourseStudentsService teacherCourseStudentsService;
	

	

	@GetMapping({ "", "/" })
	public String showTeacherCourseStudents(Model model) {
		List<TeacherCourses> teacherCourses = teacherCoursesService.getAll();
		model.addAttribute("teacherCourses", teacherCourses);
		return "admin/teacherCourseStudentsList";
	}

	@GetMapping("/viewDetail")
	public String viewDetail(@RequestParam int id, Model model) {
		TeacherCourses tc = teacherCoursesService.getById(id);
		model.addAttribute("teacherCourses", tc);
		model.addAttribute("teacherCourseStudents",teacherCourseStudentsService.findByTeacherCourses(tc));
		return "admin/viewDetailTeacherCourseStudent";
	}

	@GetMapping("/create")
	public String showTeacherCourseStudentsCreate(Model model, @RequestParam int id ) {
		int teacherCoursesId=id;
		TeacherCourseStudentsDto dto = new TeacherCourseStudentsDto();
		dto.setTeacherCoursesId(teacherCoursesId);
		model.addAttribute("teacherCourseStudentsDto", dto);
		model.addAttribute("students",studentsService.getAll());
		return "admin/teacherCourseStudentsCreate";
	}
	
	@PostMapping("/create")
	public String teacherCourseStudentsCreate(@ModelAttribute("teacherCourseStudentsDto") TeacherCourseStudentsDto dto) {
		teacherCourseStudentsService.create(dto);
		return "redirect:/teacherCourseStudents";
	}
	
	@GetMapping("/changeStatus")
	public String changeStatus(@RequestParam int id, Model model) {
		System.out.println("Yo Yo Yo "+id);
		teacherCourseStudentsService.changeStatus(id);
		return "redirect:/teacherCourseStudents";
	}
}
