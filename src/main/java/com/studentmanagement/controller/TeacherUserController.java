//package com.studentmanagement.controller;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.studentmanagement.model.TeacherCourses;
//import com.studentmanagement.model.Teachers;
//import com.studentmanagement.service.AssignmentsService;
//import com.studentmanagement.service.TeacherCourseStudentsService;
//import com.studentmanagement.service.TeacherCoursesService;
//import com.studentmanagement.service.TeachersService;
//
//import jakarta.servlet.http.HttpSession;
//import jakarta.validation.Valid;
//
//import com.studentmanagement.dto.AssignmentsDto;
//
//@Controller
//@RequestMapping("/teachers")
//public class TeacherUserController {
//
//	
//	@Autowired
//	TeacherCoursesService teacherCoursesService;
//	
//	@Autowired
//	TeachersService teachersService;
//	
//	@Autowired
//	TeacherCourseStudentsService teacherCourseStudentsService;
//	
//	@Autowired
//	AssignmentsService assignmentsService;
//
//	@GetMapping("/signIn")
//	public String showSignUpForm(Model model) {
//		Teachers teachers = new Teachers();
//		model.addAttribute("teachers", teachers);
//		return "teacher/teacherLogin";
//	}
//	
//	@PostMapping("/validate")
//	public String validateUser(@ModelAttribute Teachers teachers,HttpSession session) {
//		Teachers validateTeacher=teachersService.findByEmailAndPassword(teachers);
//		if( validateTeacher != null) {
//			session.setAttribute("teacherSession", validateTeacher);
//			return "redirect:/teachers/teacherCourses";			
//		}else {
//			System.out.println("Not register user");
//			return "teacher/teacherLogin";
//		}
//	}
//	
//	@GetMapping("/teacherCourses")
//	public String showTeacherCourses(Model model,HttpSession session) {
//		Teachers t=(Teachers) session.getAttribute("teacherSession");
//		model.addAttribute("teacherCourses",teacherCoursesService.getByTeachers(t));
//		return "teacher/dashboard";
//	}
//	
//	@GetMapping("/teacherCourses/viewDetail")
//	public String viewDetail(@RequestParam int id, Model model) {
//		TeacherCourses tc = teacherCoursesService.getById(id);
//		model.addAttribute("teacherCourses", tc);
//		model.addAttribute("assignments",assignmentsService.getAllByTeacherCourses(teacherCoursesService.getById(id)));
//		model.addAttribute("teacherCourseStudents",teacherCourseStudentsService.findByTeacherCourses(tc));
//		return "teacher/viewDetailTeacherCourseStudent";
//	}
//
//	@GetMapping("/teacherCourses/assignment/create")
//	public String showAssignmentsCreate(Model model, @RequestParam int id ) {
//		int teacherCoursesId=id;
//		AssignmentsDto dto = new AssignmentsDto();
//		dto.setTeacherCoursesId(teacherCoursesId);
//		model.addAttribute("teacherCoursesId",teacherCoursesId);
//		model.addAttribute("assignmentsDto", dto);
//		return "teacher/assignmentsCreate";
//	}
//	
//	@PostMapping("/teacherCourses/assignment/create")
//	public String teacherCourseAssignmentsCreate( @ModelAttribute("assignmentsDto") AssignmentsDto dto,@RequestParam("id") String id) {
//			dto.setTeacherCoursesId(Integer.parseInt(id));
//	        assignmentsService.create(dto);
//	        return "redirect:/teachers/teacherCourses"; 
//	    }
//	
//}
