package com.studentmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.studentmanagement.model.Admins;
import com.studentmanagement.service.AdminsService;
import com.studentmanagement.service.AssignmentsService;
import com.studentmanagement.service.CoursesService;
import com.studentmanagement.service.StudentsService;
import com.studentmanagement.service.TeacherCoursesService;
import com.studentmanagement.service.TeachersService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {

	
	@Autowired
	TeachersService teachersService;

	@Autowired
	AdminsService adminsService;
	
	@Autowired
	StudentsService studentsService;
	
	
	@Autowired
	CoursesService coursesService;
	
	@Autowired
	AssignmentsService assignmentService;
	
	@Autowired
	TeacherCoursesService  teacherCoursesService;
	
	@GetMapping("/singIn")
	public String showSignUpForm(Model model) {
		Admins admins = new Admins();
		model.addAttribute("admins", admins);
		return "admin/adminLogin";
	}
	
	@PostMapping("/validate")
	public String validateUser(@ModelAttribute Admins admins,HttpSession session,Model model) {
		Admins validateAdmin=adminsService.findByEmailAndPassword(admins);
		if( validateAdmin != null) {
			session.setAttribute("adminsEmail", admins.getEmail());
			return "redirect:/admin/dashboard";			
		}else {
			System.out.println("Not register user");
			return "admin/adminLogin";
		}
	}
	@GetMapping("/dashboard")
	public String showdashboard(Model model) {
		long teachers = teachersService.countTeacher();
		model.addAttribute("teachers",teachers);
		long students = studentsService.countStudents();
		model.addAttribute("students",students);
		long courses = coursesService.countCourses();
		model.addAttribute("courses",courses);
		long assignments = assignmentService.countAssignment();
		model.addAttribute("assignments",assignments);
		long teacherCourses = teacherCoursesService.countTeacherCourse();
		model.addAttribute("teacherCourses",teacherCourses);
		return "admin/dashboard";
	}

	@GetMapping("/profile")
	public String profile(HttpSession session,Model model) {
		// Retrieve the user ID from the session
	    String email = (String) session.getAttribute("adminsEmail");

	    // Use the user ID to retrieve the user object from the database
	    Admins admin = adminsService.getByEmail(email);
	    
	    // Add the user object to the model
	    model.addAttribute("admin", admin);
	    return "admin/profile";
	}
}
