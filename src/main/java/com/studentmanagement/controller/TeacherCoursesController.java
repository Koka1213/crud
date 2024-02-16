package com.studentmanagement.controller;

import java.util.ArrayList;
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

import com.studentmanagement.dto.TeacherCoursesDto;
import com.studentmanagement.dto.TeachersDto;
import com.studentmanagement.model.TeacherCourses;
import com.studentmanagement.service.CoursesService;
import com.studentmanagement.service.TeacherCoursesService;
import com.studentmanagement.service.TeachersService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/teacherCourses")
public class TeacherCoursesController {

	@Autowired
	TeachersService teachersService;
	
	@Autowired
	CoursesService coursesService;
	
	
	@Autowired
	TeacherCoursesService teacherCoursesService;
	
	
	@GetMapping("/create")
	public String showTeacherCoursesCreate(Model model) {

		model.addAttribute("teacherCoursesDto",new TeacherCoursesDto());
		model.addAttribute("teachersList",teachersService.getAll());
		model.addAttribute("coursesList",coursesService.getAll());
		return "admin/TeacherCoursesCreate";
	}
	
	
	@PostMapping("/create")
	public String createTeacherCourses(@Valid  @ModelAttribute("teacherCoursesDto") TeacherCoursesDto teacherCoursesDto, BindingResult result) {
		if(result.hasErrors()) {
			return "admin/TeacherCoursesCreate";
		}else {
			teacherCoursesService.save(teacherCoursesDto);
			return "redirect:/teacherCourses/list";
		}
	}
	
	@GetMapping("/list")
	public String showTeacherCoursesList(Model model) {
		model.addAttribute("teacherCoursesList",teacherCoursesService.getAll());
		return "admin/TeacherCoursesList";
	}
	
	@GetMapping("/cancel")
	public String cancel(@RequestParam("page") String page) {
	    if ("home".equals(page)) {
	        return "redirect:/home"; // Redirect to home
	    } else if ("teacherList".equals(page)) {
	        return "redirect:/teacherList"; // Redirect to TeacherList page
	    } else {
	        return "redirect:/dashboard"; // Default redirect to dashboard
	    }
	}

}

