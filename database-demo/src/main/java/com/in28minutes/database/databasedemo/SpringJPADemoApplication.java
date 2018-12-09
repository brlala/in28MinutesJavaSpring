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
import com.in28minutes.database.databasedemo.jpa.PersonJpaRepository;

@SpringBootApplication
public class SpringJPADemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonJpaRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringJPADemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("User id -> 10001 {}", repository.findById(10001));
		logger.info("Inserting Pieter(10005) -> rows affected - {}", repository.insert(new Person("Ley","Berlin",new Date())));
		logger.info("Updating Pieter(10003) -> rows affected - {}", repository.update(new Person(10003,"Peter","Uruguay",new Date())));
		repository.deleteById(10002);
		logger.info("All users -> {}", repository.findAll());
//		logger.info("Name -> Pieter {}", dao.findByName("Pieter"));
		//10003,  'Pieter', 'Amsterdam',sysdate()
	}
}
