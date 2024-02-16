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
import com.studentmanagement.dto.TeachersDto;
import com.studentmanagement.model.Courses;
import com.studentmanagement.service.CoursesService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/courses")
public class CoursesController {
	
	@Autowired
	CoursesService coursesService;
	
	@GetMapping({"", "/"})
	public String showProductList(Model model) {
		List<Courses> course = coursesService.getAll();
		model.addAttribute("courses", course);
		return "admin/courseList";
	}
	
	@GetMapping("/create")
	public String showCourseCreate(Model model) {
		CoursesDto courseDto = new CoursesDto();
		model.addAttribute("courseDto", courseDto);
		return "admin/courseCreate";
	}

	@PostMapping("/create")
	public String createCourse(@Valid  @ModelAttribute("courseDto")  CoursesDto courseDto, BindingResult result) {
	    if (result.hasErrors()) {
	        return "admin/courseCreate";
	    } else {
	    	coursesService.create(courseDto);
	        return "redirect:/courses/create";
	    }
	}
	@GetMapping({ "/list", "/cancel" })
	public String courseList(Model model) {
		List<Courses> course = coursesService.getAll();
		model.addAttribute("courses", course);
		return "admin/courseList";
	}

	@GetMapping("/edit")
	public String showEditCoursePage(Model model, @RequestParam int id) {

		Courses course = coursesService.getById(id);
		CoursesDto courseDto = new CoursesDto();
		courseDto.setName(course.getName());
		courseDto.setDescription(course.getDescription());
		courseDto.setDurationHour(course.getDurationHour());
		courseDto.setEnrollmentLimit(course.getEnrollmentLimit());
		courseDto.setPrerequisites(course.getPrerequisites());

		model.addAttribute("courses", course);
		model.addAttribute("courseDto", courseDto);
		return "admin/editCourse";
	}

	@PostMapping("/edit")
	public String editCourse(Model model, @RequestParam int id,@Valid @ModelAttribute("courseDto")  CoursesDto courseDto,
			BindingResult result) {
		try {
			Courses course = coursesService.getById(id);

			model.addAttribute("courses", course);
			model.addAttribute("courseDto", courseDto);
			if (result.hasErrors()) {
				return "admin/editCourse";
			}
			coursesService.edit(id, courseDto);
			List<Courses> courses = coursesService.getAll();
			model.addAttribute("courses", courses);
			return "admin/courseList";
		} catch (Exception ex) {
			System.out.println("Exception: " + ex.getMessage());
			return "admin/courseList";
		}
	}

	@GetMapping("/delete")
	public String deleteCourse(@RequestParam int id, Model model) {
		coursesService.deleteByID(id);
		List<Courses> course = coursesService.getAll();
		model.addAttribute("courses", course);
		return "admin/courseList";
	}

	@GetMapping("/viewDetail")
	public String viewDetailCourse(@RequestParam int id, Model model) {
		Courses course = coursesService.getById(id);
		model.addAttribute("course", course);
		return "admin/viewDetailCourse";
	}

}
