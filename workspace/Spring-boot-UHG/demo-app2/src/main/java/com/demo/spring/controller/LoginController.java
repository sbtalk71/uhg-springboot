package com.demo.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@RequestMapping(path="/login",method=RequestMethod.GET)
	public String getLoginPage() {
		return "login";
	}
	
	@RequestMapping(path="/login",method=RequestMethod.POST)
	public String handleSubmit(@RequestParam("username")String userName, @RequestParam("password")String password) {
		if(userName.equals(password)) {
			return "success";
		}else {
			return "failure";
		}
	}
}
