package com.in28minutes.springboot.web.springbootfirstwebapplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//@ResponseBody
public class LoginController {
	
//	@RequestMapping("/login")
//	public String loginMessage(@RequestParam String nameVar, ModelMap model) {
//		model.put("name1", nameVar);
//		return "login";
//	}
	
	@RequestMapping("/login")
	public String loginMessage(@RequestParam String nameVar, ModelMap model) {
//		model.put("name1", nameVar);
		return "login";
	}
}
