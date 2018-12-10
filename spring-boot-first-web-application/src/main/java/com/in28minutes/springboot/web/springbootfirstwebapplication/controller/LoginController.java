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

@Controller
@SessionAttributes("name")
//@ResponseBody
public class LoginController {
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String showWelcomePage(@RequestParam String name,@RequestParam String pw, ModelMap model) {
		boolean isValid = loginService.validateUser(name,pw);
		if (!isValid) {
			model.put("errorMessage", "Invalid Credentials");
			return "login";
		}

		model.put("name", name);
		model.put("password", pw);
		return "welcome";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String loginMessage(ModelMap model) {
		return "login";
	}
}
