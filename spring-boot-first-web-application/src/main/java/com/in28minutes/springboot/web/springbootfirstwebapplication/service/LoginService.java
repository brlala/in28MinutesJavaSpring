package com.in28minutes.springboot.web.springbootfirstwebapplication.service;

import org.springframework.stereotype.Component;

@Component
public class LoginService {

	public boolean validateUser(String userId, String password) {
		//henry,pw:smarty
		return userId.equalsIgnoreCase("henry")&&password.equalsIgnoreCase("smarty");
	}
}
