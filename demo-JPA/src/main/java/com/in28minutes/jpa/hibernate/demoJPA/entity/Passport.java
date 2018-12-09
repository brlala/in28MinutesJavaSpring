package com.in28minutes.jpa.hibernate.demoJPA.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Passport {
	@Id
	@GeneratedValue
	private Long id;
	
	private String number;
	
	//Adding a OneToOne field here will make duplication of ID, therefore use the parameter mappedBy then use variable name from owning class
	@OneToOne(fetch=FetchType.LAZY,mappedBy="passport")
	private Student student;
	
	public Passport() {}
	
	public Passport(String number) {
		super();
		this.number = number;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Long getId() {
		return id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return String.format("Passport [number=%s]",number);
	}
	
	
}
