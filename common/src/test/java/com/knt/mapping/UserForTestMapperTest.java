package com.knt.mapping;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.knt.core.Env;
import com.knt.core.MappForMybatis;
import com.knt.model.UserForTest;
import com.knt.util.PasswordUtil;

public class UserForTestMapperTest {
	static ApplicationContext context = new ClassPathXmlApplicationContext(
			"/testContext.xml");
	UserForTestMapper mapper;

	@Before
	public void init(){
		MappForMybatis mybatis = Env.getBean("mapperForMybatis");
		mapper = mybatis.getMapper(UserForTestMapper.class);
	}
	@Test
	public void testInsert() {
		UserForTest user = new UserForTest();
		user.setGroupid(1);
		user.setId(4);
		user.setUsername("test");
		user.setPassword(PasswordUtil.entryptPassword(PasswordUtil.getSalt(), "test2"));
		mapper.insert(user);
	}

}
