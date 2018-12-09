package com.in28minutes.jpa.hibernate.demoJPA.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.in28minutes.jpa.hibernate.demoJPA.entity.Course;

@Repository
public class CourseRepository {
	//The most important part is the need to talk to entityManager
	@Autowired
	EntityManager em;
	
	 public Course findById(Long id) {
		 return em.find(Course.class, id);
	 }
//	 public Course save(Course course) -> insert or update
//	 public void deleteById(Long id)
}