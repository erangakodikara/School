package com.itela.school.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itela.school.model.Student;

@Repository
public class StudentDAOImpl implements IStudentDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void addStudent(Student student) {
		sessionFactory.getCurrentSession().saveOrUpdate(student);

	}

	@SuppressWarnings("unchecked")
	public List<Student> getAllStudent() {
		return sessionFactory.getCurrentSession().createQuery("from  Student")
				.list();
	}

	public void deleteStudent(int studentId) {
		Student student = (Student) sessionFactory.getCurrentSession().load(
				Student.class, studentId);
		if (null != student) {
			this.sessionFactory.getCurrentSession().delete(student);
		}

	}

	public Student getStudent(int studentid) {
		return (Student) sessionFactory.getCurrentSession().get(
				Student.class,studentid);
	}

	public Student updateStudent(Student student) {
		sessionFactory.getCurrentSession().update(student);
		return student;
	}

	@SuppressWarnings("unchecked")
	public List<Student> getAllStudentByGrade(int grade) {
        Criteria crit = this.sessionFactory.getCurrentSession().createCriteria(Student.class);
        crit.add(Restrictions.eq("grade", grade));
        List<Student> results = crit.list();
        return results;
	}
}