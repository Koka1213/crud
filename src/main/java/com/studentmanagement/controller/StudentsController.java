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

import com.studentmanagement.dto.CoursesDto;
import com.studentmanagement.dto.StudentsDto;
import com.studentmanagement.model.Students;
import com.studentmanagement.service.StudentsService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/students")
public class StudentsController {

	@Autowired
	private StudentsService studentService;

	@GetMapping({ "", "/" })
	public String showStudentsList(Model model) {
		List<Students> students = studentService.getAll();
		model.addAttribute("students", students);
		return "admin/courseList";
	}

	@GetMapping("/create")
	public String showStudentCreate(Model model) {
		StudentsDto studentDto = new StudentsDto();
		model.addAttribute("studentDto", studentDto);
		return "admin/studentCreate";
	}

	@PostMapping("/create")
	public String createStudent(@Valid @ModelAttribute("studentDto") StudentsDto studentDto, BindingResult result) {
		if(result.hasErrors()) {
			return "admin/studentCreate";
		}else{
			studentService.create(studentDto);
			return "redirect:/students/list";
	}
	}

	@GetMapping({ "/list", "/cancel" })
	public String studentList(Model model) {
		List<Students> student = studentService.getAll();
		model.addAttribute("students", student);
		return "admin/studentList";
	}

	@GetMapping("/edit")
	public String showEditStudentPage(Model model, @RequestParam int id) {
		Students student = studentService.getById(id);

		StudentsDto studentDto = new StudentsDto();
		studentDto.setName(student.getName());
		studentDto.setPhone(student.getPhone());
		studentDto.setAddress(student.getAddress());
		studentDto.setEmail(student.getEmail());
		studentDto.setGender(student.getGender());
		studentDto.setDateOfBirth(student.getDateOfBirth());

		model.addAttribute("students", student);
		model.addAttribute("studentDto", studentDto);
		return "admin/editStudent";
	}

	@PostMapping("/edit")
	public String editStudent(Model model, @RequestParam int id,@Valid @ModelAttribute("studentDto") StudentsDto studentDto,
			BindingResult result) {
		try {
			Students student = studentService.getById(id);

			model.addAttribute("students", student);
			model.addAttribute("studentDto", studentDto);
			if (result.hasErrors()) {
				return "admin/editStudent";
			}
			studentService.edit(id, studentDto);
			List<Students> students = studentService.getAll();
			model.addAttribute("students", students);
			return "admin/studentList";
		} catch (Exception ex) {
			System.out.println("Exception: " + ex.getMessage());
			return "admin/studentList";
		}

	}

	@GetMapping("/delete")
	public String deleteStudent(@RequestParam int id, Model model) {
		studentService.deleteByID(id);
		List<Students> student = studentService.getAll();
		model.addAttribute("students", student);
		return "redirect:/students/list";
	}

	@GetMapping("/viewDetail")
	public String viewDetailStudent(@RequestParam int id, Model model) {
		Students student = studentService.getById(id);
		model.addAttribute("student", student);
		return "admin/viewDetailStudent";
	}

}
