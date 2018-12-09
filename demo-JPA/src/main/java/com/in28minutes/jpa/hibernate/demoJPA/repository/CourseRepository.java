package com.in28minutes.jpa.hibernate.demoJPA.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.in28minutes.jpa.hibernate.demoJPA.entity.Course;

@Repository
@Transactional
public class CourseRepository {
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
}
