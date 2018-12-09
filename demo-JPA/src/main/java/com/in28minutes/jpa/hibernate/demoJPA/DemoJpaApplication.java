package com.in28minutes.jpa.hibernate.demoJPA;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.in28minutes.jpa.hibernate.demoJPA.entity.Course;
import com.in28minutes.jpa.hibernate.demoJPA.entity.Review;
import com.in28minutes.jpa.hibernate.demoJPA.repository.CourseRepository;
import com.in28minutes.jpa.hibernate.demoJPA.repository.StudentRepository;

@SpringBootApplication
public class DemoJpaApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Review> reviews = new ArrayList<>();
		reviews.add(new Review("5", "Great 5-minutes work"));
		reviews.add(new Review("5", "Hatsoff"));
		
//		studentRepository.saveStudentWithPassport();
//		courseRepository.addHardcodedReviewsForCourse();
		courseRepository.addReviewsForCourse(10003l,reviews);
	}
}
