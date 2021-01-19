package com.vikas.junit.demo.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.vikas.junit.demo.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UserControllerIntegrationTest {
	
	@Autowired
	UserController userController;
	
	@Test
	public void addUserHappyPath() {
		User user = new User();
		
		user.setName("Bablu Pandit");
		user.setAge(24);
		
		String outCome = userController.addNewUser(user);
		
		assertThat(outCome, is(equalTo("success")));
	}
	
	@Test
	public void addUserNotSoHappyPath() {
		User user = new User();
		
		String outcome = userController.addNewUser(user);
		
		assertThat(outcome, is(equalTo("failure")));
	}

}
