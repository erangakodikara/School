package com.itela.school.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itela.school.dao.IStudentDAO;
import com.itela.school.model.Student;

@Service
@Transactional
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private IStudentDAO studentDAO;

	@Transactional
	public void addStudent(Student student) {
		studentDAO.addStudent(student);
	}

	@Transactional
	public List<Student> getAllStudent() {
		return studentDAO.getAllStudent();
	}

	@Transactional
	public void deleteStudent(int studentId) {
		studentDAO.deleteStudent(studentId);
	}

	public Student getStudent(int empid) {
		return studentDAO.getStudent(empid);
	}

	public Student updateStudent(Student student) {
		// TODO Auto-generated method stub
		return studentDAO.updateStudent(student);
	}

	public void setStudentDAO(IStudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	public List<Student> getAllStudentByGrade(int grade) {
		return studentDAO.getAllStudentByGrade(grade);
	}

}
