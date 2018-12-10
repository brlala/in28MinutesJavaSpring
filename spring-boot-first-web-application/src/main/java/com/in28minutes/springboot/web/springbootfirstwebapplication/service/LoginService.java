package com.in28minutes.springboot.web.springbootfirstwebapplication.service;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.SessionAttributes;

@Component
public class LoginService {

	public boolean validateUser(String userId, String password) {
		//henry,pw:smarty
		return userId.equalsIgnoreCase("in28Minutes")&&password.equalsIgnoreCase("");
	}
}
