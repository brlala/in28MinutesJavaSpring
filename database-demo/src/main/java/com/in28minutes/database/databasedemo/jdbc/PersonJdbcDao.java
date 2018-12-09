package com.in28minutes.database.databasedemo.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.in28minutes.database.databasedemo.entity.Person;

@Repository //added to Dao
public class PersonJdbcDao {
	
	//Use spring to give database connection to us
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	//select * from person
	public List<Person> findAll(){
		//this will return a resultset but we still have to map it to a database
		return jdbcTemplate.query("select * from person", new BeanPropertyRowMapper<Person>(Person.class));
	}
	
	public Person findById(int id){
		//this will return a resultset but we still have to map it to a database, queries are passed in as array of parameter
		return jdbcTemplate.queryForObject("select * from person where id=?", new Object[] {id}, new BeanPropertyRowMapper<Person>(Person.class));
	}
	
	public List<Person> findByName(String name){
		//this will return a resultset but we still have to map it to a database, queries are passed in as array of parameter
		return jdbcTemplate.query("select * from person where name=?", new Object[] {name}, new BeanPropertyRowMapper<Person>(Person.class));
	}
}
