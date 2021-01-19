package com.vikas.junit.demo.controller;

import static org.mockito.Mockito.when;
import static org.mockito.Matchers.any;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.vikas.junit.demo.model.User;
import com.vikas.junit.demo.service.UserService;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerUnitTest {

	@MockBean
	UserService userService;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testAdduserHappPath() throws Exception {
		User user = new User();
		user.setName("L Lalit");
		
		when(userService.saveUser(any(User.class))).thenReturn(user);
		
		User aUser = new User();
		aUser.setAge(33);
		aUser.setName("L Lalit");
		
		mockMvc.perform(post("/addUser", aUser)).andExpect(status().isOk()).andReturn();
	}
	
	@Test
	public void testAddUserNotHappyPath() throws Exception {
		
		when(userService.saveUser(any(User.class))).thenReturn(null);
		
		User aUser = new User();
		
		aUser.setAge(56);
		
		mockMvc.perform(post("/addUser", aUser)).andExpect(status().is(302)).andReturn();
		
	}
	
	
	
}
