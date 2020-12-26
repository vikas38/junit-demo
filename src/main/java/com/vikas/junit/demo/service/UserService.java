package com.vikas.junit.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vikas.junit.demo.dao.UserRepo;
import com.vikas.junit.demo.model.User;

@Service
public class UserService {
	
	@Autowired
	UserRepo repo;
	
	public User saveUser(User user) {
		return repo.save(user);
	}
	
	public List<User> getAllUser(){
		return repo.findAll();
	}
}
