package com.itela.school.service;


import java.util.List;

import com.itela.school.model.Student;

public interface IStudentService {
	
	public void addStudent(Student student);

	public List<Student> getAllStudent();
	
	public List<Student> getAllStudentByGrade(int grade);

	public void deleteStudent(int studentId);

	public Student getStudent(int studentid);

	public Student updateStudent(Student student);
}
