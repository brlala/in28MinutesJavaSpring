package com.in28minutes.jpa.hibernate.demoJPA.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

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
public class NativeQueriesTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager em;
	
	//Running as native queries
	@Test
	public void native_queries_basic() {
		Query query = em.createNativeQuery("select * from course",Course.class);
		List resultList = query.getResultList();
		logger.info("Select * from course -> {}",resultList);
	}
	
	@Test
	public void native_queries_with_parameter() {
		Query query = em.createNativeQuery("select * from course where id = ?",Course.class);
		query.setParameter(1, 10001l);
		List resultList = query.getResultList();
		logger.info("Select * from course where id = ? -> {}",resultList);
	}
	
	@Test
	@Transactional
	public void native_queries_to_update() {
		Query query = em.createNativeQuery("update course set last_updated_date=sysdate()",Course.class);
		int noOfRowsUpdated = query.executeUpdate();
		logger.info("noOfRowsUpdated -> {}",noOfRowsUpdated);
	}
}
