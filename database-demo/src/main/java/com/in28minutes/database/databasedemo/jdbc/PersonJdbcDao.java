package com.in28minutes.database.databasedemo.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.in28minutes.database.databasedemo.entity.Person;

@Repository //added to Dao
public class PersonJdbcDao {
	
	//Use spring to give database connection to us
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	//Implementing custom rowmapper, how do you want to map one row to a person, used when table definition is different with bean
	class PersonRowMapper implements RowMapper<Person>{

		@Override
		public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
			Person person = new Person();
			person.setId(rs.getInt("id"));
			person.setName(rs.getString("name"));
			person.setLocation(rs.getString("location"));
			person.setBirthDate(rs.getTimestamp("birth_date"));
			return person;
		}
		
		
	}
	
	//select * from person
	public List<Person> findAll(){
		//this will return a resultset but we still have to map it to a database
		return jdbcTemplate.query("select * from person", new PersonRowMapper());
	}
	
	public Person findById(int id){
		//this will return a resultset but we still have to map it to a database, queries are passed in as array of parameter
		return jdbcTemplate.queryForObject("select * from person where id=?", new Object[] {id}, new BeanPropertyRowMapper<Person>(Person.class));
	}
	
	public List<Person> findByName(String name){
		//demo for find by Name, could be more than one person with same name
		return jdbcTemplate.query("select * from person where name=?", new Object[] {name}, new BeanPropertyRowMapper<Person>(Person.class));
	}
	
	public int deleteById(int id){
		//update and delete operation uses jdbctemplate.update, and we dont need to map it, the method will return an int of how many rows affected
		return jdbcTemplate.update("delete from person where id=?", new Object[] {id});
	}
	
	public int deleteByIdName(int id, String name){
		//multiple parameters search
		return jdbcTemplate.update("delete from person where id=? and name=?", new Object[] {id,name});
	}
	
	public int insert(Person person){
		//insert operation, converting the time to SQL timestamp format
		return jdbcTemplate.update("insert into person (id, name, location, birth_date ) values(?, ?, ?, ?)", 
				new Object[] {
						person.getId(),person.getName(),person.getLocation(),new Timestamp(person.getBirthDate().getTime())});
	}
	
	public int update(Person person){
		//update operation, name, location and birth_date only
		return jdbcTemplate.update("update person set name = ?, location=?, birth_date=? where id=?", 
				new Object[] {
						person.getName(),person.getLocation(),new Timestamp(person.getBirthDate().getTime()),person.getId()});
	}
}
