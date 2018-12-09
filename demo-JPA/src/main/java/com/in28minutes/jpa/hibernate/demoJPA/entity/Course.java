package com.in28minutes.jpa.hibernate.demoJPA.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@NamedQueries(value= {
		@NamedQuery(name="query_get_all_courses", query="Select c From Course c"),
		@NamedQuery(name="query_get_like_50", query="Select c From Course c where name like '%50%'")
})

//Entity name is Course, but table name is CourseDetails
//@Table(name="CourseDetails")
public class Course {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="fullname")
	private String name;
	
	@OneToMany(mappedBy="course")
	private List<Review> reviews = new ArrayList<>();
	
	@UpdateTimestamp
	private LocalDateTime lastUpdatedDate;
	
	@CreationTimestamp
	private LocalDateTime createdDate;

	//must include no argument constructor to use @Entity
	public Course() {}
	
	public Course(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void addReview(Review review) {
		this.reviews.add(review);
	}

	public void removeReview(Review review) {
		this.reviews.remove(review);
	}
	
	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return String.format("Course [name=%s]",name);
	}
	
	
}
