package com.in28minutes.jpa.hibernate.demoJPA.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.in28minutes.jpa.hibernate.demoJPA.entity.Passport;
import com.in28minutes.jpa.hibernate.demoJPA.entity.Student;

@Repository
@Transactional
public class StudentRepository {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager em;
	
	 public Student findById(Long id) {
		 return em.find(Student.class, id);
	 }
	 
	 public void deleteById(Long id) {
		 Student student = findById(id);
		 em.remove(student);
	 }
	 
	 public Student save(Student student) {
		 if (student.getId()==null)
			 em.persist(student);
		 if (student.getId()!=null)
			 em.merge(student);
		 return student;
	 }
	 
	 public void saveStudentWithPassport() {
		 Passport passport = new Passport("Z123456");
		 em.persist(passport);
		 
		 Student student = new Student("Mike");
		 student.setPassport(passport);
		 em.persist(student);
	 }
}
