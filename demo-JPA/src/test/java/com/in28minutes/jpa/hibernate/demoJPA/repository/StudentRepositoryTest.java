package com.in28minutes.jpa.hibernate.demoJPA.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.in28minutes.jpa.hibernate.demoJPA.DemoJpaApplication;
import com.in28minutes.jpa.hibernate.demoJPA.entity.Course;
import com.in28minutes.jpa.hibernate.demoJPA.entity.Passport;
import com.in28minutes.jpa.hibernate.demoJPA.entity.Student;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=DemoJpaApplication.class)
public class StudentRepositoryTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	StudentRepository repository;
	
	@Autowired
	EntityManager em;
	
	@Test
	@Transactional //Persistence Context place where info is stored
	public void someTest() {
		//Database Operation 1 - retrieve student
		Student student = em.find(Student.class, 20001l);
		//Persistence Context contains (student)
		
		//Database Operation 2 - retrieve passport
		Passport passport = student.getPassport();
		//Persistence Context contains (student, passport)
		
		//Database Operation 3 - update student
		passport.setNumber("E123457");
		//Persistence Context contains (student, passport++)
		
		//Database Operation 4 - update student
		student.setName("Ranga - updated");
		//Persistence Context contains (student++, passport++)
	}
	
	@Test
	@Transactional
	public void retrieveStudentAndPassportDetails() {
		Student student = em.find(Student.class, 20001l);
		logger.info("student -> {}",student);
		logger.info("passport -> {}",student.getPassport());
	}
	
	//Bidirectional - getting student details from Passport
	@Test
	@Transactional
	public void retrievePassportAndAssociatedStudent() {
		Passport passport = em.find(Passport.class, 40001l);
		logger.info("passport -> {}",passport);
		logger.info("student -> {}",passport.getStudent());
	}
	
	
	//Bidirectional - Many to Many
	@Test
	@Transactional
	public void retrieveStudentAndCourses() {
		Student student = em.find(Student.class, 20001l);
		logger.info("student -> {}",student);
		logger.info("courses -> {}",student.getCourses());
	}
	
	@Test
	@Transactional
	public void retrieveCourseAndStudents() {
		Course course = em.find(Course.class, 20001l);
		logger.info("courses -> {}",course);
		logger.info("student -> {}",course.getStudents());
	}
}
