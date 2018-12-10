package com.in28minutes.springboot.web.springbootfirstwebapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.in28minutes.springboot.web.springbootfirstwebapplication.service.LoginService;
import com.in28minutes.springboot.web.springbootfirstwebapplication.service.TodoService;

@Controller
@SessionAttributes("name")
//@ResponseBody
public class TodoController {
	@Autowired
	TodoService TodoService;
	
	@RequestMapping(value="/list-todos",method=RequestMethod.GET)
	public String showTodos(ModelMap model) {
		String name = (String) model.get("name");
		model.put("todos", TodoService.retrieveTodos(name));
		return "list-todos";
	}
}
