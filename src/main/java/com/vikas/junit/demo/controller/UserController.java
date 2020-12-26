package com.vikas.junit.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vikas.junit.demo.model.User;
import com.vikas.junit.demo.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/users")
	public List<User> get(){
		return userService.getAllUser();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/new")
	public User insert(){
		User user = new User();
		user.setAge(25);
		user.setName("Vikas");
		return userService.saveUser(user);
	}
}
