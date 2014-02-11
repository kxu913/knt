package com.ny6design.service;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ny6design.core.Env;
import com.ny6design.model.User;
import com.ny6design.model.UserDetail;

public class UserServiceTest {
	static ApplicationContext context = new ClassPathXmlApplicationContext(
			"/testContext.xml");
	UserService userService;

	@Before
	public void init() {
		userService = Env.getBean("userService");
	}
	@Test
	public void testGetAllUsers() {
		List<UserDetail> list = userService.getAllUsers();
		assertNotNull(list);
		System.out.println(list.get(0).getUserid());
	}
	
	@Test
	public void testSearchUsers(){
		List<UserDetail> list = userService.searchUsers("2");
		assertNotNull(list);
		System.out.println(list.get(0).getUserid());
	}
	
	@Test
	public void testSave(){
		User user = new User();
		user.setFirstname("Tait");
		user.setLastname("Xie");
		user.setAddressid(24);
		user.setTelephone("13587451234");
		user.setFromid(5);
		user.setFactive("0");
		user.setAdmin(true);
		user.setEmailaddress("admin@gmail.com");
		user.setPassword("123");
		userService.insert(user);
	}

}
