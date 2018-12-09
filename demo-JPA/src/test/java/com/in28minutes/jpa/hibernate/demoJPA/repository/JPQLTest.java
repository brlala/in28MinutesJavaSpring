package com.in28minutes.jpa.hibernate.demoJPA.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.in28minutes.jpa.hibernate.demoJPA.DemoJpaApplication;
import com.in28minutes.jpa.hibernate.demoJPA.entity.Course;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=DemoJpaApplication.class)
public class JPQLTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager em;
	
	//the name used will be entity name instead of table name
	@Test
	public void jpql_basic() {
		//query is without class expectation
		Query query = em.createQuery("Select c From Course c");
		List resultList = query.getResultList();
		logger.info("Select s From Course c -> {}",resultList);
	}
	
	@Test
	public void jpql_typed() {
		//typed query is when you want to retrieve object of type class
		TypedQuery<Course> query = em.createQuery("Select c From Course c", Course.class);
		List<Course> resultList = query.getResultList();
		logger.info("Select c From Course c -> {}",resultList);
	}
	
	@Test
	public void jpql_where() {
		TypedQuery<Course> query = em.createQuery("Select c From Course c where name like '%50%'", Course.class);
		List<Course> resultList = query.getResultList();
		logger.info("Select c From Course c -> {}",resultList);
	}
}
