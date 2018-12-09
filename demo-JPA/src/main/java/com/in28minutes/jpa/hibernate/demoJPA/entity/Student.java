package com.in28minutes.jpa.hibernate.demoJPA.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Student {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	
	@OneToOne(fetch=FetchType.LAZY)
	private Passport passport;
	
	@ManyToMany
	@JoinTable(name="STUDENT_COURSE",joinColumns=@JoinColumn(name="STUDENT_ID"),inverseJoinColumns=@JoinColumn(name="COURSE_ID"))
	//joinColumn - STUDENT_ID
	//inverseJoinColumn - COURSE_ID
	private List<Course> courses = new ArrayList<>();
	
	public Student() {}
	
	public Student(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void addCourse(Course course) {
		this.courses.add(course);
	}

	@Override
	public String toString() {
		return String.format("Student [name=%s]",name);
	}
	
	
}
