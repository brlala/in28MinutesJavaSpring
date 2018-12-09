package com.in28minutes.jpa.hibernate.demoJPA.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

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

@RunWith(SpringRunner.class)
@SpringBootTest(classes=DemoJpaApplication.class)
public class CourseRepositoryTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CourseRepository repository;
	
	@Test
	public void findById_basic() {
		Course course = repository.findById(10001l);
		assertEquals("JPA in 50 steps",course.getName());
		logger.info("Test is running");
	}
	
	@Test
	@DirtiesContext
	public void deleteById_basic() {
		repository.deleteById(10002l);
		assertNull(repository.findById(10002l));
	}

	@Test
	@DirtiesContext
	public void save_basic() {
		//Get a course
		Course course = repository.findById(10001l);
		assertEquals("JPA in 50 steps",course.getName());
		
		//Update details
		course.setName("JPA in 50 steps - Updated");
		repository.save(course);
		
		//Check value
		Course course1 = repository.findById(10001l);
		assertEquals("JPA in 50 steps - Updated",course1.getName());
	}
	
	@Test
	@DirtiesContext
	public void playWithEntityManager() {
		repository.playWithEntityManager();
	}
}
