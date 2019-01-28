package com.itela.school.dao;

import java.util.List;
import com.itela.school.model.Student;

public interface IStudentDAO {

	public void addStudent(Student student);

	public List<Student> getAllStudent();
	
	public List<Student> getAllStudentByGrade(int grade);

	public void deleteStudent(int studentId);

	public Student updateStudent(Student student);

	public Student getStudent(int studentid);
}