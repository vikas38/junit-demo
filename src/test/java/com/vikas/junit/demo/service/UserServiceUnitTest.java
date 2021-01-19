package com.vikas.junit.demo.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.mockito.Matchers.any;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.vikas.junit.demo.dao.UserRepo;
import com.vikas.junit.demo.model.User;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class UserServiceUnitTest {
	
	@Mock
	private UserRepo userRepo;
	
	@InjectMocks
	private UserService userService;
	
	@SuppressWarnings("deprecation")
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testAddUser() {
		//create a user
		User mockUser = new User();
		mockUser.setAge(22);
		mockUser.setName("Guddu Pandit");
		
		when(userRepo.save(any(User.class))).thenReturn(mockUser);
		
		//save the user
		User newUser = userService.saveUser(mockUser);
		
		//verify the save
		assertEquals("Guddu Pandit", newUser.getName());
	}

}
