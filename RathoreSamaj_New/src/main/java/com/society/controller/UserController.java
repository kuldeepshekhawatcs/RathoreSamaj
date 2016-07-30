package com.society.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.society.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {


	@Autowired  
	UserService userService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String validateUser(@RequestParam("username") String username,@RequestParam("password") String password)
	{
		return userService.validateUser(username,password);
	}

}
