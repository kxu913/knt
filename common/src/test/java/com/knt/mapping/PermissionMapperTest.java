package com.knt.mapping;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.knt.core.Env;
import com.knt.core.MappForMybatis;
import com.knt.model.Permission;

public class PermissionMapperTest {

	static ApplicationContext context = new ClassPathXmlApplicationContext(
			"/testContext.xml");
	PermissionMapper mapper;

	@Before
	public void init() {
		MappForMybatis mybatis = Env.getBean("mapperForMybatis");
		mapper = mybatis.getMapper(PermissionMapper.class);
	}

	@Test
	public void testGetPemissionByUserName() {
		List<Permission> list = mapper.getPemissionByUserName("test");
		for(Permission per : list){
			System.out.println(per.getDescription());
		}
	}

}
