package com.itela.school.controller;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.itela.school.model.Student;
import com.itela.school.service.IStudentService;

@Controller
public class StudentController {

	private static final Logger logger = Logger
			.getLogger(StudentController.class);

	public StudentController() {
		System.out.println("StudentController()");
	}

	@Autowired
	private IStudentService studentService;

	@RequestMapping(value = "/")
	public ModelAndView listStudent(ModelAndView model) throws IOException {
		List<Student> listStudent = studentService.getAllStudent();
		model.addObject("listStudent", listStudent);
		model.setViewName("home");
		return model;
	}

	@RequestMapping(value = "/newStudent", method = RequestMethod.GET)
	public ModelAndView newStudent(ModelAndView model) {
		Student student = new Student();
		model.addObject("student", student);
		model.setViewName("StudentForm");
		return model;
	}

	@RequestMapping(value = "/saveStudent", method = RequestMethod.POST)
	public ModelAndView saveStudent(@ModelAttribute Student student) {
		System.out.println(student.getId());
	
		if(student.getId() != null) {
			studentService.updateStudent(student);
		} else {
			studentService.addStudent(student);
		}
		
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/deleteStudent", method = RequestMethod.GET)
	public ModelAndView deleteStudent(HttpServletRequest request) {
		int studentId = Integer.parseInt(request.getParameter("id"));
		studentService.deleteStudent(studentId);
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/editStudent", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
		int studentId = Integer.parseInt(request.getParameter("id"));
		Student student = studentService.getStudent(studentId);
		ModelAndView model = new ModelAndView("StudentForm");
		model.addObject("student", student);

		return model;
	}
	
	@RequestMapping(value = "/getStudentByGrade", method = RequestMethod.GET)
	public ModelAndView getStudentByGrade(HttpServletRequest request) {
		int grade = Integer.parseInt(request.getParameter("grade"));
		List<Student> listStudent = studentService.getAllStudentByGrade(grade);
		ModelAndView model = new ModelAndView("StudentByGrade");
		model.addObject("listStudent", listStudent);
		model.setViewName("StudentByGrade");
		return model;
	}

}
