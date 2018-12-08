package com.in28minutes.springboot.basics.springbootin10steps;

import java.util.List;
import java.util.Arrays;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //use to identify controller
public class BookController {
	@GetMapping("/books") //controller for the URL
	public List<Book> getAllBooks(){
		return Arrays.asList(new Book(1, "Mastering Spring 5.0", "Rangga"));
	}
}
