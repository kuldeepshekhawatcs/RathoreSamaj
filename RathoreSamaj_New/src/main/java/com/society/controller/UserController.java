package com.society.controller;

import java.util.HashMap;
import java.util.Map;

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
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Map<String, String> validateUser(@RequestParam("username") String username,@RequestParam("password") String password)
	{
		Map<String, String> response = new HashMap<String, String>();
		response.put("response",userService.validateUser(username,password));
		return response;
	}

}
