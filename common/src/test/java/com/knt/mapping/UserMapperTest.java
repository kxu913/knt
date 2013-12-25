package com.knt.mapping;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.knt.core.Env;
import com.knt.core.MappForMybatis;
import com.knt.model.User;

public class UserMapperTest {
	static ApplicationContext context = new ClassPathXmlApplicationContext(
			"/testContext.xml");
	UserMapper mapper;

	@Before
	public void init(){
		MappForMybatis mybatis = Env.getBean("mapperForMybatis");
		mapper = mybatis.getMapper(UserMapper.class);
	}
	@Test
	public void testDeleteByPrimaryKey() {
		mapper.deleteByPrimaryKey(5);
	}

	@Test
	public void testInsert() {
		
		User user =  new User();
		user.setBirthday(new Date());
		user.setNickname("xxx");
		user.setId(5);
		user.setSex("1");
		user.setUsername("test");
		mapper.insert(user);
	}

	@Test
	public void testInsertSelective() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectByPrimaryKey() {
		assertNotNull(mapper.selectByPrimaryKey(1));
	}

	@Test
	public void testUpdateByPrimaryKeySelective() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateByPrimaryKey() {
		fail("Not yet implemented");
	}

}
