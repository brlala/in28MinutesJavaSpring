package com.in28minutes.jpa.hibernate.demoJPA.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.in28minutes.jpa.hibernate.demoJPA.entity.Course;

@Repository
@Transactional
public class CourseRepository {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//The most important part is the need to talk to entityManager
	@Autowired
	EntityManager em;
	
	 public Course findById(Long id) {
		 return em.find(Course.class, id);
	 }
	 
	 public void deleteById(Long id) {
		 Course course = findById(id);
		 em.remove(course);
	 }
	 
	 public Course save(Course course) {
		 if (course.getId()==null)
			 em.persist(course);
		 if (course.getId()!=null)
			 em.merge(course);
		 return course;
	 }
	 
	 //If it is in a transactional scope, after creating an object, whatever changes made will be automatically persist
	 public void playWithEntityManager() {
//		logger.info("playWithEntityManager - start");
		 
		//CourseCreation
		Course course1 = new Course("Entity Manager service");
		em.persist(course1);
		Course course2 = new Course("Angular JS service");
		em.persist(course2);
		em.flush(); //whatever changes up to now will be sent to database
		
		//EntityManager tracking clear
//		em.detach(course2); // changes to course2 will no longer be tracked
//		em.clear(); // clear all objects tracked by entity manager, thsi will make changes not persist anymore
		
		//This changes will be saved even thou there is no persist method.
		course1.setName("Entity Manager services - Updated");
		course2.setName("Angular JS service - Updated");
		
		em.refresh(course1);//refresh the data of course 1, changes will be lost
		em.flush();

		
	 }
}
