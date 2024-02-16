package com.studentmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.studentmanagement.model.Students;
import com.studentmanagement.model.TeacherCourseStudents;
import com.studentmanagement.model.Teachers;
import com.studentmanagement.service.AssignmentsService;
import com.studentmanagement.service.StudentsService;
import com.studentmanagement.service.TeacherCourseStudentsService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/students")
public class StudentsUserController {
	@Autowired
	TeacherCourseStudentsService teacherCourseStudentsService;
	
	@Autowired
	StudentsService  studentsService;
	
	@Autowired
	AssignmentsService assigmentsService;
	
	@GetMapping("/users")
	public String showStudentDashBoard(Model model,HttpSession session) {
		Students stu=(Students)session.getAttribute("studentSession");
		List<TeacherCourseStudents> tcs=teacherCourseStudentsService.findAllByStudents(studentsService.getById(stu.getId()));
		model.addAttribute("teacherCourseStudets",tcs);
		return "student/dashboard";
	}	
	
	@GetMapping("/courses/viewDetail")
	public String showTeacherCourseStudentsDetail(Model model,@RequestParam int id,HttpSession session) {
		Students stu=(Students)session.getAttribute("studentSession");
//		Students stu=studentsService.getById(3);
		int teacherCourseStudentsId =id;
		TeacherCourseStudents tcs=teacherCourseStudentsService.getById(teacherCourseStudentsId);
		
		for(int i=0; i<stu.getTeacherCourseStudents().size();i++){
			System.out.println("Yooooooooo "+stu.getTeacherCourseStudents().indexOf(i));
		}
		stu.getTeacherCourseStudents();
		return "student/assignmentsList";
	}	
	
	
	@GetMapping("/signIn")
	public String showSignUpForm(Model model) {
		Students students = new Students();
		model.addAttribute("students", students);
		return "student/studentLogin";
	}
	
	@PostMapping("/validate")
	public String validateUser(@ModelAttribute Students students,HttpSession session) {
		Students validateStudent=studentsService.findByEmailAndPassword(students);
		if( validateStudent != null) {
			session.setAttribute("studentSession", validateStudent);
			session.setAttribute("studentsEmail", students.getEmail());
			return "redirect:/students/users";			
		}else {
			System.out.println("Not register user");
			return "student/studentLogin";
		}
	}
	
	@GetMapping("/profile")
	public String profile(HttpSession session,Model model) {
		// Retrieve the user ID from the session
	    String email = (String) session.getAttribute("studentsEmail");

	    // Use the user ID to retrieve the user object from the database
	    Students student = studentsService.getByEmail(email);
	    
	    // Add the user object to the model
	    model.addAttribute("student", student);
	    return "student/profile";
	}
	
}
