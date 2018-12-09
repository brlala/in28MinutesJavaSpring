package com.in28minutes.database.databasedemo;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.in28minutes.database.databasedemo.entity.Person;
import com.in28minutes.database.databasedemo.jdbc.PersonJdbcDao;

//@SpringBootApplication
public class SpringJDBCDemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonJdbcDao dao;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringJDBCDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("User id -> 10001 {}", dao.findById(10001));
//		logger.info("All users -> {}", dao.findAll());
//		logger.info("Name -> Pieter {}", dao.findByName("Pieter"));
//		logger.info("Deleting 10002 -> rows affected - {}", dao.deleteById(10002));
//		logger.info("Deleting Pieter(10004) -> rows affected - {}", dao.deleteByIdName(10004,"Pieter"));
//		logger.info("Inserting Pieter(10005) -> rows affected - {}", dao.insert(new Person(10005,"Ley","Berlin",new Date())));
//		logger.info("Updating Pieter(10003) -> rows affected - {}", dao.update(new Person(10003,"Peter","Uruguay",new Date())));
		//10003,  'Pieter', 'Amsterdam',sysdate()
	}
}
