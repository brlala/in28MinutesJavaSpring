package com.in28minutes.database.databasedemo.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.in28minutes.database.databasedemo.entity.Person;

//Repository+Transaction
@Repository
@Transactional
public class PersonJpaRepository {
	//connect to database, all operations are stored in @PersistenceContext implemented by interface EntityManager
	@PersistenceContext
	EntityManager entityManager;
	
	public List<Person> findAll(){
		//we need to run a JPQL query which maps using object name instead of table name
		//name of query and what it will return, then add @NamedQuery to the class
		TypedQuery<Person> namedQuery = entityManager.createNamedQuery("find_all_persons", Person.class);
		return namedQuery.getResultList();
	}
	
	public Person findById(int id) {
		return entityManager.find(Person.class, id);
	}
	
	//This will check if the ID matches or not, if there is no matching ID it will insert, if yes it will udpate
	public Person update(Person person) {
		return entityManager.merge(person);
	}
	
	//this method is redundant as update/insert has the same method
	public Person insert(Person person) {
		return entityManager.merge(person);
	}
	
	public void deleteById(int id) {
		Person person = findById(id);
		entityManager.remove(person);
	}
}
