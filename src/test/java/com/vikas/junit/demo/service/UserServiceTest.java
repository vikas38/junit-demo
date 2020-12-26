package com.vikas.junit.demo.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.vikas.junit.demo.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class UserServiceTest {

	@Autowired
	UserService userService;
	
	@Test
	public void testAddUser() {
		
		//Create a user
		User testUser = new User();
		testUser.setName("test user");
		testUser.setAge(36);
		
		//test adding the contact
		User newUser = userService.saveUser(testUser);
		
		//verify the addition
		assertNotNull(newUser);
		assertNotNull(newUser.getUserId());
		assertEquals("test user", newUser.getName());
	}
	
}
